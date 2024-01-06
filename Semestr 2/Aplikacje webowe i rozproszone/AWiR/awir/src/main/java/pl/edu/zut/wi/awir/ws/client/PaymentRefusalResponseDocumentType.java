
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentRefusalResponseDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRefusalResponseDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BankPaymentRefusalIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}PaymentRefusalResponseInfoDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRefusalResponseDocumentType", propOrder = {
    "bankPaymentRefusalIdentifier",
    "paymentRefusalResponseInfoDetails"
})
public class PaymentRefusalResponseDocumentType {

    @XmlElement(name = "BankPaymentRefusalIdentifier", required = true)
    protected String bankPaymentRefusalIdentifier;
    @XmlElement(name = "PaymentRefusalResponseInfoDetails", required = true)
    protected PaymentRefusalResponseInfoDetails paymentRefusalResponseInfoDetails;

    /**
     * Gets the value of the bankPaymentRefusalIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankPaymentRefusalIdentifier() {
        return bankPaymentRefusalIdentifier;
    }

    /**
     * Sets the value of the bankPaymentRefusalIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankPaymentRefusalIdentifier(String value) {
        this.bankPaymentRefusalIdentifier = value;
    }

    /**
     * Gets the value of the paymentRefusalResponseInfoDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentRefusalResponseInfoDetails }
     *     
     */
    public PaymentRefusalResponseInfoDetails getPaymentRefusalResponseInfoDetails() {
        return paymentRefusalResponseInfoDetails;
    }

    /**
     * Sets the value of the paymentRefusalResponseInfoDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentRefusalResponseInfoDetails }
     *     
     */
    public void setPaymentRefusalResponseInfoDetails(PaymentRefusalResponseInfoDetails value) {
        this.paymentRefusalResponseInfoDetails = value;
    }

}
