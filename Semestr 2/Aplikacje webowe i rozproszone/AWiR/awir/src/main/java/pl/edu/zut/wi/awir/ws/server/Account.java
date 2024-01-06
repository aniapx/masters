
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Account"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountIdentifier" type="{}AcctIdentType"/&gt;
 *         &lt;element name="AccountName" type="{}max35text" minOccurs="0"/&gt;
 *         &lt;element name="AccountCurrencyCode" type="{}CurrencyCode" minOccurs="0"/&gt;
 *         &lt;element name="AccountType" type="{}AcctTypeCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account", propOrder = {
    "accountIdentifier",
    "accountName",
    "accountCurrencyCode",
    "accountType"
})
public class Account {

    @XmlElement(name = "AccountIdentifier", required = true)
    protected AcctIdentType accountIdentifier;
    @XmlElement(name = "AccountName")
    protected Max35Text accountName;
    @XmlElement(name = "AccountCurrencyCode")
    protected CurrencyCode accountCurrencyCode;
    @XmlElement(name = "AccountType")
    @XmlSchemaType(name = "string")
    protected AcctTypeCode accountType;

    /**
     * Gets the value of the accountIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link AcctIdentType }
     *     
     */
    public AcctIdentType getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * Sets the value of the accountIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcctIdentType }
     *     
     */
    public void setAccountIdentifier(AcctIdentType value) {
        this.accountIdentifier = value;
    }

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link Max35Text }
     *     
     */
    public Max35Text getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max35Text }
     *     
     */
    public void setAccountName(Max35Text value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the accountCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getAccountCurrencyCode() {
        return accountCurrencyCode;
    }

    /**
     * Sets the value of the accountCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setAccountCurrencyCode(CurrencyCode value) {
        this.accountCurrencyCode = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link AcctTypeCode }
     *     
     */
    public AcctTypeCode getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcctTypeCode }
     *     
     */
    public void setAccountType(AcctTypeCode value) {
        this.accountType = value;
    }

}
