
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="AccountIdentifier" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AcctIdentType"/&gt;
 *         &lt;element name="AccountName" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max35text" minOccurs="0"/&gt;
 *         &lt;element name="AccountCurrencyCode" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}CurrencyCode" minOccurs="0"/&gt;
 *         &lt;element name="AccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    protected String accountType;

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
     *     {@link String }
     *     
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

}
