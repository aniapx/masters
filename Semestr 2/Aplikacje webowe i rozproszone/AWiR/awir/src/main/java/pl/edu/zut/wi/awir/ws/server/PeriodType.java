
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StartDateTime" type="{}DateTime" minOccurs="0"/&gt;
 *         &lt;element name="EndDateTime" type="{}DateTime" minOccurs="0"/&gt;
 *         &lt;element name="DurationDateTime" type="{}DurationTypeCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodType", propOrder = {
    "startDateTime",
    "endDateTime",
    "durationDateTime"
})
public class PeriodType {

    @XmlElement(name = "StartDateTime")
    protected String startDateTime;
    @XmlElement(name = "EndDateTime")
    protected String endDateTime;
    @XmlElement(name = "DurationDateTime")
    @XmlSchemaType(name = "string")
    protected DurationTypeCode durationDateTime;

    /**
     * Gets the value of the startDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDateTime() {
        return startDateTime;
    }

    /**
     * Sets the value of the startDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDateTime(String value) {
        this.startDateTime = value;
    }

    /**
     * Gets the value of the endDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDateTime() {
        return endDateTime;
    }

    /**
     * Sets the value of the endDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateTime(String value) {
        this.endDateTime = value;
    }

    /**
     * Gets the value of the durationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link DurationTypeCode }
     *     
     */
    public DurationTypeCode getDurationDateTime() {
        return durationDateTime;
    }

    /**
     * Sets the value of the durationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationTypeCode }
     *     
     */
    public void setDurationDateTime(DurationTypeCode value) {
        this.durationDateTime = value;
    }

}
