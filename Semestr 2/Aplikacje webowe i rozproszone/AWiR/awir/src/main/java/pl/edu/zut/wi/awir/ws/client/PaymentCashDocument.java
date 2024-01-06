
package pl.edu.zut.wi.awir.ws.client;

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
 *         &lt;element name="ExecutionDateRequested" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerParty" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Party" minOccurs="0"/&gt;
 *         &lt;element name="CustomerAccount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Account"/&gt;
 *         &lt;element name="CustomerFinancialInstitution" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FinancialInstitution" minOccurs="0"/&gt;
 *         &lt;element name="PaymentCashInstitution" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FinancialInstitution" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}PaymentCashDetails"/&gt;
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
    "executionDateRequested",
    "dueDate",
    "customerParty",
    "customerAccount",
    "customerFinancialInstitution",
    "paymentCashInstitution",
    "paymentCashDetails"
})
@XmlRootElement(name = "PaymentCashDocument")
public class PaymentCashDocument {

    @XmlElement(name = "ExecutionDateRequested")
    protected String executionDateRequested;
    @XmlElement(name = "DueDate")
    protected String dueDate;
    @XmlElement(name = "CustomerParty")
    protected Party customerParty;
    @XmlElement(name = "CustomerAccount", required = true)
    protected Account customerAccount;
    @XmlElement(name = "CustomerFinancialInstitution")
    protected FinancialInstitution customerFinancialInstitution;
    @XmlElement(name = "PaymentCashInstitution")
    protected FinancialInstitution paymentCashInstitution;
    @XmlElement(name = "PaymentCashDetails", required = true)
    protected PaymentCashDetails paymentCashDetails;

    /**
     * Gets the value of the executionDateRequested property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionDateRequested() {
        return executionDateRequested;
    }

    /**
     * Sets the value of the executionDateRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionDateRequested(String value) {
        this.executionDateRequested = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueDate(String value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the customerParty property.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getCustomerParty() {
        return customerParty;
    }

    /**
     * Sets the value of the customerParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setCustomerParty(Party value) {
        this.customerParty = value;
    }

    /**
     * Gets the value of the customerAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getCustomerAccount() {
        return customerAccount;
    }

    /**
     * Sets the value of the customerAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setCustomerAccount(Account value) {
        this.customerAccount = value;
    }

    /**
     * Gets the value of the customerFinancialInstitution property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitution }
     *     
     */
    public FinancialInstitution getCustomerFinancialInstitution() {
        return customerFinancialInstitution;
    }

    /**
     * Sets the value of the customerFinancialInstitution property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitution }
     *     
     */
    public void setCustomerFinancialInstitution(FinancialInstitution value) {
        this.customerFinancialInstitution = value;
    }

    /**
     * Gets the value of the paymentCashInstitution property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitution }
     *     
     */
    public FinancialInstitution getPaymentCashInstitution() {
        return paymentCashInstitution;
    }

    /**
     * Sets the value of the paymentCashInstitution property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitution }
     *     
     */
    public void setPaymentCashInstitution(FinancialInstitution value) {
        this.paymentCashInstitution = value;
    }

    /**
     * Gets the value of the paymentCashDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentCashDetails }
     *     
     */
    public PaymentCashDetails getPaymentCashDetails() {
        return paymentCashDetails;
    }

    /**
     * Sets the value of the paymentCashDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentCashDetails }
     *     
     */
    public void setPaymentCashDetails(PaymentCashDetails value) {
        this.paymentCashDetails = value;
    }

}
