
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdjustmentReasonType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdjustmentReasonType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Return"/&gt;
 *     &lt;enumeration value="Damage"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *     &lt;enumeration value="Deduction"/&gt;
 *     &lt;enumeration value="Agreed"/&gt;
 *     &lt;enumeration value="Discount"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AdjustmentReasonType")
@XmlEnum
public enum AdjustmentReasonType {

    @XmlEnumValue("Return")
    RETURN("Return"),
    @XmlEnumValue("Damage")
    DAMAGE("Damage"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Deduction")
    DEDUCTION("Deduction"),
    @XmlEnumValue("Agreed")
    AGREED("Agreed"),
    @XmlEnumValue("Discount")
    DISCOUNT("Discount");
    private final String value;

    AdjustmentReasonType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdjustmentReasonType fromValue(String v) {
        for (AdjustmentReasonType c: AdjustmentReasonType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
