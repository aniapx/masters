
package pl.edu.zut.wi.awir.ws.server;

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
 *         &lt;element ref="{}TransactionIdentifier"/&gt;
 *         &lt;element ref="{}BankTransactionIdentifier" minOccurs="0"/&gt;
 *         &lt;element ref="{}OrderedAmount"/&gt;
 *         &lt;element ref="{}DebitAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{}ImmediatePmt" minOccurs="0"/&gt;
 *         &lt;element name="ExecutionDate" type="{}Date" minOccurs="0"/&gt;
 *         &lt;element ref="{}CurrencyConvertor" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{}CustomerPayeeIdentifier" minOccurs="0"/&gt;
 *           &lt;element ref="{}PayeeParty" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{}PayeeAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{}CardIdentifier" minOccurs="0"/&gt;
 *         &lt;element ref="{}PayeeFinancialInstitution"/&gt;
 *         &lt;element ref="{}Charge" minOccurs="0"/&gt;
 *         &lt;element ref="{}RegulatoryReport" minOccurs="0"/&gt;
 *         &lt;element ref="{}RemittanceInformation"/&gt;
 *         &lt;element ref="{}AdditionalDeclaration" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CloseMicroAccount" type="{}Indicator" minOccurs="0"/&gt;
 *         &lt;element ref="{}TransactionStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{}TransactionRejection" minOccurs="0"/&gt;
 *         &lt;element ref="{}SoldCheque" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "orderedAmount",
    "debitAmount",
    "immediatePmt",
    "executionDate",
    "currencyConvertor",
    "customerPayeeIdentifier",
    "payeeParty",
    "payeeAccount",
    "cardIdentifier",
    "payeeFinancialInstitution",
    "charge",
    "regulatoryReport",
    "remittanceInformation",
    "additionalDeclaration",
    "closeMicroAccount",
    "transactionStatus",
    "transactionRejection",
    "soldCheque"
})
@XmlRootElement(name = "PaymentLineItem")
public class PaymentLineItem {

    @XmlElement(name = "TransactionIdentifier", required = true)
    protected String transactionIdentifier;
    @XmlElement(name = "BankTransactionIdentifier")
    protected String bankTransactionIdentifier;
    @XmlElement(name = "OrderedAmount", required = true)
    protected AmountType orderedAmount;
    @XmlElement(name = "DebitAmount")
    protected AmountType debitAmount;
    @XmlElement(name = "ImmediatePmt")
    protected Boolean immediatePmt;
    @XmlElement(name = "ExecutionDate")
    protected String executionDate;
    @XmlElement(name = "CurrencyConvertor")
    protected CurrencyConvertor currencyConvertor;
    @XmlElement(name = "CustomerPayeeIdentifier")
    protected String customerPayeeIdentifier;
    @XmlElement(name = "PayeeParty")
    protected Party payeeParty;
    @XmlElement(name = "PayeeAccount")
    protected Account payeeAccount;
    @XmlElement(name = "CardIdentifier")
    protected CardIdentifier cardIdentifier;
    @XmlElement(name = "PayeeFinancialInstitution", required = true)
    protected FinancialInstitution payeeFinancialInstitution;
    @XmlElement(name = "Charge")
    protected Charge charge;
    @XmlElement(name = "RegulatoryReport")
    protected RegulatoryReport regulatoryReport;
    @XmlElement(name = "RemittanceInformation", required = true)
    protected RemittanceInformation remittanceInformation;
    @XmlElement(name = "AdditionalDeclaration")
    protected List<AdditionalDeclarationType> additionalDeclaration;
    @XmlElement(name = "CloseMicroAccount")
    protected Boolean closeMicroAccount;
    @XmlElement(name = "TransactionStatus")
    protected TransactionStatus transactionStatus;
    @XmlElement(name = "TransactionRejection")
    protected TransactionRejectionType transactionRejection;
    @XmlElement(name = "SoldCheque")
    protected List<String> soldCheque;

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
     * Gets the value of the immediatePmt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isImmediatePmt() {
        return immediatePmt;
    }

    /**
     * Sets the value of the immediatePmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setImmediatePmt(Boolean value) {
        this.immediatePmt = value;
    }

    /**
     * Gets the value of the executionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionDate() {
        return executionDate;
    }

    /**
     * Sets the value of the executionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionDate(String value) {
        this.executionDate = value;
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
     * Gets the value of the cardIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link CardIdentifier }
     *     
     */
    public CardIdentifier getCardIdentifier() {
        return cardIdentifier;
    }

    /**
     * Sets the value of the cardIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardIdentifier }
     *     
     */
    public void setCardIdentifier(CardIdentifier value) {
        this.cardIdentifier = value;
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
     * Gets the value of the charge property.
     * 
     * @return
     *     possible object is
     *     {@link Charge }
     *     
     */
    public Charge getCharge() {
        return charge;
    }

    /**
     * Sets the value of the charge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Charge }
     *     
     */
    public void setCharge(Charge value) {
        this.charge = value;
    }

    /**
     * Gets the value of the regulatoryReport property.
     * 
     * @return
     *     possible object is
     *     {@link RegulatoryReport }
     *     
     */
    public RegulatoryReport getRegulatoryReport() {
        return regulatoryReport;
    }

    /**
     * Sets the value of the regulatoryReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegulatoryReport }
     *     
     */
    public void setRegulatoryReport(RegulatoryReport value) {
        this.regulatoryReport = value;
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
     * Gets the value of the closeMicroAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCloseMicroAccount() {
        return closeMicroAccount;
    }

    /**
     * Sets the value of the closeMicroAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCloseMicroAccount(Boolean value) {
        this.closeMicroAccount = value;
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

    /**
     * Gets the value of the soldCheque property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soldCheque property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoldCheque().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSoldCheque() {
        if (soldCheque == null) {
            soldCheque = new ArrayList<String>();
        }
        return this.soldCheque;
    }

}
