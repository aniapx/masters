
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SeverityCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="SeverityCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Error"/&gt;
 *     &lt;enumeration value="Warn"/&gt;
 *     &lt;enumeration value="Info"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SeverityCode")
@XmlEnum
public enum SeverityCode {

    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Warn")
    WARN("Warn"),
    @XmlEnumValue("Info")
    INFO("Info");
    private final String value;

    SeverityCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SeverityCode fromValue(String v) {
        for (SeverityCode c: SeverityCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
