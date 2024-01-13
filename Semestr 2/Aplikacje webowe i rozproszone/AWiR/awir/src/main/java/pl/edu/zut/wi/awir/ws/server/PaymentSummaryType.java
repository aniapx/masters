
package pl.edu.zut.wi.awir.ws.server;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentSummaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentSummaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SummaryAmount" type="{}AmountType"/&gt;
 *         &lt;element name="TransactionsQuantity" type="{}SumQuantity"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentSummaryType", propOrder = {
    "summaryAmount",
    "transactionsQuantity"
})
public class PaymentSummaryType {

    @XmlElement(name = "SummaryAmount", required = true)
    protected AmountType summaryAmount;
    @XmlElement(name = "TransactionsQuantity", required = true)
    protected BigInteger transactionsQuantity;

    /**
     * Gets the value of the summaryAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getSummaryAmount() {
        return summaryAmount;
    }

    /**
     * Sets the value of the summaryAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setSummaryAmount(AmountType value) {
        this.summaryAmount = value;
    }

    /**
     * Gets the value of the transactionsQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTransactionsQuantity() {
        return transactionsQuantity;
    }

    /**
     * Sets the value of the transactionsQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTransactionsQuantity(BigInteger value) {
        this.transactionsQuantity = value;
    }

}
