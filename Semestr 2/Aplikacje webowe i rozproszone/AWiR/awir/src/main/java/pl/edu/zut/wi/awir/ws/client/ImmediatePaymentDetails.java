
package pl.edu.zut.wi.awir.ws.client;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="TransactionIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BankTransactionIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PmtCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderedAmount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AmountType"/&gt;
 *         &lt;element name="DebitAmount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AmountType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}CurrencyConvertor" minOccurs="0"/&gt;
 *         &lt;element name="PayorParty" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Party" minOccurs="0"/&gt;
 *         &lt;element name="PayorAccount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Account"/&gt;
 *         &lt;element name="PayorFinancialInstitution" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FinancialInstitution"/&gt;
 *         &lt;element name="CustomerPayeeIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PayeeParty" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Party" minOccurs="0"/&gt;
 *         &lt;element name="PayeeAccount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Account"/&gt;
 *         &lt;element name="PayeeFinancialInstitution" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FinancialInstitution"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}RemittanceInformation"/&gt;
 *         &lt;element name="AdditionalDeclaration" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AdditionalDeclarationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}TransactionStatus" minOccurs="0"/&gt;
 *         &lt;element name="TransactionRejection" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}TransactionRejectionType" minOccurs="0"/&gt;
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
    "pmtCategory",
    "orderedAmount",
    "debitAmount",
    "currencyConvertor",
    "payorParty",
    "payorAccount",
    "payorFinancialInstitution",
    "customerPayeeIdentifier",
    "payeeParty",
    "payeeAccount",
    "payeeFinancialInstitution",
    "remittanceInformation",
    "additionalDeclaration",
    "transactionStatus",
    "transactionRejection"
})
@XmlRootElement(name = "ImmediatePaymentDetails")
public class ImmediatePaymentDetails {

    @XmlElement(name = "TransactionIdentifier", required = true)
    protected String transactionIdentifier;
    @XmlElement(name = "BankTransactionIdentifier")
    protected String bankTransactionIdentifier;
    @XmlElement(name = "PmtCategory")
    protected String pmtCategory;
    @XmlElement(name = "OrderedAmount", required = true)
    protected AmountType orderedAmount;
    @XmlElement(name = "DebitAmount")
    protected AmountType debitAmount;
    @XmlElement(name = "CurrencyConvertor")
    protected CurrencyConvertor currencyConvertor;
    @XmlElement(name = "PayorParty")
    protected Party payorParty;
    @XmlElement(name = "PayorAccount", required = true)
    protected Account payorAccount;
    @XmlElement(name = "PayorFinancialInstitution", required = true)
    protected FinancialInstitution payorFinancialInstitution;
    @XmlElement(name = "CustomerPayeeIdentifier")
    protected String customerPayeeIdentifier;
    @XmlElement(name = "PayeeParty")
    protected Party payeeParty;
    @XmlElement(name = "PayeeAccount", required = true)
    protected Account payeeAccount;
    @XmlElement(name = "PayeeFinancialInstitution", required = true)
    protected FinancialInstitution payeeFinancialInstitution;
    @XmlElement(name = "RemittanceInformation", required = true)
    protected RemittanceInformation remittanceInformation;
    @XmlElement(name = "AdditionalDeclaration")
    protected List<AdditionalDeclarationType> additionalDeclaration;
    @XmlElement(name = "TransactionStatus")
    protected TransactionStatus transactionStatus;
    @XmlElement(name = "TransactionRejection")
    protected TransactionRejectionType transactionRejection;

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
     * Gets the value of the pmtCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmtCategory() {
        return pmtCategory;
    }

    /**
     * Sets the value of the pmtCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmtCategory(String value) {
        this.pmtCategory = value;
    }

    /**
     * Gets the value of the orderedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getOrderedAmount() {
        return orderedAmount;
    }

    /**
     * Sets the value of the orderedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setOrderedAmount(AmountType value) {
        this.orderedAmount = value;
    }

    /**
     * Gets the value of the debitAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getDebitAmount() {
        return debitAmount;
    }

    /**
     * Sets the value of the debitAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setDebitAmount(AmountType value) {
        this.debitAmount = value;
    }

    /**
     * Gets the value of the currencyConvertor property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyConvertor }
     *     
     */
    public CurrencyConvertor getCurrencyConvertor() {
        return currencyConvertor;
    }

    /**
     * Sets the value of the currencyConvertor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyConvertor }
     *     
     */
    public void setCurrencyConvertor(CurrencyConvertor value) {
        this.currencyConvertor = value;
    }

    /**
     * Gets the value of the payorParty property.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getPayorParty() {
        return payorParty;
    }

    /**
     * Sets the value of the payorParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setPayorParty(Party value) {
        this.payorParty = value;
    }

    /**
     * Gets the value of the payorAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getPayorAccount() {
        return payorAccount;
    }

    /**
     * Sets the value of the payorAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setPayorAccount(Account value) {
        this.payorAccount = value;
    }

    /**
     * Gets the value of the payorFinancialInstitution property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitution }
     *     
     */
    public FinancialInstitution getPayorFinancialInstitution() {
        return payorFinancialInstitution;
    }

    /**
     * Sets the value of the payorFinancialInstitution property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitution }
     *     
     */
    public void setPayorFinancialInstitution(FinancialInstitution value) {
        this.payorFinancialInstitution = value;
    }

    /**
     * Gets the value of the customerPayeeIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerPayeeIdentifier() {
        return customerPayeeIdentifier;
    }

    /**
     * Sets the value of the customerPayeeIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerPayeeIdentifier(String value) {
        this.customerPayeeIdentifier = value;
    }

    /**
     * Gets the value of the payeeParty property.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getPayeeParty() {
        return payeeParty;
    }

    /**
     * Sets the value of the payeeParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setPayeeParty(Party value) {
        this.payeeParty = value;
    }

    /**
     * Gets the value of the payeeAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getPayeeAccount() {
        return payeeAccount;
    }

    /**
     * Sets the value of the payeeAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setPayeeAccount(Account value) {
        this.payeeAccount = value;
    }

    /**
     * Gets the value of the payeeFinancialInstitution property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitution }
     *     
     */
    public FinancialInstitution getPayeeFinancialInstitution() {
        return payeeFinancialInstitution;
    }

    /**
     * Sets the value of the payeeFinancialInstitution property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitution }
     *     
     */
    public void setPayeeFinancialInstitution(FinancialInstitution value) {
        this.payeeFinancialInstitution = value;
    }

    /**
     * Gets the value of the remittanceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RemittanceInformation }
     *     
     */
    public RemittanceInformation getRemittanceInformation() {
        return remittanceInformation;
    }

    /**
     * Sets the value of the remittanceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformation }
     *     
     */
    public void setRemittanceInformation(RemittanceInformation value) {
        this.remittanceInformation = value;
    }

    /**
     * Gets the value of the additionalDeclaration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalDeclaration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalDeclaration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalDeclarationType }
     * 
     * 
     */
    public List<AdditionalDeclarationType> getAdditionalDeclaration() {
        if (additionalDeclaration == null) {
            additionalDeclaration = new ArrayList<AdditionalDeclarationType>();
        }
        return this.additionalDeclaration;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionStatus }
     *     
     */
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionStatus }
     *     
     */
    public void setTransactionStatus(TransactionStatus value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the transactionRejection property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionRejectionType }
     *     
     */
    public TransactionRejectionType getTransactionRejection() {
        return transactionRejection;
    }

    /**
     * Sets the value of the transactionRejection property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionRejectionType }
     *     
     */
    public void setTransactionRejection(TransactionRejectionType value) {
        this.transactionRejection = value;
    }

}
