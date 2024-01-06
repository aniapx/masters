
package pl.edu.zut.wi.awir.ws.server;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}PaymentHeader"/&gt;
 *         &lt;element ref="{}PaymentLineItem" maxOccurs="unbounded"/&gt;
 *         &lt;element name="PaymentSummary" type="{}PaymentSummaryType" minOccurs="0"/&gt;
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
    "paymentHeader",
    "paymentLineItem",
    "paymentSummary"
})
@XmlRootElement(name = "PaymentDocument")
public class PaymentDocument {

    @XmlElement(name = "PaymentHeader", required = true)
    protected PaymentHeader paymentHeader;
    @XmlElement(name = "PaymentLineItem", required = true)
    protected List<PaymentLineItem> paymentLineItem;
    @XmlElement(name = "PaymentSummary")
    protected PaymentSummaryType paymentSummary;

    /**
     * Gets the value of the paymentHeader property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentHeader }
     *     
     */
    public PaymentHeader getPaymentHeader() {
        return paymentHeader;
    }

    /**
     * Sets the value of the paymentHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentHeader }
     *     
     */
    public void setPaymentHeader(PaymentHeader value) {
        this.paymentHeader = value;
    }

    /**
     * Gets the value of the paymentLineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentLineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentLineItem }
     * 
     * 
     */
    public List<PaymentLineItem> getPaymentLineItem() {
        if (paymentLineItem == null) {
            paymentLineItem = new ArrayList<PaymentLineItem>();
        }
        return this.paymentLineItem;
    }

    /**
     * Gets the value of the paymentSummary property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentSummaryType }
     *     
     */
    public PaymentSummaryType getPaymentSummary() {
        return paymentSummary;
    }

    /**
     * Sets the value of the paymentSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentSummaryType }
     *     
     */
    public void setPaymentSummary(PaymentSummaryType value) {
        this.paymentSummary = value;
    }

}
