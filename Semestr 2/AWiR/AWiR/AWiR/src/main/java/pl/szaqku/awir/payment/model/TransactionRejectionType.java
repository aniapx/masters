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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionRejectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionRejectionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RejectionCode" type="{http://services.szaqku.pl}StatusTypeCode"/&gt;
 *         &lt;element name="RejectionDescription" type="{http://services.szaqku.pl}max210text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionRejectionType", propOrder = {
    "rejectionCode",
    "rejectionDescription"
})
public class TransactionRejectionType {

    @XmlElement(name = "RejectionCode", required = true)
    protected String rejectionCode;
    @XmlElement(name = "RejectionDescription")
    protected Max210Text rejectionDescription;

    /**
     * Gets the value of the rejectionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRejectionCode() {
        return rejectionCode;
    }

    /**
     * Sets the value of the rejectionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRejectionCode(String value) {
        this.rejectionCode = value;
    }

    /**
     * Gets the value of the rejectionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link Max210Text }
     *     
     */
    public Max210Text getRejectionDescription() {
        return rejectionDescription;
    }

    /**
     * Sets the value of the rejectionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max210Text }
     *     
     */
    public void setRejectionDescription(Max210Text value) {
        this.rejectionDescription = value;
    }

}
