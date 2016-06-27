package lt.viktornar.currdiff.service;

import lt.viktornar.currdiff.config.AppConfig;
import lt.viktornar.currdiff.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by v.nareiko on 2016-06-26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CurrencyRateServiceTest {
    @Autowired
    private ApplicationContext applicationContext;

    private CurrencyRateService currencyRateService;

    @Before
    public void setUp() throws ParseException {
        currencyRateService = (CurrencyRateService) applicationContext.getBean("currencyRateService");
    }

    @Test
    public void getRatesByDate() throws Exception {
        Date date = new GregorianCalendar(2014, Calendar.SEPTEMBER, 15).getTime();
        List<Item> items = currencyRateService.getRatesByDate(date);

        Item item = items.get(0);

        Assert.assertTrue(item.getRate() > 0);
        Assert.assertFalse(item.getCurrency().isEmpty());
        Assert.assertTrue(item.getQuantity() > 0);
        Assert.assertFalse(item.getUnit().isEmpty());

        // Convert date as string to java Date object
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        Date result = df.parse(item.getDate());

        Assert.assertEquals(date.getTime(), result.getTime());
    }

    @Test
    public void subtractDaysFromDate() throws Exception {
        Date date = new GregorianCalendar(2014, Calendar.SEPTEMBER, 15).getTime();
        Date theDayBefore = new GregorianCalendar(2014, Calendar.SEPTEMBER, 14).getTime();

        Date subtractedDate = currencyRateService.subtractDaysFromDate(date, 1);

        Assert.assertEquals(theDayBefore.getTime(), subtractedDate.getTime());
    }

    @Test
    public void getChangesOfRatesByDate() throws Exception {
        Date date = new GregorianCalendar(2014, Calendar.SEPTEMBER, 15).getTime();
        List<Item> items = currencyRateService.getChangesOfRatesByDate(date);

        for (Item item : items) {
            if (item.getCurrency().contains("AED")) {
                Float val = item.getRateChange();
                System.out.println(val);
                // 0.0111 value calculated by hand for given date
                Assert.assertTrue(val == 0.0111f);
            }
        }
    }
}