
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="AddressTypeCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Home"/&gt;
 *     &lt;enumeration value="Office"/&gt;
 *     &lt;enumeration value="Correspondence"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AddressTypeCode")
@XmlEnum
public enum AddressTypeCode {

    @XmlEnumValue("Home")
    HOME("Home"),
    @XmlEnumValue("Office")
    OFFICE("Office"),
    @XmlEnumValue("Correspondence")
    CORRESPONDENCE("Correspondence");
    private final String value;

    AddressTypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressTypeCode fromValue(String v) {
        for (AddressTypeCode c: AddressTypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
