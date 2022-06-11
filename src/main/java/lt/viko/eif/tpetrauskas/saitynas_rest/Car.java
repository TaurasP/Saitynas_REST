package lt.viko.eif.tpetrauskas.saitynas_rest;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Car entity is used for car's object creation.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "car")
@Getter
@Setter
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "id")
    private int id;

    @XmlAttribute(name="uri")
    private String uri;

    @XmlElement(name = "manufacturer")
    private String manufacturer;

    @XmlElement(name = "model")
    private String model;

    @XmlElement(name = "year")
    private int year;

    @XmlElement(name = "isAWD")
    private boolean isAWD;
}
