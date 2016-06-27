package lt.viktornar.currdiff.service;

import lt.viktornar.currdiff.model.ExchangeRates;
import lt.viktornar.currdiff.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by v.nareiko on 2016-06-26.
 */
@Service("currencyRateService")
public class CurrencyRateService {
    @Autowired
    private SettingsService settingsService;

    Logger logger = LoggerFactory.getLogger(CurrencyRateService.class);

    @Autowired
    private SimpleDateFormat customSimpleDateFormat;

    public List<Item> getRatesByDate(Date date) {
        String dateParameter = customSimpleDateFormat.format(date);

        logger.info(String.format("Trying to get rates by given date [%s]", dateParameter));

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("Date", dateParameter);

        RestTemplate restTemplate = new RestTemplate();
        ExchangeRates result = restTemplate.postForObject(settingsService.getServiceUrl(), map, ExchangeRates.class);

        logger.info(String.format("Got rates by given date [%s]", dateParameter));

        return result.getItems();
    }

    public Date subtractDaysFromDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        if (days > 0) {
            days = -days;
        }

        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public List<Item> getChangesOfRatesByDate(Date date) {
        Date prevDayDate = subtractDaysFromDate(date, 1);

        final List<Item> itemsOfGivenDate = getRatesByDate(date);
        final List<Item> itemsOfPrevDate = getRatesByDate(prevDayDate);

        Collections.sort(itemsOfGivenDate);
        Collections.sort(itemsOfPrevDate);

        List<Item> diffItems = new ArrayList<>();

        for (int i = 0; i < itemsOfGivenDate.size(); i++) {
            final Item givenDateItem = itemsOfGivenDate.get(i);
            final Item prevDateItem = itemsOfPrevDate.get(i);
            Item itemToReturn = new Item();
            BeanUtils.copyProperties(givenDateItem, itemToReturn);
            Float diffRate = givenDateItem.getRate() - prevDateItem.getRate();

            float percentage = (diffRate / prevDateItem.getRate()) * 100f;

            itemToReturn.setRateChangeInPercentage(roundRateChange(percentage));
            itemToReturn.setRateChange(roundRateChange(diffRate));

            diffItems.add(itemToReturn);
        }

        return diffItems;
    }

    private Float roundRateChange(Float rateChange) {
        rateChange = rateChange * 10000.0f;
        rateChange = (float) Math.round(rateChange);
        rateChange = rateChange / 10000.0f;
        return rateChange;
    }
}
