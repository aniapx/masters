
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for CountryCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CountryCode"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;&gt;CountryCodeType"&gt;
 *       &lt;attribute name="CodeListIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" fixed="ISO 3166" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountryCode", propOrder = {
    "value"
})
public class CountryCode {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "CodeListIdentifier")
    protected String codeListIdentifier;

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
     * Gets the value of the codeListIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeListIdentifier() {
        if (codeListIdentifier == null) {
            return "ISO 3166";
        } else {
            return codeListIdentifier;
        }
    }

    /**
     * Sets the value of the codeListIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeListIdentifier(String value) {
        this.codeListIdentifier = value;
    }

}
