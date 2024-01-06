
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcctTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="AcctTypeCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ROR"/&gt;
 *     &lt;enumeration value="RB"/&gt;
 *     &lt;enumeration value="LOK"/&gt;
 *     &lt;enumeration value="KRE"/&gt;
 *     &lt;enumeration value="KK"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AcctTypeCode")
@XmlEnum
public enum AcctTypeCode {

    ROR("ROR"),
    RB("RB"),
    LOK("LOK"),
    KRE("KRE"),
    KK("KK"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    AcctTypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AcctTypeCode fromValue(String v) {
        for (AcctTypeCode c: AcctTypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
