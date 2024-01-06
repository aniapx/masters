
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartyIdentNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PartyIdentNameType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="EAN"/&gt;
 *     &lt;enumeration value="NIP"/&gt;
 *     &lt;enumeration value="Pesel"/&gt;
 *     &lt;enumeration value="Regon"/&gt;
 *     &lt;enumeration value="BankSystemId"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PartyIdentNameType")
@XmlEnum
public enum PartyIdentNameType {

    EAN("EAN"),
    NIP("NIP"),
    @XmlEnumValue("Pesel")
    PESEL("Pesel"),
    @XmlEnumValue("Regon")
    REGON("Regon"),
    @XmlEnumValue("BankSystemId")
    BANK_SYSTEM_ID("BankSystemId");
    private final String value;

    PartyIdentNameType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PartyIdentNameType fromValue(String v) {
        for (PartyIdentNameType c: PartyIdentNameType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
