
package pl.edu.zut.wi.awir.ws.server;

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
 *         &lt;element name="AdjustmentReason" type="{}AdjustmentReasonCode"/&gt;
 *         &lt;element name="AdjustmentAmount" type="{}AmountType"/&gt;
 *         &lt;element name="DocumentIdentifier" type="{}max35Identifier"/&gt;
 *         &lt;element ref="{}Description" minOccurs="0"/&gt;
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
    "adjustmentReason",
    "adjustmentAmount",
    "documentIdentifier",
    "description"
})
@XmlRootElement(name = "AdjustmentDetails")
public class AdjustmentDetails {

    @XmlElement(name = "AdjustmentReason", required = true)
    protected AdjustmentReasonCode adjustmentReason;
    @XmlElement(name = "AdjustmentAmount", required = true)
    protected AmountType adjustmentAmount;
    @XmlElement(name = "DocumentIdentifier", required = true)
    protected String documentIdentifier;
    @XmlElement(name = "Description")
    protected Max210Text description;

    /**
     * Gets the value of the adjustmentReason property.
     * 
     * @return
     *     possible object is
     *     {@link AdjustmentReasonCode }
     *     
     */
    public AdjustmentReasonCode getAdjustmentReason() {
        return adjustmentReason;
    }

    /**
     * Sets the value of the adjustmentReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdjustmentReasonCode }
     *     
     */
    public void setAdjustmentReason(AdjustmentReasonCode value) {
        this.adjustmentReason = value;
    }

    /**
     * Gets the value of the adjustmentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAdjustmentAmount() {
        return adjustmentAmount;
    }

    /**
     * Sets the value of the adjustmentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAdjustmentAmount(AmountType value) {
        this.adjustmentAmount = value;
    }

    /**
     * Gets the value of the documentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentIdentifier() {
        return documentIdentifier;
    }

    /**
     * Sets the value of the documentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentIdentifier(String value) {
        this.documentIdentifier = value;
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
