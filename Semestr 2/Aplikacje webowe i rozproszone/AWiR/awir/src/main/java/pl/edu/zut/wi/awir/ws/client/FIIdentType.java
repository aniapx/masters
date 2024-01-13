
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for FIIdentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FIIdentType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="IdentificationSchemeName" use="required" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FIIdentNameType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIIdentType", propOrder = {
    "value"
})
public class FIIdentType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "IdentificationSchemeName", required = true)
    protected FIIdentNameType identificationSchemeName;

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
     *     {@link FIIdentNameType }
     *     
     */
    public FIIdentNameType getIdentificationSchemeName() {
        return identificationSchemeName;
    }

    /**
     * Sets the value of the identificationSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIIdentNameType }
     *     
     */
    public void setIdentificationSchemeName(FIIdentNameType value) {
        this.identificationSchemeName = value;
    }

}
