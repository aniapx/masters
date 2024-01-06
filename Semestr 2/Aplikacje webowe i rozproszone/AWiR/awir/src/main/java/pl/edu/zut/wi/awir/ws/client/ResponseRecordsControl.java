
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
 *         &lt;element name="MaxRecords" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Numeric"/&gt;
 *         &lt;element name="MatchedRecords" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Numeric" minOccurs="0"/&gt;
 *         &lt;element name="NumberPart" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Numeric" minOccurs="0"/&gt;
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
    "maxRecords",
    "matchedRecords",
    "numberPart"
})
@XmlRootElement(name = "ResponseRecordsControl")
public class ResponseRecordsControl {

    @XmlElement(name = "MaxRecords", required = true)
    protected Numeric maxRecords;
    @XmlElement(name = "MatchedRecords")
    protected Numeric matchedRecords;
    @XmlElement(name = "NumberPart")
    protected Numeric numberPart;

    /**
     * Gets the value of the maxRecords property.
     * 
     * @return
     *     possible object is
     *     {@link Numeric }
     *     
     */
    public Numeric getMaxRecords() {
        return maxRecords;
    }

    /**
     * Sets the value of the maxRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numeric }
     *     
     */
    public void setMaxRecords(Numeric value) {
        this.maxRecords = value;
    }

    /**
     * Gets the value of the matchedRecords property.
     * 
     * @return
     *     possible object is
     *     {@link Numeric }
     *     
     */
    public Numeric getMatchedRecords() {
        return matchedRecords;
    }

    /**
     * Sets the value of the matchedRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numeric }
     *     
     */
    public void setMatchedRecords(Numeric value) {
        this.matchedRecords = value;
    }

    /**
     * Gets the value of the numberPart property.
     * 
     * @return
     *     possible object is
     *     {@link Numeric }
     *     
     */
    public Numeric getNumberPart() {
        return numberPart;
    }

    /**
     * Sets the value of the numberPart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numeric }
     *     
     */
    public void setNumberPart(Numeric value) {
        this.numberPart = value;
    }

}
