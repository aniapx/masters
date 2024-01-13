
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="BalanceType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BalanceAmount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AmountType"/&gt;
 *         &lt;element name="BalanceDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max210text" minOccurs="0"/&gt;
 *         &lt;element name="BlockedType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ChequeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransactionIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    protected String balanceType;
    @XmlElement(name = "BalanceAmount", required = true)
    protected AmountType balanceAmount;
    @XmlElement(name = "BalanceDate", required = true)
    protected String balanceDate;
    @XmlElement(name = "ExpirationDate")
    protected String expirationDate;
    @XmlElement(name = "Description")
    protected Max210Text description;
    @XmlElement(name = "BlockedType")
    protected String blockedType;
    @XmlElement(name = "ChequeNumber")
    protected String chequeNumber;
    @XmlElement(name = "TransactionIdentifier")
    protected String transactionIdentifier;

    /**
     * Gets the value of the balanceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * Sets the value of the balanceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceType(String value) {
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
     *     {@link String }
     *     
     */
    public String getBlockedType() {
        return blockedType;
    }

    /**
     * Sets the value of the blockedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockedType(String value) {
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
