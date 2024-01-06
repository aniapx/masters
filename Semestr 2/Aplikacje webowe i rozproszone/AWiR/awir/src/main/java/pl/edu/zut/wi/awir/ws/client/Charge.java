
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
 *         &lt;element name="Amount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="Reason" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max70text" minOccurs="0"/&gt;
 *         &lt;element name="ChargeOriginator" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max14text" minOccurs="0"/&gt;
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
    "amount",
    "reason",
    "chargeOriginator"
})
@XmlRootElement(name = "Charge")
public class Charge {

    @XmlElement(name = "Amount")
    protected AmountType amount;
    @XmlElement(name = "Reason")
    protected Max70Text reason;
    @XmlElement(name = "ChargeOriginator")
    protected Max14Text chargeOriginator;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmount(AmountType value) {
        this.amount = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link Max70Text }
     *     
     */
    public Max70Text getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max70Text }
     *     
     */
    public void setReason(Max70Text value) {
        this.reason = value;
    }

    /**
     * Gets the value of the chargeOriginator property.
     * 
     * @return
     *     possible object is
     *     {@link Max14Text }
     *     
     */
    public Max14Text getChargeOriginator() {
        return chargeOriginator;
    }

    /**
     * Sets the value of the chargeOriginator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max14Text }
     *     
     */
    public void setChargeOriginator(Max14Text value) {
        this.chargeOriginator = value;
    }

}
