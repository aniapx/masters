
package pl.edu.zut.wi.awir.ws.client;

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
 *         &lt;element name="BankPaymentRefusalResponseIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RefusalAgreement" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="InfoCode" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}min1max4text" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalInfo" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max105text" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Customer" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Party" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalDeclaration" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AdditionalDeclarationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PaymenttInfoStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExecutionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "bankPaymentRefusalResponseIdentifier",
    "refusalAgreement",
    "infoCode",
    "additionalInfo",
    "customer",
    "additionalDeclaration",
    "paymenttInfoStatusCode",
    "executionDate"
})
@XmlRootElement(name = "PaymentRefusalResponseInfoDetails")
public class PaymentRefusalResponseInfoDetails {

    @XmlElement(name = "BankPaymentRefusalResponseIdentifier")
    protected String bankPaymentRefusalResponseIdentifier;
    @XmlElement(name = "RefusalAgreement")
    protected boolean refusalAgreement;
    @XmlElement(name = "InfoCode")
    protected Min1Max4Text infoCode;
    @XmlElement(name = "AdditionalInfo")
    protected List<Max105Text> additionalInfo;
    @XmlElement(name = "Customer")
    protected Party customer;
    @XmlElement(name = "AdditionalDeclaration")
    protected List<AdditionalDeclarationType> additionalDeclaration;
    @XmlElement(name = "PaymenttInfoStatusCode")
    protected String paymenttInfoStatusCode;
    @XmlElement(name = "ExecutionDate")
    protected String executionDate;

    /**
     * Gets the value of the bankPaymentRefusalResponseIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankPaymentRefusalResponseIdentifier() {
        return bankPaymentRefusalResponseIdentifier;
    }

    /**
     * Sets the value of the bankPaymentRefusalResponseIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankPaymentRefusalResponseIdentifier(String value) {
        this.bankPaymentRefusalResponseIdentifier = value;
    }

    /**
     * Gets the value of the refusalAgreement property.
     * 
     */
    public boolean isRefusalAgreement() {
        return refusalAgreement;
    }

    /**
     * Sets the value of the refusalAgreement property.
     * 
     */
    public void setRefusalAgreement(boolean value) {
        this.refusalAgreement = value;
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
     * Gets the value of the additionalInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Max105Text }
     * 
     * 
     */
    public List<Max105Text> getAdditionalInfo() {
        if (additionalInfo == null) {
            additionalInfo = new ArrayList<Max105Text>();
        }
        return this.additionalInfo;
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
     * Gets the value of the additionalDeclaration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalDeclaration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalDeclaration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalDeclarationType }
     * 
     * 
     */
    public List<AdditionalDeclarationType> getAdditionalDeclaration() {
        if (additionalDeclaration == null) {
            additionalDeclaration = new ArrayList<AdditionalDeclarationType>();
        }
        return this.additionalDeclaration;
    }

    /**
     * Gets the value of the paymenttInfoStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymenttInfoStatusCode() {
        return paymenttInfoStatusCode;
    }

    /**
     * Sets the value of the paymenttInfoStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymenttInfoStatusCode(String value) {
        this.paymenttInfoStatusCode = value;
    }

    /**
     * Gets the value of the executionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionDate() {
        return executionDate;
    }

    /**
     * Sets the value of the executionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionDate(String value) {
        this.executionDate = value;
    }

}
