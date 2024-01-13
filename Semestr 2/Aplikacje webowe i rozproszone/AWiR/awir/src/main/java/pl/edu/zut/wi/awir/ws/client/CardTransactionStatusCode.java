
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardTransactionStatusCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CardTransactionStatusCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Booking"/&gt;
 *     &lt;enumeration value="Pending"/&gt;
 *     &lt;enumeration value="Info"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CardTransactionStatusCode")
@XmlEnum
public enum CardTransactionStatusCode {

    @XmlEnumValue("Booking")
    BOOKING("Booking"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Info")
    INFO("Info");
    private final String value;

    CardTransactionStatusCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardTransactionStatusCode fromValue(String v) {
        for (CardTransactionStatusCode c: CardTransactionStatusCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
