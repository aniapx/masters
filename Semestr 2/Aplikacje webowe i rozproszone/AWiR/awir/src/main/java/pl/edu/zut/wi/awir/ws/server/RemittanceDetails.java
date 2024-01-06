
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
 *         &lt;element name="DocumentIdentifier" type="{}max35Identifier"/&gt;
 *         &lt;element name="IssueDate" type="{}Date" minOccurs="0"/&gt;
 *         &lt;element name="PaymentDate" type="{}Date" minOccurs="0"/&gt;
 *         &lt;element name="AmountPaid" type="{}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="AmountDue" type="{}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="DocumentRecipient" type="{}PartyIdentType" minOccurs="0"/&gt;
 *         &lt;element name="DocumentIssuer" type="{}PartyIdentType" minOccurs="0"/&gt;
 *         &lt;element ref="{}AdjustmentDetails" minOccurs="0"/&gt;
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
    "documentIdentifier",
    "issueDate",
    "paymentDate",
    "amountPaid",
    "amountDue",
    "documentRecipient",
    "documentIssuer",
    "adjustmentDetails"
})
@XmlRootElement(name = "RemittanceDetails")
public class RemittanceDetails {

    @XmlElement(name = "DocumentIdentifier", required = true)
    protected String documentIdentifier;
    @XmlElement(name = "IssueDate")
    protected String issueDate;
    @XmlElement(name = "PaymentDate")
    protected String paymentDate;
    @XmlElement(name = "AmountPaid")
    protected AmountType amountPaid;
    @XmlElement(name = "AmountDue")
    protected AmountType amountDue;
    @XmlElement(name = "DocumentRecipient")
    protected PartyIdentType documentRecipient;
    @XmlElement(name = "DocumentIssuer")
    protected PartyIdentType documentIssuer;
    @XmlElement(name = "AdjustmentDetails")
    protected AdjustmentDetails adjustmentDetails;

    /**
     * Gets the value of the documentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentIdentifier() {
        return documentIdentifier;
    }

    /**
     * Sets the value of the documentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentIdentifier(String value) {
        this.documentIdentifier = value;
    }

    /**
     * Gets the value of the issueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the value of the issueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueDate(String value) {
        this.issueDate = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDate(String value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the amountPaid property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the value of the amountPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmountPaid(AmountType value) {
        this.amountPaid = value;
    }

    /**
     * Gets the value of the amountDue property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmountDue() {
        return amountDue;
    }

    /**
     * Sets the value of the amountDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmountDue(AmountType value) {
        this.amountDue = value;
    }

    /**
     * Gets the value of the documentRecipient property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentType }
     *     
     */
    public PartyIdentType getDocumentRecipient() {
        return documentRecipient;
    }

    /**
     * Sets the value of the documentRecipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentType }
     *     
     */
    public void setDocumentRecipient(PartyIdentType value) {
        this.documentRecipient = value;
    }

    /**
     * Gets the value of the documentIssuer property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentType }
     *     
     */
    public PartyIdentType getDocumentIssuer() {
        return documentIssuer;
    }

    /**
     * Sets the value of the documentIssuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentType }
     *     
     */
    public void setDocumentIssuer(PartyIdentType value) {
        this.documentIssuer = value;
    }

    /**
     * Gets the value of the adjustmentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AdjustmentDetails }
     *     
     */
    public AdjustmentDetails getAdjustmentDetails() {
        return adjustmentDetails;
    }

    /**
     * Sets the value of the adjustmentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdjustmentDetails }
     *     
     */
    public void setAdjustmentDetails(AdjustmentDetails value) {
        this.adjustmentDetails = value;
    }

}
