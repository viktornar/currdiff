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
 * Used as POJO for data exchange between remote service and prime faces components.
 *
 * @author v.nareiko
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

    // TODO: Change Float object to double primitive type
    @Getter
    @Setter
    private Float rateChange;

    // TODO: Change Float object to double primitive type
    @Getter
    @Setter
    private Float rateChangeInPercentage;

    @Override
    public int compareTo(Item o) {
        // Sort collection in descending order.
        if (this.getRate() > o.getRate()){
            return -1;
        }else{
            return 1;
        }
    }
}
