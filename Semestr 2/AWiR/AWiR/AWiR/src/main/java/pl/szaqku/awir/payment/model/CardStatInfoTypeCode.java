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
 * <p>Java class for CardStatInfoTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CardStatInfoTypeCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BankStatement"/&gt;
 *     &lt;enumeration value="InterimStatement"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CardStatInfoTypeCode")
@XmlEnum
public enum CardStatInfoTypeCode {

    @XmlEnumValue("BankStatement")
    BANK_STATEMENT("BankStatement"),
    @XmlEnumValue("InterimStatement")
    INTERIM_STATEMENT("InterimStatement");
    private final String value;

    CardStatInfoTypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardStatInfoTypeCode fromValue(String v) {
        for (CardStatInfoTypeCode c: CardStatInfoTypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
