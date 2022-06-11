package lt.viko.eif.tpetrauskas.saitynas_rest;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Cars entity is used to keep list of cars.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "cars")
@Getter
@Setter
public class Cars {

    @XmlElement(name="car")
    private ArrayList<Car> cars;
}
