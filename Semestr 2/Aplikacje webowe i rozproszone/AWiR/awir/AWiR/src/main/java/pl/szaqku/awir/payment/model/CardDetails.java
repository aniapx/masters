//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.06 at 08:41:21 PM CET 
//


package pl.szaqku.awir.payment.model;

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
 *         &lt;sequence&gt;
 *           &lt;element name="CardIdent" type="{http://services.szaqku.pl}max35Identifier" minOccurs="0"/&gt;
 *           &lt;element name="CardNumber" type="{http://services.szaqku.pl}max16Identifier" minOccurs="0"/&gt;
 *           &lt;element name="CardConcealedNumber" type="{http://services.szaqku.pl}max25text" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="CardPassword" type="{http://services.szaqku.pl}max35text" minOccurs="0"/&gt;
 *         &lt;element name="CardType" type="{http://services.szaqku.pl}max25text" minOccurs="0"/&gt;
 *         &lt;element name="CardName" type="{http://services.szaqku.pl}max50text" minOccurs="0"/&gt;
 *         &lt;element name="CardDescription" type="{http://services.szaqku.pl}max25text" minOccurs="0"/&gt;
 *         &lt;element name="CardOwnerName" type="{http://services.szaqku.pl}max140text" minOccurs="0"/&gt;
 *         &lt;element name="ExpiresDate" type="{http://services.szaqku.pl}Date" minOccurs="0"/&gt;
 *         &lt;element ref="{http://services.szaqku.pl}CardStatus" minOccurs="0"/&gt;
 *         &lt;element name="CardAccount" type="{http://services.szaqku.pl}Account" minOccurs="0"/&gt;
 *         &lt;element name="CustomerAccount" type="{http://services.szaqku.pl}Account" minOccurs="0"/&gt;
 *         &lt;element ref="{http://services.szaqku.pl}CardLimit" minOccurs="0"/&gt;
 *         &lt;element name="CardBalanceDetails" type="{http://services.szaqku.pl}BalanceDetailsType" minOccurs="0"/&gt;
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
    "cardIdent",
    "cardNumber",
    "cardConcealedNumber",
    "cardPassword",
    "cardType",
    "cardName",
    "cardDescription",
    "cardOwnerName",
    "expiresDate",
    "cardStatus",
    "cardAccount",
    "customerAccount",
    "cardLimit",
    "cardBalanceDetails"
})
@XmlRootElement(name = "CardDetails")
public class CardDetails {

    @XmlElement(name = "CardIdent")
    protected String cardIdent;
    @XmlElement(name = "CardNumber")
    protected String cardNumber;
    @XmlElement(name = "CardConcealedNumber")
    protected Max25Text cardConcealedNumber;
    @XmlElement(name = "CardPassword")
    protected Max35Text cardPassword;
    @XmlElement(name = "CardType")
    protected Max25Text cardType;
    @XmlElement(name = "CardName")
    protected Max50Text cardName;
    @XmlElement(name = "CardDescription")
    protected Max25Text cardDescription;
    @XmlElement(name = "CardOwnerName")
    protected Max140Text cardOwnerName;
    @XmlElement(name = "ExpiresDate")
    protected String expiresDate;
    @XmlElement(name = "CardStatus", namespace = "http://services.szaqku.pl")
    @XmlSchemaType(name = "string")
    protected CardStatusCode cardStatus;
    @XmlElement(name = "CardAccount")
    protected Account cardAccount;
    @XmlElement(name = "CustomerAccount")
    protected Account customerAccount;
    @XmlElement(name = "CardLimit", namespace = "http://services.szaqku.pl")
    protected CardLimit cardLimit;
    @XmlElement(name = "CardBalanceDetails")
    protected BalanceDetailsType cardBalanceDetails;

    /**
     * Gets the value of the cardIdent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardIdent() {
        return cardIdent;
    }

    /**
     * Sets the value of the cardIdent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardIdent(String value) {
        this.cardIdent = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the cardConcealedNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Max25Text }
     *     
     */
    public Max25Text getCardConcealedNumber() {
        return cardConcealedNumber;
    }

    /**
     * Sets the value of the cardConcealedNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max25Text }
     *     
     */
    public void setCardConcealedNumber(Max25Text value) {
        this.cardConcealedNumber = value;
    }

    /**
     * Gets the value of the cardPassword property.
     * 
     * @return
     *     possible object is
     *     {@link Max35Text }
     *     
     */
    public Max35Text getCardPassword() {
        return cardPassword;
    }

    /**
     * Sets the value of the cardPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max35Text }
     *     
     */
    public void setCardPassword(Max35Text value) {
        this.cardPassword = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link Max25Text }
     *     
     */
    public Max25Text getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max25Text }
     *     
     */
    public void setCardType(Max25Text value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the cardName property.
     * 
     * @return
     *     possible object is
     *     {@link Max50Text }
     *     
     */
    public Max50Text getCardName() {
        return cardName;
    }

    /**
     * Sets the value of the cardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max50Text }
     *     
     */
    public void setCardName(Max50Text value) {
        this.cardName = value;
    }

    /**
     * Gets the value of the cardDescription property.
     * 
     * @return
     *     possible object is
     *     {@link Max25Text }
     *     
     */
    public Max25Text getCardDescription() {
        return cardDescription;
    }

    /**
     * Sets the value of the cardDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max25Text }
     *     
     */
    public void setCardDescription(Max25Text value) {
        this.cardDescription = value;
    }

    /**
     * Gets the value of the cardOwnerName property.
     * 
     * @return
     *     possible object is
     *     {@link Max140Text }
     *     
     */
    public Max140Text getCardOwnerName() {
        return cardOwnerName;
    }

    /**
     * Sets the value of the cardOwnerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max140Text }
     *     
     */
    public void setCardOwnerName(Max140Text value) {
        this.cardOwnerName = value;
    }

    /**
     * Gets the value of the expiresDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiresDate() {
        return expiresDate;
    }

    /**
     * Sets the value of the expiresDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiresDate(String value) {
        this.expiresDate = value;
    }

    /**
     * Gets the value of the cardStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CardStatusCode }
     *     
     */
    public CardStatusCode getCardStatus() {
        return cardStatus;
    }

    /**
     * Sets the value of the cardStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardStatusCode }
     *     
     */
    public void setCardStatus(CardStatusCode value) {
        this.cardStatus = value;
    }

    /**
     * Gets the value of the cardAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getCardAccount() {
        return cardAccount;
    }

    /**
     * Sets the value of the cardAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setCardAccount(Account value) {
        this.cardAccount = value;
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
     * Gets the value of the cardLimit property.
     * 
     * @return
     *     possible object is
     *     {@link CardLimit }
     *     
     */
    public CardLimit getCardLimit() {
        return cardLimit;
    }

    /**
     * Sets the value of the cardLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardLimit }
     *     
     */
    public void setCardLimit(CardLimit value) {
        this.cardLimit = value;
    }

    /**
     * Gets the value of the cardBalanceDetails property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceDetailsType }
     *     
     */
    public BalanceDetailsType getCardBalanceDetails() {
        return cardBalanceDetails;
    }

    /**
     * Sets the value of the cardBalanceDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceDetailsType }
     *     
     */
    public void setCardBalanceDetails(BalanceDetailsType value) {
        this.cardBalanceDetails = value;
    }

}
