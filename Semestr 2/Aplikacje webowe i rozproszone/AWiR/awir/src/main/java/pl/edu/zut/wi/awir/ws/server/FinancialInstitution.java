
package pl.edu.zut.wi.awir.ws.server;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FinancialInstitution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitution"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FIIdentifier" type="{}FIIdentType"/&gt;
 *         &lt;element name="Name" type="{}max35text" maxOccurs="4" minOccurs="0"/&gt;
 *         &lt;element ref="{}Address" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitution", propOrder = {
    "fiIdentifier",
    "name",
    "address"
})
public class FinancialInstitution {

    @XmlElement(name = "FIIdentifier", required = true)
    protected FIIdentType fiIdentifier;
    @XmlElement(name = "Name")
    protected List<Max35Text> name;
    @XmlElement(name = "Address")
    protected Address address;

    /**
     * Gets the value of the fiIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link FIIdentType }
     *     
     */
    public FIIdentType getFIIdentifier() {
        return fiIdentifier;
    }

    /**
     * Sets the value of the fiIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIIdentType }
     *     
     */
    public void setFIIdentifier(FIIdentType value) {
        this.fiIdentifier = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Max35Text }
     * 
     * 
     */
    public List<Max35Text> getName() {
        if (name == null) {
            name = new ArrayList<Max35Text>();
        }
        return this.name;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

}
