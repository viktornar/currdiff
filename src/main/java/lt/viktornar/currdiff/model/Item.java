package lt.viktornar.currdiff.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by v.nareiko on 2016-06-26.
 */
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Comparable<Item>{
    public Item() {
    }

    @Getter
    @Setter
    private String date;

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

    @Getter
    @Setter
    private Float rateChange;

    @Getter
    @Setter
    private Float rateChangeInPercentage;

    @Override
    public int compareTo(Item o) {
        if (this.getRate() > o.getRate()){
            return -1;
        }else{
            return 1;
        }
    }
}
