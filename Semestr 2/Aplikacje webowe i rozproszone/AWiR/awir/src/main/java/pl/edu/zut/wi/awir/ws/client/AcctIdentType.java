
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for AcctIdentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcctIdentType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="IdentificationSchemeName" use="required" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AcctIdentNameType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcctIdentType", propOrder = {
    "value"
})
public class AcctIdentType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "IdentificationSchemeName", required = true)
    protected AcctIdentNameType identificationSchemeName;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the identificationSchemeName property.
     * 
     * @return
     *     possible object is
     *     {@link AcctIdentNameType }
     *     
     */
    public AcctIdentNameType getIdentificationSchemeName() {
        return identificationSchemeName;
    }

    /**
     * Sets the value of the identificationSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcctIdentNameType }
     *     
     */
    public void setIdentificationSchemeName(AcctIdentNameType value) {
        this.identificationSchemeName = value;
    }

}
