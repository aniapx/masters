
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BalanceDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceDetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BalanceType" type="{}BalTypeCode"/&gt;
 *         &lt;element name="BalanceAmount" type="{}AmountType"/&gt;
 *         &lt;element name="BalanceDate" type="{}DateTime"/&gt;
 *         &lt;element name="ExpirationDate" type="{}Date" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{}max210text" minOccurs="0"/&gt;
 *         &lt;element name="BlockedType" type="{}BlockedTypeCode" minOccurs="0"/&gt;
 *         &lt;element name="ChequeNumber" type="{}max12Identifier" minOccurs="0"/&gt;
 *         &lt;element name="TransactionIdentifier" type="{}max35Identifier" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceDetailsType", propOrder = {
    "balanceType",
    "balanceAmount",
    "balanceDate",
    "expirationDate",
    "description",
    "blockedType",
    "chequeNumber",
    "transactionIdentifier"
})
public class BalanceDetailsType {

    @XmlElement(name = "BalanceType", required = true)
    @XmlSchemaType(name = "string")
    protected BalTypeCode balanceType;
    @XmlElement(name = "BalanceAmount", required = true)
    protected AmountType balanceAmount;
    @XmlElement(name = "BalanceDate", required = true)
    protected String balanceDate;
    @XmlElement(name = "ExpirationDate")
    protected String expirationDate;
    @XmlElement(name = "Description")
    protected Max210Text description;
    @XmlElement(name = "BlockedType")
    @XmlSchemaType(name = "string")
    protected BlockedTypeCode blockedType;
    @XmlElement(name = "ChequeNumber")
    protected String chequeNumber;
    @XmlElement(name = "TransactionIdentifier")
    protected String transactionIdentifier;

    /**
     * Gets the value of the balanceType property.
     * 
     * @return
     *     possible object is
     *     {@link BalTypeCode }
     *     
     */
    public BalTypeCode getBalanceType() {
        return balanceType;
    }

    /**
     * Sets the value of the balanceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalTypeCode }
     *     
     */
    public void setBalanceType(BalTypeCode value) {
        this.balanceType = value;
    }

    /**
     * Gets the value of the balanceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * Sets the value of the balanceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setBalanceAmount(AmountType value) {
        this.balanceAmount = value;
    }

    /**
     * Gets the value of the balanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceDate() {
        return balanceDate;
    }

    /**
     * Sets the value of the balanceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceDate(String value) {
        this.balanceDate = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Max210Text }
     *     
     */
    public Max210Text getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max210Text }
     *     
     */
    public void setDescription(Max210Text value) {
        this.description = value;
    }

    /**
     * Gets the value of the blockedType property.
     * 
     * @return
     *     possible object is
     *     {@link BlockedTypeCode }
     *     
     */
    public BlockedTypeCode getBlockedType() {
        return blockedType;
    }

    /**
     * Sets the value of the blockedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockedTypeCode }
     *     
     */
    public void setBlockedType(BlockedTypeCode value) {
        this.blockedType = value;
    }

    /**
     * Gets the value of the chequeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChequeNumber() {
        return chequeNumber;
    }

    /**
     * Sets the value of the chequeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChequeNumber(String value) {
        this.chequeNumber = value;
    }

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

}
