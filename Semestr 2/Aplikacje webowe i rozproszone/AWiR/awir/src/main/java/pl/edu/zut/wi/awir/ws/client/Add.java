
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Add complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Add"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="secret" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="paymentAddRequest"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Header"/&gt;
 *                   &lt;element name="ResponseDetailsOmit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0" form="qualified"/&gt;
 *                   &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}PaymentDocument"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Add", namespace = "http://www.wi.zut.edu.pl/service/payment/v1.0", propOrder = {
    "secret",
    "paymentAddRequest"
})
public class Add {

    @XmlElement(namespace = "", required = true)
    protected String secret;
    @XmlElement(namespace = "", required = true)
    protected Add.PaymentAddRequest paymentAddRequest;

    /**
     * Gets the value of the secret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Sets the value of the secret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecret(String value) {
        this.secret = value;
    }

    /**
     * Gets the value of the paymentAddRequest property.
     * 
     * @return
     *     possible object is
     *     {@link Add.PaymentAddRequest }
     *     
     */
    public Add.PaymentAddRequest getPaymentAddRequest() {
        return paymentAddRequest;
    }

    /**
     * Sets the value of the paymentAddRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Add.PaymentAddRequest }
     *     
     */
    public void setPaymentAddRequest(Add.PaymentAddRequest value) {
        this.paymentAddRequest = value;
    }


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
     *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Header"/&gt;
     *         &lt;element name="ResponseDetailsOmit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0" form="qualified"/&gt;
     *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}PaymentDocument"/&gt;
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
    public static class PaymentAddRequest {

        @XmlElement(name = "Header", required = true)
        protected Header header;
        @XmlElement(name = "ResponseDetailsOmit", namespace = "http://www.wi.zut.edu.pl/service/payment/v1.0", defaultValue = "false")
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

}
