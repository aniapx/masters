
package pl.edu.zut.wi.awir.ws.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for DurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DurationType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;decimal"&gt;
 *       &lt;attribute name="DurationCode" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}DurationAtrType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DurationType", propOrder = {
    "value"
})
public class DurationType {

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "DurationCode")
    protected DurationAtrType durationCode;

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
     * Gets the value of the durationCode property.
     * 
     * @return
     *     possible object is
     *     {@link DurationAtrType }
     *     
     */
    public DurationAtrType getDurationCode() {
        return durationCode;
    }

    /**
     * Sets the value of the durationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationAtrType }
     *     
     */
    public void setDurationCode(DurationAtrType value) {
        this.durationCode = value;
    }

}
