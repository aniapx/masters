
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
 *         &lt;element name="DailyPaymentLmt" type="{}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="DailyAbroadPaymentLmt" type="{}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="DailyCashLmt" type="{}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="DailyAbroadCashLmt" type="{}AmountType" minOccurs="0"/&gt;
 *         &lt;element name="DailyInternetPaymentLmt" type="{}AmountType" minOccurs="0"/&gt;
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
    "dailyPaymentLmt",
    "dailyAbroadPaymentLmt",
    "dailyCashLmt",
    "dailyAbroadCashLmt",
    "dailyInternetPaymentLmt"
})
@XmlRootElement(name = "CardLimit")
public class CardLimit {

    @XmlElement(name = "DailyPaymentLmt")
    protected AmountType dailyPaymentLmt;
    @XmlElement(name = "DailyAbroadPaymentLmt")
    protected AmountType dailyAbroadPaymentLmt;
    @XmlElement(name = "DailyCashLmt")
    protected AmountType dailyCashLmt;
    @XmlElement(name = "DailyAbroadCashLmt")
    protected AmountType dailyAbroadCashLmt;
    @XmlElement(name = "DailyInternetPaymentLmt")
    protected AmountType dailyInternetPaymentLmt;

    /**
     * Gets the value of the dailyPaymentLmt property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getDailyPaymentLmt() {
        return dailyPaymentLmt;
    }

    /**
     * Sets the value of the dailyPaymentLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setDailyPaymentLmt(AmountType value) {
        this.dailyPaymentLmt = value;
    }

    /**
     * Gets the value of the dailyAbroadPaymentLmt property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getDailyAbroadPaymentLmt() {
        return dailyAbroadPaymentLmt;
    }

    /**
     * Sets the value of the dailyAbroadPaymentLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setDailyAbroadPaymentLmt(AmountType value) {
        this.dailyAbroadPaymentLmt = value;
    }

    /**
     * Gets the value of the dailyCashLmt property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getDailyCashLmt() {
        return dailyCashLmt;
    }

    /**
     * Sets the value of the dailyCashLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setDailyCashLmt(AmountType value) {
        this.dailyCashLmt = value;
    }

    /**
     * Gets the value of the dailyAbroadCashLmt property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getDailyAbroadCashLmt() {
        return dailyAbroadCashLmt;
    }

    /**
     * Sets the value of the dailyAbroadCashLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setDailyAbroadCashLmt(AmountType value) {
        this.dailyAbroadCashLmt = value;
    }

    /**
     * Gets the value of the dailyInternetPaymentLmt property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getDailyInternetPaymentLmt() {
        return dailyInternetPaymentLmt;
    }

    /**
     * Sets the value of the dailyInternetPaymentLmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setDailyInternetPaymentLmt(AmountType value) {
        this.dailyInternetPaymentLmt = value;
    }

}
