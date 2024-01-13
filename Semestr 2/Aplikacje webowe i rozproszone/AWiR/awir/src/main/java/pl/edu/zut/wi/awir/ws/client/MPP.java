
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
 *         &lt;element name="VATAmount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}VATAmountType"/&gt;
 *         &lt;element name="TaxIdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VATInvoice" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="VATDescription" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max33text" minOccurs="0"/&gt;
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
    "vatAmount",
    "taxIdentificationNumber",
    "vatInvoice",
    "vatDescription"
})
@XmlRootElement(name = "MPP")
public class MPP {

    @XmlElement(name = "VATAmount", required = true)
    protected VATAmountType vatAmount;
    @XmlElement(name = "TaxIdentificationNumber", required = true)
    protected String taxIdentificationNumber;
    @XmlElement(name = "VATInvoice", required = true)
    protected String vatInvoice;
    @XmlElement(name = "VATDescription")
    protected Max33Text vatDescription;

    /**
     * Gets the value of the vatAmount property.
     * 
     * @return
     *     possible object is
     *     {@link VATAmountType }
     *     
     */
    public VATAmountType getVATAmount() {
        return vatAmount;
    }

    /**
     * Sets the value of the vatAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link VATAmountType }
     *     
     */
    public void setVATAmount(VATAmountType value) {
        this.vatAmount = value;
    }

    /**
     * Gets the value of the taxIdentificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    /**
     * Sets the value of the taxIdentificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxIdentificationNumber(String value) {
        this.taxIdentificationNumber = value;
    }

    /**
     * Gets the value of the vatInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVATInvoice() {
        return vatInvoice;
    }

    /**
     * Sets the value of the vatInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVATInvoice(String value) {
        this.vatInvoice = value;
    }

    /**
     * Gets the value of the vatDescription property.
     * 
     * @return
     *     possible object is
     *     {@link Max33Text }
     *     
     */
    public Max33Text getVATDescription() {
        return vatDescription;
    }

    /**
     * Sets the value of the vatDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max33Text }
     *     
     */
    public void setVATDescription(Max33Text value) {
        this.vatDescription = value;
    }

}
