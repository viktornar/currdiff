package lt.viktornar.currdiff.view;


import lombok.Getter;
import lombok.Setter;
import lt.viktornar.currdiff.model.ExchangeRate;
import lt.viktornar.currdiff.service.CurrencyRateService;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
@Scope("request")
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
    private List<ExchangeRate> exchangeRates;

    @Autowired
    CurrencyRateService currencyRateService;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public void onDateSelect(SelectEvent event) {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
        logger.info(String.format("Date selected: %s", format.format(event.getObject())));
        date = (Date)event.getObject();
    }

    public Date getMaxDate(){
        return new GregorianCalendar(2014, Calendar.DECEMBER, 31).getTime();
    }

    public void populateTable() {
        logger.info(String.format("Date to process: %s", format.format(date)));
        exchangeRates = currencyRateService.getRatesByDate(date);
        dataExist = true;
    }

    public void emptyTable() {
        logger.info("Deleting data from table");
        exchangeRates.clear();
        dataExist = false;
    }
}
