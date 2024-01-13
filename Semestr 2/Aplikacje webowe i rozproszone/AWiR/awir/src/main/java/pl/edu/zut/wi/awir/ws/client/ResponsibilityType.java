
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponsibilityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="ResponsibilityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OUR"/&gt;
 *     &lt;enumeration value="BEN"/&gt;
 *     &lt;enumeration value="SHA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ResponsibilityType")
@XmlEnum
public enum ResponsibilityType {

    OUR,
    BEN,
    SHA;

    public String value() {
        return name();
    }

    public static ResponsibilityType fromValue(String v) {
        return valueOf(v);
    }

}
