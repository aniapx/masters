
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BalTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="BalTypeCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Opening"/&gt;
 *     &lt;enumeration value="Closing"/&gt;
 *     &lt;enumeration value="Current"/&gt;
 *     &lt;enumeration value="Available"/&gt;
 *     &lt;enumeration value="Blocked"/&gt;
 *     &lt;enumeration value="Booked"/&gt;
 *     &lt;enumeration value="Expected"/&gt;
 *     &lt;enumeration value="Overdraft"/&gt;
 *     &lt;enumeration value="CreditLineLimit"/&gt;
 *     &lt;enumeration value="CashAvailable"/&gt;
 *     &lt;enumeration value="WithdrawalCashLimit"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BalTypeCode")
@XmlEnum
public enum BalTypeCode {

    @XmlEnumValue("Opening")
    OPENING("Opening"),
    @XmlEnumValue("Closing")
    CLOSING("Closing"),
    @XmlEnumValue("Current")
    CURRENT("Current"),
    @XmlEnumValue("Available")
    AVAILABLE("Available"),
    @XmlEnumValue("Blocked")
    BLOCKED("Blocked"),
    @XmlEnumValue("Booked")
    BOOKED("Booked"),
    @XmlEnumValue("Expected")
    EXPECTED("Expected"),
    @XmlEnumValue("Overdraft")
    OVERDRAFT("Overdraft"),
    @XmlEnumValue("CreditLineLimit")
    CREDIT_LINE_LIMIT("CreditLineLimit"),
    @XmlEnumValue("CashAvailable")
    CASH_AVAILABLE("CashAvailable"),
    @XmlEnumValue("WithdrawalCashLimit")
    WITHDRAWAL_CASH_LIMIT("WithdrawalCashLimit");
    private final String value;

    BalTypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BalTypeCode fromValue(String v) {
        for (BalTypeCode c: BalTypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
