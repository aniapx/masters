
package pl.edu.zut.wi.awir.ws.client;

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
 *         &lt;element name="ExecutionDateRequested" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}ImmediatePaymentDetails"/&gt;
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
    "executionDateRequested",
    "dueDate",
    "immediatePaymentDetails"
})
@XmlRootElement(name = "ImmediatePaymentDocument")
public class ImmediatePaymentDocument {

    @XmlElement(name = "ExecutionDateRequested")
    protected String executionDateRequested;
    @XmlElement(name = "DueDate")
    protected String dueDate;
    @XmlElement(name = "ImmediatePaymentDetails", required = true)
    protected ImmediatePaymentDetails immediatePaymentDetails;

    /**
     * Gets the value of the executionDateRequested property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionDateRequested() {
        return executionDateRequested;
    }

    /**
     * Sets the value of the executionDateRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionDateRequested(String value) {
        this.executionDateRequested = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueDate(String value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the immediatePaymentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ImmediatePaymentDetails }
     *     
     */
    public ImmediatePaymentDetails getImmediatePaymentDetails() {
        return immediatePaymentDetails;
    }

    /**
     * Sets the value of the immediatePaymentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImmediatePaymentDetails }
     *     
     */
    public void setImmediatePaymentDetails(ImmediatePaymentDetails value) {
        this.immediatePaymentDetails = value;
    }

}
