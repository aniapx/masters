
package pl.edu.zut.wi.awir.ws.server;

import java.math.BigDecimal;
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
 *         &lt;element name="NominalName" type="{}max35text"/&gt;
 *         &lt;element name="NominalNumber" type="{}Decimal6.0"/&gt;
 *         &lt;element name="NominalValue" type="{}AmountType" minOccurs="0"/&gt;
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
    "nominalName",
    "nominalNumber",
    "nominalValue"
})
@XmlRootElement(name = "Denominations")
public class Denominations {

    @XmlElement(name = "NominalName", required = true)
    protected Max35Text nominalName;
    @XmlElement(name = "NominalNumber", required = true)
    protected BigDecimal nominalNumber;
    @XmlElement(name = "NominalValue")
    protected AmountType nominalValue;

    /**
     * Gets the value of the nominalName property.
     * 
     * @return
     *     possible object is
     *     {@link Max35Text }
     *     
     */
    public Max35Text getNominalName() {
        return nominalName;
    }

    /**
     * Sets the value of the nominalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max35Text }
     *     
     */
    public void setNominalName(Max35Text value) {
        this.nominalName = value;
    }

    /**
     * Gets the value of the nominalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNominalNumber() {
        return nominalNumber;
    }

    /**
     * Sets the value of the nominalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNominalNumber(BigDecimal value) {
        this.nominalNumber = value;
    }

    /**
     * Gets the value of the nominalValue property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getNominalValue() {
        return nominalValue;
    }

    /**
     * Sets the value of the nominalValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setNominalValue(AmountType value) {
        this.nominalValue = value;
    }

}
