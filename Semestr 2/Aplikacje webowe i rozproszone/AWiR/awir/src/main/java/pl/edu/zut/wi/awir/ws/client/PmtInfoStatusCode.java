
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PmtInfoStatusCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="PmtInfoStatusCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Scheduled"/&gt;
 *     &lt;enumeration value="Sent"/&gt;
 *     &lt;enumeration value="Returned"/&gt;
 *     &lt;enumeration value="Response"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PmtInfoStatusCode")
@XmlEnum
public enum PmtInfoStatusCode {

    @XmlEnumValue("Scheduled")
    SCHEDULED("Scheduled"),
    @XmlEnumValue("Sent")
    SENT("Sent"),
    @XmlEnumValue("Returned")
    RETURNED("Returned"),
    @XmlEnumValue("Response")
    RESPONSE("Response");
    private final String value;

    PmtInfoStatusCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PmtInfoStatusCode fromValue(String v) {
        for (PmtInfoStatusCode c: PmtInfoStatusCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
