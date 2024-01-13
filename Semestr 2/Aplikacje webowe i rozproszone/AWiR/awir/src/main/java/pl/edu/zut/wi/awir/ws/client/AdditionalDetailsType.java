
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdditionalDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdditionalDetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Subject" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}min1max70text"/&gt;
 *         &lt;element name="Information" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}min1max210text"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalDetailsType", propOrder = {
    "subject",
    "information"
})
public class AdditionalDetailsType {

    @XmlElement(name = "Subject", required = true)
    protected Min1Max70Text subject;
    @XmlElement(name = "Information", required = true)
    protected Min1Max210Text information;

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link Min1Max70Text }
     *     
     */
    public Min1Max70Text getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link Min1Max70Text }
     *     
     */
    public void setSubject(Min1Max70Text value) {
        this.subject = value;
    }

    /**
     * Gets the value of the information property.
     * 
     * @return
     *     possible object is
     *     {@link Min1Max210Text }
     *     
     */
    public Min1Max210Text getInformation() {
        return information;
    }

    /**
     * Sets the value of the information property.
     * 
     * @param value
     *     allowed object is
     *     {@link Min1Max210Text }
     *     
     */
    public void setInformation(Min1Max210Text value) {
        this.information = value;
    }

}
