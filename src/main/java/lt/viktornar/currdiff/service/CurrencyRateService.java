package lt.viktornar.currdiff.service;

import lt.viktornar.currdiff.model.ExchangeRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by v.nareiko on 2016-06-26.
 */
@Service("currencyRateService")
public class CurrencyRateService {

    Logger logger = LoggerFactory.getLogger(CurrencyRateService.class);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public List<ExchangeRate> getRatesByDate(Date date) {
        logger.info(String.format("Trying to get rates by given date [%s]", format.format(date)));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(String.format("Got rates by given date [%s]", format.format(date)));
        return getDummyValues();
    }

    private List<ExchangeRate> getDummyValues() {
        List<ExchangeRate> rates = new ArrayList<>();
        rates.add(new ExchangeRate(new Date(2014,12,12), "AZN", 1, 2.4030f, "LTL per 1 currency"));
        rates.add(new ExchangeRate(new Date(2014,12,12), "AZN", 1, 2.4030f, "LTL per 1 currency"));
        rates.add(new ExchangeRate(new Date(2014,12,12), "AZN", 1, 2.4030f, "LTL per 1 currency"));
        rates.add(new ExchangeRate(new Date(2014,12,12), "AZN", 1, 2.4030f, "LTL per 1 currency"));
        rates.add(new ExchangeRate(new Date(2014,12,12), "AZN", 1, 2.4030f, "LTL per 1 currency"));
        rates.add(new ExchangeRate(new Date(2014,12,12), "AZN", 1, 2.4030f, "LTL per 1 currency"));
        return rates;
    }
}
