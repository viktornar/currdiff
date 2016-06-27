package lt.viktornar.currdiff.comparator;

import lt.viktornar.currdiff.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by v.nareiko on 2016-06-27.
 */
public class CompareTest {
    List<Item> items = new ArrayList<>();

    @Before
    public void setUp() throws ParseException {
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        item1.setCurrency("B");
        item1.setRateChangeInPercentage(2f);
        item1.setRate(2f);
        item2.setCurrency("A");
        item2.setRateChangeInPercentage(1f);
        item2.setRate(1f);
        item3.setCurrency("C");
        item3.setRateChangeInPercentage(3f);
        item3.setRate(3f);

        items = Arrays.asList(item1, item2, item3);
    }

    @Test
    public void sortCurrency() {
        Collections.sort(items, new CurrencyComparator());

        Assert.assertEquals("A", items.get(0).getCurrency());
        Assert.assertEquals("B", items.get(1).getCurrency());
        Assert.assertEquals("C", items.get(2).getCurrency());
    }

    @Test
    public void sortRateExchangeInPercentage() {
        Collections.sort(items, new RateChangeInPercentageComparator());

        Assert.assertTrue(3f == items.get(0).getRateChangeInPercentage());
        Assert.assertTrue(2f == items.get(1).getRateChangeInPercentage());
        Assert.assertTrue(1f == items.get(2).getRateChangeInPercentage());
    }

    @Test
    public void sortRate() {
        Collections.sort(items, new RateChangeInPercentageComparator());

        Assert.assertTrue(3f == items.get(0).getRateChangeInPercentage());
        Assert.assertTrue(2f == items.get(1).getRateChangeInPercentage());
        Assert.assertTrue(1f == items.get(2).getRateChangeInPercentage());
    }
}
