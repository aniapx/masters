
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentRefusalStatementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRefusalStatementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}TransactionIdentifier"/&gt;
 *         &lt;element ref="{}PaymentRefusalInfoDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRefusalStatementType", propOrder = {
    "transactionIdentifier",
    "paymentRefusalInfoDetails"
})
public class PaymentRefusalStatementType {

    @XmlElement(name = "TransactionIdentifier", required = true)
    protected String transactionIdentifier;
    @XmlElement(name = "PaymentRefusalInfoDetails", required = true)
    protected PaymentRefusalInfoDetails paymentRefusalInfoDetails;

    /**
     * Gets the value of the transactionIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionIdentifier() {
        return transactionIdentifier;
    }

    /**
     * Sets the value of the transactionIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionIdentifier(String value) {
        this.transactionIdentifier = value;
    }

    /**
     * Gets the value of the paymentRefusalInfoDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentRefusalInfoDetails }
     *     
     */
    public PaymentRefusalInfoDetails getPaymentRefusalInfoDetails() {
        return paymentRefusalInfoDetails;
    }

    /**
     * Sets the value of the paymentRefusalInfoDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentRefusalInfoDetails }
     *     
     */
    public void setPaymentRefusalInfoDetails(PaymentRefusalInfoDetails value) {
        this.paymentRefusalInfoDetails = value;
    }

}
