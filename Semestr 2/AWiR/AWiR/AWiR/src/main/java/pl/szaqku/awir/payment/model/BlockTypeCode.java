//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.06 at 08:41:21 PM CET 
//


package pl.szaqku.awir.payment.model;

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