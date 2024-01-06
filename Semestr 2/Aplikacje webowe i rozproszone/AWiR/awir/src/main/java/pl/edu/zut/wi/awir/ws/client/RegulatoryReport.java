
package pl.edu.zut.wi.awir.ws.client;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="RegulatoryInformationCoded" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}RegInfoCode" maxOccurs="unbounded"/&gt;
 *         &lt;element name="Description" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max210text" minOccurs="0"/&gt;
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
    "regulatoryInformationCoded",
    "description"
})
@XmlRootElement(name = "RegulatoryReport")
public class RegulatoryReport {

    @XmlElement(name = "RegulatoryInformationCoded", required = true)
    protected List<RegInfoCode> regulatoryInformationCoded;
    @XmlElement(name = "Description")
    protected Max210Text description;

    /**
     * Gets the value of the regulatoryInformationCoded property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regulatoryInformationCoded property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegulatoryInformationCoded().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegInfoCode }
     * 
     * 
     */
    public List<RegInfoCode> getRegulatoryInformationCoded() {
        if (regulatoryInformationCoded == null) {
            regulatoryInformationCoded = new ArrayList<RegInfoCode>();
        }
        return this.regulatoryInformationCoded;
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

}
