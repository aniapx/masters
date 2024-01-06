
package pl.edu.zut.wi.awir.ws.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentRefusalDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRefusalDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BankServerPaymentIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}PaymentRefusalInfoDetails" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}PaymentTransactionList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRefusalDocumentType", propOrder = {
    "paymentIdentifier",
    "bankServerPaymentIdentifier",
    "paymentRefusalInfoDetails",
    "paymentTransactionList"
})
public class PaymentRefusalDocumentType {

    @XmlElement(name = "PaymentIdentifier", required = true)
    protected String paymentIdentifier;
    @XmlElement(name = "BankServerPaymentIdentifier")
    protected String bankServerPaymentIdentifier;
    @XmlElement(name = "PaymentRefusalInfoDetails")
    protected PaymentRefusalInfoDetails paymentRefusalInfoDetails;
    @XmlElement(name = "PaymentTransactionList")
    protected List<PaymentTransactionList> paymentTransactionList;

    /**
     * Gets the value of the paymentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentIdentifier() {
        return paymentIdentifier;
    }

    /**
     * Sets the value of the paymentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentIdentifier(String value) {
        this.paymentIdentifier = value;
    }

    /**
     * Gets the value of the bankServerPaymentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankServerPaymentIdentifier() {
        return bankServerPaymentIdentifier;
    }

    /**
     * Sets the value of the bankServerPaymentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankServerPaymentIdentifier(String value) {
        this.bankServerPaymentIdentifier = value;
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

    /**
     * Gets the value of the paymentTransactionList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTransactionList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTransactionList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransactionList }
     * 
     * 
     */
    public List<PaymentTransactionList> getPaymentTransactionList() {
        if (paymentTransactionList == null) {
            paymentTransactionList = new ArrayList<PaymentTransactionList>();
        }
        return this.paymentTransactionList;
    }

}
