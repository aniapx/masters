
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
 *         &lt;element name="SourceCurrencyIdentificationCode" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}CurrencyCode"/&gt;
 *         &lt;element name="TargetCurrencyIdentificationCode" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}CurrencyCode"/&gt;
 *         &lt;element name="CurrencyExchangeRate" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Numeric" minOccurs="0"/&gt;
 *         &lt;element name="SourceCurrencyScaleValue" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Numeric" minOccurs="0"/&gt;
 *         &lt;element name="TargetCurrencyScaleValue" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Numeric" minOccurs="0"/&gt;
 *         &lt;element name="ExchangeRateDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "sourceCurrencyIdentificationCode",
    "targetCurrencyIdentificationCode",
    "currencyExchangeRate",
    "sourceCurrencyScaleValue",
    "targetCurrencyScaleValue",
    "exchangeRateDateTime"
})
@XmlRootElement(name = "CurrencyConvertor")
public class CurrencyConvertor {

    @XmlElement(name = "SourceCurrencyIdentificationCode", required = true)
    protected CurrencyCode sourceCurrencyIdentificationCode;
    @XmlElement(name = "TargetCurrencyIdentificationCode", required = true)
    protected CurrencyCode targetCurrencyIdentificationCode;
    @XmlElement(name = "CurrencyExchangeRate")
    protected Numeric currencyExchangeRate;
    @XmlElement(name = "SourceCurrencyScaleValue", defaultValue = "1")
    protected Numeric sourceCurrencyScaleValue;
    @XmlElement(name = "TargetCurrencyScaleValue", defaultValue = "1")
    protected Numeric targetCurrencyScaleValue;
    @XmlElement(name = "ExchangeRateDateTime")
    protected String exchangeRateDateTime;

    /**
     * Gets the value of the sourceCurrencyIdentificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getSourceCurrencyIdentificationCode() {
        return sourceCurrencyIdentificationCode;
    }

    /**
     * Sets the value of the sourceCurrencyIdentificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setSourceCurrencyIdentificationCode(CurrencyCode value) {
        this.sourceCurrencyIdentificationCode = value;
    }

    /**
     * Gets the value of the targetCurrencyIdentificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getTargetCurrencyIdentificationCode() {
        return targetCurrencyIdentificationCode;
    }

    /**
     * Sets the value of the targetCurrencyIdentificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setTargetCurrencyIdentificationCode(CurrencyCode value) {
        this.targetCurrencyIdentificationCode = value;
    }

    /**
     * Gets the value of the currencyExchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link Numeric }
     *     
     */
    public Numeric getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    /**
     * Sets the value of the currencyExchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numeric }
     *     
     */
    public void setCurrencyExchangeRate(Numeric value) {
        this.currencyExchangeRate = value;
    }

    /**
     * Gets the value of the sourceCurrencyScaleValue property.
     * 
     * @return
     *     possible object is
     *     {@link Numeric }
     *     
     */
    public Numeric getSourceCurrencyScaleValue() {
        return sourceCurrencyScaleValue;
    }

    /**
     * Sets the value of the sourceCurrencyScaleValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numeric }
     *     
     */
    public void setSourceCurrencyScaleValue(Numeric value) {
        this.sourceCurrencyScaleValue = value;
    }

    /**
     * Gets the value of the targetCurrencyScaleValue property.
     * 
     * @return
     *     possible object is
     *     {@link Numeric }
     *     
     */
    public Numeric getTargetCurrencyScaleValue() {
        return targetCurrencyScaleValue;
    }

    /**
     * Sets the value of the targetCurrencyScaleValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numeric }
     *     
     */
    public void setTargetCurrencyScaleValue(Numeric value) {
        this.targetCurrencyScaleValue = value;
    }

    /**
     * Gets the value of the exchangeRateDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExchangeRateDateTime() {
        return exchangeRateDateTime;
    }

    /**
     * Sets the value of the exchangeRateDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExchangeRateDateTime(String value) {
        this.exchangeRateDateTime = value;
    }

}
