
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcctIdentNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AcctIdentNameType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NRB"/&gt;
 *     &lt;enumeration value="IBAN"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AcctIdentNameType")
@XmlEnum
public enum AcctIdentNameType {

    NRB("NRB"),
    IBAN("IBAN"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    AcctIdentNameType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AcctIdentNameType fromValue(String v) {
        for (AcctIdentNameType c: AcctIdentNameType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
