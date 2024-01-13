
package pl.edu.zut.wi.awir.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommunicationNumberDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommunicationNumberDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CommunicationModeCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CommunicationIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunicationNumberDetails", propOrder = {
    "communicationModeCode",
    "communicationIdentifier"
})
public class CommunicationNumberDetails {

    @XmlElement(name = "CommunicationModeCode", required = true)
    protected String communicationModeCode;
    @XmlElement(name = "CommunicationIdentifier", required = true)
    protected String communicationIdentifier;

    /**
     * Gets the value of the communicationModeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunicationModeCode() {
        return communicationModeCode;
    }

    /**
     * Sets the value of the communicationModeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunicationModeCode(String value) {
        this.communicationModeCode = value;
    }

    /**
     * Gets the value of the communicationIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunicationIdentifier() {
        return communicationIdentifier;
    }

    /**
     * Sets the value of the communicationIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunicationIdentifier(String value) {
        this.communicationIdentifier = value;
    }

}
