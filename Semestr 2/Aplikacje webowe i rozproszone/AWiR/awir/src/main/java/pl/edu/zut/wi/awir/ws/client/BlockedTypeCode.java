
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BlockedTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="BlockedTypeCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Administrative"/&gt;
 *     &lt;enumeration value="Debt collector"/&gt;
 *     &lt;enumeration value="Cheque"/&gt;
 *     &lt;enumeration value="ImmediatePayment"/&gt;
 *     &lt;enumeration value="Another"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BlockedTypeCode")
@XmlEnum
public enum BlockedTypeCode {

    @XmlEnumValue("Administrative")
    ADMINISTRATIVE("Administrative"),
    @XmlEnumValue("Debt collector")
    DEBT_COLLECTOR("Debt collector"),
    @XmlEnumValue("Cheque")
    CHEQUE("Cheque"),
    @XmlEnumValue("ImmediatePayment")
    IMMEDIATE_PAYMENT("ImmediatePayment"),
    @XmlEnumValue("Another")
    ANOTHER("Another");
    private final String value;

    BlockedTypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BlockedTypeCode fromValue(String v) {
        for (BlockedTypeCode c: BlockedTypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
