package lt.viktornar.currdiff.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by v.nareiko on 2016-06-26.
 */
@XmlRootElement(name="ExchangeRates")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRates {
    @Getter
    @Setter
    @XmlElement(name = "item")
    private List<Item> items;
}
