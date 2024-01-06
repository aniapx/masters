
package pl.edu.zut.wi.awir.ws.server;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for VATAmountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VATAmountType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;&gt;Decimal12.2"&gt;
 *       &lt;attribute name="AmountCurrencyIdentificationCode" type="{}CurrencyCodeType" default="PLN" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VATAmountType", propOrder = {
    "value"
})
public class VATAmountType {

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "AmountCurrencyIdentificationCode")
    protected String amountCurrencyIdentificationCode;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the amountCurrencyIdentificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountCurrencyIdentificationCode() {
        if (amountCurrencyIdentificationCode == null) {
            return "PLN";
        } else {
            return amountCurrencyIdentificationCode;
        }
    }

    /**
     * Sets the value of the amountCurrencyIdentificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountCurrencyIdentificationCode(String value) {
        this.amountCurrencyIdentificationCode = value;
    }

}
