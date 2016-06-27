package lt.viktornar.currdiff.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by v.nareiko on 2016-06-26.
 */
public class ExchangeRate {
    public ExchangeRate(Date date, String currency, Integer quantity, Float rate, String unit) {
        this.date = date;
        this.currency = currency;
        this.quantity = quantity;
        this.rate = rate;
        this.unit = unit;
    }

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private String currency;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Float rate;

    @Getter
    @Setter
    private String unit;
}
