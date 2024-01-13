
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PmtCatCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="PmtCatCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Domestic"/&gt;
 *     &lt;enumeration value="International"/&gt;
 *     &lt;enumeration value="US"/&gt;
 *     &lt;enumeration value="SEPA"/&gt;
 *     &lt;enumeration value="InternationalCheque"/&gt;
 *     &lt;enumeration value="MPP"/&gt;
 *     &lt;enumeration value="Card"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PmtCatCode")
@XmlEnum
public enum PmtCatCode {

    @XmlEnumValue("Domestic")
    DOMESTIC("Domestic"),
    @XmlEnumValue("International")
    INTERNATIONAL("International"),
    US("US"),
    SEPA("SEPA"),
    @XmlEnumValue("InternationalCheque")
    INTERNATIONAL_CHEQUE("InternationalCheque"),
    MPP("MPP"),
    @XmlEnumValue("Card")
    CARD("Card");
    private final String value;

    PmtCatCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PmtCatCode fromValue(String v) {
        for (PmtCatCode c: PmtCatCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
