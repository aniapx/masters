
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AddressType" type="{}AddressTypeCode" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="StreetName" type="{}max35text" minOccurs="0"/&gt;
 *             &lt;element name="PostCode" type="{}max9Identifier" minOccurs="0"/&gt;
 *             &lt;element name="CityName" type="{}max26text" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="PostalAddressLine1" type="{}max70text" minOccurs="0"/&gt;
 *             &lt;element name="PostalAddressLine2" type="{}max70text" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Country" type="{}CountryCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "addressType",
    "streetName",
    "postCode",
    "cityName",
    "postalAddressLine1",
    "postalAddressLine2",
    "country"
})
public class AddressType {

    @XmlElement(name = "AddressType")
    @XmlSchemaType(name = "string")
    protected AddressTypeCode addressType;
    @XmlElement(name = "StreetName")
    protected Max35Text streetName;
    @XmlElement(name = "PostCode")
    protected String postCode;
    @XmlElement(name = "CityName")
    protected Max26Text cityName;
    @XmlElement(name = "PostalAddressLine1")
    protected Max70Text postalAddressLine1;
    @XmlElement(name = "PostalAddressLine2")
    protected Max70Text postalAddressLine2;
    @XmlElement(name = "Country")
    protected CountryCode country;

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link AddressTypeCode }
     *     
     */
    public AddressTypeCode getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressTypeCode }
     *     
     */
    public void setAddressType(AddressTypeCode value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link Max35Text }
     *     
     */
    public Max35Text getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max35Text }
     *     
     */
    public void setStreetName(Max35Text value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link Max26Text }
     *     
     */
    public Max26Text getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max26Text }
     *     
     */
    public void setCityName(Max26Text value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the postalAddressLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link Max70Text }
     *     
     */
    public Max70Text getPostalAddressLine1() {
        return postalAddressLine1;
    }

    /**
     * Sets the value of the postalAddressLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max70Text }
     *     
     */
    public void setPostalAddressLine1(Max70Text value) {
        this.postalAddressLine1 = value;
    }

    /**
     * Gets the value of the postalAddressLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link Max70Text }
     *     
     */
    public Max70Text getPostalAddressLine2() {
        return postalAddressLine2;
    }

    /**
     * Sets the value of the postalAddressLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max70Text }
     *     
     */
    public void setPostalAddressLine2(Max70Text value) {
        this.postalAddressLine2 = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CountryCode }
     *     
     */
    public CountryCode getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryCode }
     *     
     */
    public void setCountry(CountryCode value) {
        this.country = value;
    }

}
