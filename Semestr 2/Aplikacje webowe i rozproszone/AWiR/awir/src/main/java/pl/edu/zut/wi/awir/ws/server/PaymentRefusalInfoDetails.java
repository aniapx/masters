
package pl.edu.zut.wi.awir.ws.server;

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
 *         &lt;element name="BankPaymentRefusalIdentifier" type="{}max35Identifier" minOccurs="0"/&gt;
 *         &lt;element name="InfoCode" type="{}min1max4text"/&gt;
 *         &lt;element name="InfoDetails" type="{}max105text" minOccurs="0"/&gt;
 *         &lt;element name="Customer" type="{}Party" minOccurs="0"/&gt;
 *         &lt;element name="PaymenttInfoStatusCode" type="{}PmtInfoStatusCode" minOccurs="0"/&gt;
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
    "bankPaymentRefusalIdentifier",
    "infoCode",
    "infoDetails",
    "customer",
    "paymenttInfoStatusCode"
})
@XmlRootElement(name = "PaymentRefusalInfoDetails")
public class PaymentRefusalInfoDetails {

    @XmlElement(name = "BankPaymentRefusalIdentifier")
    protected String bankPaymentRefusalIdentifier;
    @XmlElement(name = "InfoCode", required = true)
    protected Min1Max4Text infoCode;
    @XmlElement(name = "InfoDetails")
    protected Max105Text infoDetails;
    @XmlElement(name = "Customer")
    protected Party customer;
    @XmlElement(name = "PaymenttInfoStatusCode")
    @XmlSchemaType(name = "string")
    protected PmtInfoStatusCode paymenttInfoStatusCode;

    /**
     * Gets the value of the bankPaymentRefusalIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankPaymentRefusalIdentifier() {
        return bankPaymentRefusalIdentifier;
    }

    /**
     * Sets the value of the bankPaymentRefusalIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankPaymentRefusalIdentifier(String value) {
        this.bankPaymentRefusalIdentifier = value;
    }

    /**
     * Gets the value of the infoCode property.
     * 
     * @return
     *     possible object is
     *     {@link Min1Max4Text }
     *     
     */
    public Min1Max4Text getInfoCode() {
        return infoCode;
    }

    /**
     * Sets the value of the infoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Min1Max4Text }
     *     
     */
    public void setInfoCode(Min1Max4Text value) {
        this.infoCode = value;
    }

    /**
     * Gets the value of the infoDetails property.
     * 
     * @return
     *     possible object is
     *     {@link Max105Text }
     *     
     */
    public Max105Text getInfoDetails() {
        return infoDetails;
    }

    /**
     * Sets the value of the infoDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max105Text }
     *     
     */
    public void setInfoDetails(Max105Text value) {
        this.infoDetails = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setCustomer(Party value) {
        this.customer = value;
    }

    /**
     * Gets the value of the paymenttInfoStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link PmtInfoStatusCode }
     *     
     */
    public PmtInfoStatusCode getPaymenttInfoStatusCode() {
        return paymenttInfoStatusCode;
    }

    /**
     * Sets the value of the paymenttInfoStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PmtInfoStatusCode }
     *     
     */
    public void setPaymenttInfoStatusCode(PmtInfoStatusCode value) {
        this.paymenttInfoStatusCode = value;
    }

}
