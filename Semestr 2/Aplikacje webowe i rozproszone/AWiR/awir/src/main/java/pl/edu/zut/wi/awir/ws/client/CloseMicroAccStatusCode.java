
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CloseMicroAccStatusCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CloseMicroAccStatusCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Closed"/&gt;
 *     &lt;enumeration value="UnclosedPositiveBalance"/&gt;
 *     &lt;enumeration value="UnclosedOther"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CloseMicroAccStatusCode")
@XmlEnum
public enum CloseMicroAccStatusCode {

    @XmlEnumValue("Closed")
    CLOSED("Closed"),
    @XmlEnumValue("UnclosedPositiveBalance")
    UNCLOSED_POSITIVE_BALANCE("UnclosedPositiveBalance"),
    @XmlEnumValue("UnclosedOther")
    UNCLOSED_OTHER("UnclosedOther");
    private final String value;

    CloseMicroAccStatusCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CloseMicroAccStatusCode fromValue(String v) {
        for (CloseMicroAccStatusCode c: CloseMicroAccStatusCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
