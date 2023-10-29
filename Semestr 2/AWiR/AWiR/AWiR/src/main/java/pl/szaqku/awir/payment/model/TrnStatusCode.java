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
 * <p>Java class for TrnStatusCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TrnStatusCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Scheduled"/&gt;
 *     &lt;enumeration value="Queue"/&gt;
 *     &lt;enumeration value="Waiting"/&gt;
 *     &lt;enumeration value="Processed"/&gt;
 *     &lt;enumeration value="FundAcctDebited"/&gt;
 *     &lt;enumeration value="Returned"/&gt;
 *     &lt;enumeration value="Cancelled"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TrnStatusCode")
@XmlEnum
public enum TrnStatusCode {

    @XmlEnumValue("Scheduled")
    SCHEDULED("Scheduled"),
    @XmlEnumValue("Queue")
    QUEUE("Queue"),
    @XmlEnumValue("Waiting")
    WAITING("Waiting"),
    @XmlEnumValue("Processed")
    PROCESSED("Processed"),
    @XmlEnumValue("FundAcctDebited")
    FUND_ACCT_DEBITED("FundAcctDebited"),
    @XmlEnumValue("Returned")
    RETURNED("Returned"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled");
    private final String value;

    TrnStatusCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrnStatusCode fromValue(String v) {
        for (TrnStatusCode c: TrnStatusCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
