
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}TransactionIdentifier"/&gt;
 *         &lt;element name="BankTransactionIdentifier" type="{}max35Identifier" minOccurs="0"/&gt;
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
@XmlType(name = "", propOrder = {
    "transactionIdentifier",
    "bankTransactionIdentifier",
    "paymentRefusalInfoDetails"
})
@XmlRootElement(name = "PaymentTransactionList")
public class PaymentTransactionList {

    @XmlElement(name = "TransactionIdentifier", required = true)
    protected String transactionIdentifier;
    @XmlElement(name = "BankTransactionIdentifier")
    protected String bankTransactionIdentifier;
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
     * Gets the value of the bankTransactionIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankTransactionIdentifier() {
        return bankTransactionIdentifier;
    }

    /**
     * Sets the value of the bankTransactionIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankTransactionIdentifier(String value) {
        this.bankTransactionIdentifier = value;
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
