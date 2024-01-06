
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BlockTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BlockTypeCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Card"/&gt;
 *     &lt;enumeration value="Account"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BlockTypeCode")
@XmlEnum
public enum BlockTypeCode {

    @XmlEnumValue("Card")
    CARD("Card"),
    @XmlEnumValue("Account")
    ACCOUNT("Account");
    private final String value;

    BlockTypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BlockTypeCode fromValue(String v) {
        for (BlockTypeCode c: BlockTypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
