
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommunicationCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommunicationCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="fax"/&gt;
 *     &lt;enumeration value="email"/&gt;
 *     &lt;enumeration value="phone"/&gt;
 *     &lt;enumeration value="http"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CommunicationCode")
@XmlEnum
public enum CommunicationCode {

    @XmlEnumValue("fax")
    FAX("fax"),
    @XmlEnumValue("email")
    EMAIL("email"),
    @XmlEnumValue("phone")
    PHONE("phone"),
    @XmlEnumValue("http")
    HTTP("http");
    private final String value;

    CommunicationCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommunicationCode fromValue(String v) {
        for (CommunicationCode c: CommunicationCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
