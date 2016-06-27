package lt.viktornar.currdiff.view;


import lombok.Getter;
import lombok.Setter;
import lt.viktornar.currdiff.model.Item;
import lt.viktornar.currdiff.service.CurrencyRateService;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by v.nareiko on 2016-06-26.
 */

@Component(value="indexView")
@Scope("session")
public class IndexView implements Serializable {
    private static final long serialVersionUID = 1L;

    Logger logger = LoggerFactory.getLogger(IndexView.class);

    @Getter
    @Setter
    private Date date;

    @Setter
    private Date maxDate;

    @Setter
    @Getter
    private boolean dataExist;

    @Getter
    @Setter
    private List<Item> items;

    @Autowired
    private CurrencyRateService currencyRateService;

    @Autowired
    private SimpleDateFormat customSimpleDateFormat;

    public void onDateSelect(SelectEvent event) {
        logger.info(String.format("Date selected: %s", customSimpleDateFormat.format(event.getObject())));
        date = (Date)event.getObject();
    }

    public Date getMaxDate(){
        return new GregorianCalendar(2014, Calendar.DECEMBER, 31).getTime();
    }

    public void populateTable() {
        logger.info(String.format("Date to process: %s", customSimpleDateFormat.format(date)));
        items = currencyRateService.getChangesOfRatesByDate(date);

        if (items.size() > 0) {
            dataExist = true;
        }
    }

    public void emptyTable() {
        logger.info("Deleting data from table");
        items.clear();
        dataExist = false;
    }
}
