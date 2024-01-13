
package pl.edu.zut.wi.awir.ws.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Party complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Party"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Identifier" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}PartyIdentType" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max35text" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalName" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max70text" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max210text" minOccurs="0"/&gt;
 *         &lt;element name="UltmName" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max70text" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Address" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party", propOrder = {
    "identifier",
    "name",
    "additionalName",
    "description",
    "ultmName",
    "address"
})
public class Party {

    @XmlElement(name = "Identifier")
    protected PartyIdentType identifier;
    @XmlElement(name = "Name")
    protected List<Max35Text> name;
    @XmlElement(name = "AdditionalName")
    protected Max70Text additionalName;
    @XmlElement(name = "Description")
    protected Max210Text description;
    @XmlElement(name = "UltmName")
    protected Max70Text ultmName;
    @XmlElement(name = "Address")
    protected Address address;

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentType }
     *     
     */
    public PartyIdentType getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentType }
     *     
     */
    public void setIdentifier(PartyIdentType value) {
        this.identifier = value;
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
     * Gets the value of the additionalName property.
     * 
     * @return
     *     possible object is
     *     {@link Max70Text }
     *     
     */
    public Max70Text getAdditionalName() {
        return additionalName;
    }

    /**
     * Sets the value of the additionalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max70Text }
     *     
     */
    public void setAdditionalName(Max70Text value) {
        this.additionalName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Max210Text }
     *     
     */
    public Max210Text getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max210Text }
     *     
     */
    public void setDescription(Max210Text value) {
        this.description = value;
    }

    /**
     * Gets the value of the ultmName property.
     * 
     * @return
     *     possible object is
     *     {@link Max70Text }
     *     
     */
    public Max70Text getUltmName() {
        return ultmName;
    }

    /**
     * Sets the value of the ultmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max70Text }
     *     
     */
    public void setUltmName(Max70Text value) {
        this.ultmName = value;
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
