
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
 *         &lt;element ref="{}Header"/&gt;
 *         &lt;element ref="{}ResponseDetailsOmit" minOccurs="0"/&gt;
 *         &lt;element ref="{}PaymentDocument"/&gt;
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
    "header",
    "responseDetailsOmit",
    "paymentDocument"
})
@XmlRootElement(name = "PaymentAddRequest")
public class PaymentAddRequest {

    @XmlElement(name = "Header", required = true)
    protected Header header;
    @XmlElement(name = "ResponseDetailsOmit", defaultValue = "false")
    protected Boolean responseDetailsOmit;
    @XmlElement(name = "PaymentDocument", required = true)
    protected PaymentDocument paymentDocument;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the responseDetailsOmit property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isResponseDetailsOmit() {
        return responseDetailsOmit;
    }

    /**
     * Sets the value of the responseDetailsOmit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResponseDetailsOmit(Boolean value) {
        this.responseDetailsOmit = value;
    }

    /**
     * Gets the value of the paymentDocument property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDocument }
     *     
     */
    public PaymentDocument getPaymentDocument() {
        return paymentDocument;
    }

    /**
     * Sets the value of the paymentDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDocument }
     *     
     */
    public void setPaymentDocument(PaymentDocument value) {
        this.paymentDocument = value;
    }

}
