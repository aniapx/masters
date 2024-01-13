
package pl.edu.zut.wi.awir.ws.server;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{}PaymentIdentifier"/&gt;
 *         &lt;element ref="{}BankServerPaymentIdentifier" minOccurs="0"/&gt;
 *         &lt;element ref="{}PmtCategory" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{}ExecutionDateRequested" minOccurs="0"/&gt;
 *           &lt;element ref="{}DueDate" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{}ImmediatePmt" minOccurs="0"/&gt;
 *         &lt;element ref="{}PayorParty" minOccurs="0"/&gt;
 *         &lt;element ref="{}PayorAccount"/&gt;
 *         &lt;element ref="{}ChargeAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{}PayorFinancialInstitution"/&gt;
 *         &lt;element ref="{}PmtAdditionalInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{}ChargeResponsibility" minOccurs="0"/&gt;
 *         &lt;element ref="{}PaymentStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{}PaymentRejectionInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{}AdditionalDetails" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "paymentIdentifier",
    "bankServerPaymentIdentifier",
    "pmtCategory",
    "executionDateRequested",
    "dueDate",
    "immediatePmt",
    "payorParty",
    "payorAccount",
    "chargeAccount",
    "payorFinancialInstitution",
    "pmtAdditionalInformation",
    "chargeResponsibility",
    "paymentStatus",
    "paymentRejectionInfo",
    "additionalDetails"
})
@XmlRootElement(name = "PaymentHeader")
public class PaymentHeader {

    @XmlElement(name = "PaymentIdentifier", required = true)
    protected String paymentIdentifier;
    @XmlElement(name = "BankServerPaymentIdentifier")
    protected String bankServerPaymentIdentifier;
    @XmlElement(name = "PmtCategory")
    @XmlSchemaType(name = "string")
    protected PmtCatCode pmtCategory;
    @XmlElement(name = "ExecutionDateRequested")
    protected String executionDateRequested;
    @XmlElement(name = "DueDate")
    protected String dueDate;
    @XmlElement(name = "ImmediatePmt")
    protected Boolean immediatePmt;
    @XmlElement(name = "PayorParty")
    protected Party payorParty;
    @XmlElement(name = "PayorAccount", required = true)
    protected Account payorAccount;
    @XmlElement(name = "ChargeAccount")
    protected Account chargeAccount;
    @XmlElement(name = "PayorFinancialInstitution", required = true)
    protected FinancialInstitution payorFinancialInstitution;
    @XmlElement(name = "PmtAdditionalInformation")
    protected Max210Text pmtAdditionalInformation;
    @XmlElement(name = "ChargeResponsibility")
    protected ResponsibilityCode chargeResponsibility;
    @XmlElement(name = "PaymentStatus")
    protected PaymentStatusType paymentStatus;
    @XmlElement(name = "PaymentRejectionInfo")
    protected TransactionRejectionType paymentRejectionInfo;
    @XmlElement(name = "AdditionalDetails")
    protected List<AdditionalDetailsType> additionalDetails;

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
     * Gets the value of the pmtCategory property.
     * 
     * @return
     *     possible object is
     *     {@link PmtCatCode }
     *     
     */
    public PmtCatCode getPmtCategory() {
        return pmtCategory;
    }

    /**
     * Sets the value of the pmtCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link PmtCatCode }
     *     
     */
    public void setPmtCategory(PmtCatCode value) {
        this.pmtCategory = value;
    }

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
     * Gets the value of the chargeAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getChargeAccount() {
        return chargeAccount;
    }

    /**
     * Sets the value of the chargeAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setChargeAccount(Account value) {
        this.chargeAccount = value;
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
     * Gets the value of the pmtAdditionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Max210Text }
     *     
     */
    public Max210Text getPmtAdditionalInformation() {
        return pmtAdditionalInformation;
    }

    /**
     * Sets the value of the pmtAdditionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max210Text }
     *     
     */
    public void setPmtAdditionalInformation(Max210Text value) {
        this.pmtAdditionalInformation = value;
    }

    /**
     * Gets the value of the chargeResponsibility property.
     * 
     * @return
     *     possible object is
     *     {@link ResponsibilityCode }
     *     
     */
    public ResponsibilityCode getChargeResponsibility() {
        return chargeResponsibility;
    }

    /**
     * Sets the value of the chargeResponsibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsibilityCode }
     *     
     */
    public void setChargeResponsibility(ResponsibilityCode value) {
        this.chargeResponsibility = value;
    }

    /**
     * Gets the value of the paymentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentStatusType }
     *     
     */
    public PaymentStatusType getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Sets the value of the paymentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentStatusType }
     *     
     */
    public void setPaymentStatus(PaymentStatusType value) {
        this.paymentStatus = value;
    }

    /**
     * Gets the value of the paymentRejectionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionRejectionType }
     *     
     */
    public TransactionRejectionType getPaymentRejectionInfo() {
        return paymentRejectionInfo;
    }

    /**
     * Sets the value of the paymentRejectionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionRejectionType }
     *     
     */
    public void setPaymentRejectionInfo(TransactionRejectionType value) {
        this.paymentRejectionInfo = value;
    }

    /**
     * Gets the value of the additionalDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalDetailsType }
     * 
     * 
     */
    public List<AdditionalDetailsType> getAdditionalDetails() {
        if (additionalDetails == null) {
            additionalDetails = new ArrayList<AdditionalDetailsType>();
        }
        return this.additionalDetails;
    }

}
