
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for ResponsibilityCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponsibilityCode"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;&gt;ResponsibilityType"&gt;
 *       &lt;attribute name="CodeListAgency" type="{http://www.w3.org/2001/XMLSchema}string" default="SWIFT" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponsibilityCode", propOrder = {
    "value"
})
public class ResponsibilityCode {

    @XmlValue
    protected ResponsibilityType value;
    @XmlAttribute(name = "CodeListAgency")
    protected String codeListAgency;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link ResponsibilityType }
     *     
     */
    public ResponsibilityType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsibilityType }
     *     
     */
    public void setValue(ResponsibilityType value) {
        this.value = value;
    }

    /**
     * Gets the value of the codeListAgency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeListAgency() {
        if (codeListAgency == null) {
            return "SWIFT";
        } else {
            return codeListAgency;
        }
    }

    /**
     * Sets the value of the codeListAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeListAgency(String value) {
        this.codeListAgency = value;
    }

}
