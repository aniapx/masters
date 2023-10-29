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
 *         &lt;element name="TransactionStatusCode" type="{http://services.szaqku.pl}TrnStatusCode"/&gt;
 *         &lt;element name="StatusDescription" type="{http://services.szaqku.pl}max70text" minOccurs="0"/&gt;
 *         &lt;element name="EffectiveDate" type="{http://services.szaqku.pl}DateTime" minOccurs="0"/&gt;
 *         &lt;element name="CloseMicroAccountStatusCode" type="{http://services.szaqku.pl}CloseMicroAccStatusCode" minOccurs="0"/&gt;
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
    "transactionStatusCode",
    "statusDescription",
    "effectiveDate",
    "closeMicroAccountStatusCode"
})
@XmlRootElement(name = "TransactionStatus")
public class TransactionStatus {

    @XmlElement(name = "TransactionStatusCode", required = true)
    @XmlSchemaType(name = "string")
    protected TrnStatusCode transactionStatusCode;
    @XmlElement(name = "StatusDescription")
    protected Max70Text statusDescription;
    @XmlElement(name = "EffectiveDate")
    protected String effectiveDate;
    @XmlElement(name = "CloseMicroAccountStatusCode")
    @XmlSchemaType(name = "string")
    protected CloseMicroAccStatusCode closeMicroAccountStatusCode;

    /**
     * Gets the value of the transactionStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link TrnStatusCode }
     *     
     */
    public TrnStatusCode getTransactionStatusCode() {
        return transactionStatusCode;
    }

    /**
     * Sets the value of the transactionStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrnStatusCode }
     *     
     */
    public void setTransactionStatusCode(TrnStatusCode value) {
        this.transactionStatusCode = value;
    }

    /**
     * Gets the value of the statusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link Max70Text }
     *     
     */
    public Max70Text getStatusDescription() {
        return statusDescription;
    }

    /**
     * Sets the value of the statusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max70Text }
     *     
     */
    public void setStatusDescription(Max70Text value) {
        this.statusDescription = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the closeMicroAccountStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link CloseMicroAccStatusCode }
     *     
     */
    public CloseMicroAccStatusCode getCloseMicroAccountStatusCode() {
        return closeMicroAccountStatusCode;
    }

    /**
     * Sets the value of the closeMicroAccountStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CloseMicroAccStatusCode }
     *     
     */
    public void setCloseMicroAccountStatusCode(CloseMicroAccStatusCode value) {
        this.closeMicroAccountStatusCode = value;
    }

}
