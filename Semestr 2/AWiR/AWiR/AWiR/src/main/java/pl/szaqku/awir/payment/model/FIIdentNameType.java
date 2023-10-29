//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.06 at 08:41:21 PM CET 
//


package pl.szaqku.awir.payment.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FIIdentNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FIIdentNameType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BIC"/&gt;
 *     &lt;enumeration value="BNR"/&gt;
 *     &lt;enumeration value="KKF"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FIIdentNameType")
@XmlEnum
public enum FIIdentNameType {

    BIC("BIC"),
    BNR("BNR"),
    KKF("KKF"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    FIIdentNameType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FIIdentNameType fromValue(String v) {
        for (FIIdentNameType c: FIIdentNameType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
