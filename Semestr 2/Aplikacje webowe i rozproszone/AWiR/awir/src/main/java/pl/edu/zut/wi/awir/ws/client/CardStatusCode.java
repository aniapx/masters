
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardStatusCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CardStatusCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Active"/&gt;
 *     &lt;enumeration value="Inactive"/&gt;
 *     &lt;enumeration value="Reserved"/&gt;
 *     &lt;enumeration value="Closed"/&gt;
 *     &lt;enumeration value="Blocked"/&gt;
 *     &lt;enumeration value="InTheCourseOfClosing"/&gt;
 *     &lt;enumeration value="InTheCourseOfReserving"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CardStatusCode")
@XmlEnum
public enum CardStatusCode {

    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Inactive")
    INACTIVE("Inactive"),
    @XmlEnumValue("Reserved")
    RESERVED("Reserved"),
    @XmlEnumValue("Closed")
    CLOSED("Closed"),
    @XmlEnumValue("Blocked")
    BLOCKED("Blocked"),
    @XmlEnumValue("InTheCourseOfClosing")
    IN_THE_COURSE_OF_CLOSING("InTheCourseOfClosing"),
    @XmlEnumValue("InTheCourseOfReserving")
    IN_THE_COURSE_OF_RESERVING("InTheCourseOfReserving");
    private final String value;

    CardStatusCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardStatusCode fromValue(String v) {
        for (CardStatusCode c: CardStatusCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
