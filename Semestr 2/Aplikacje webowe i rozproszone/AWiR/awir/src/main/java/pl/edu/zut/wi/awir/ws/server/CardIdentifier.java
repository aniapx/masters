
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
 *         &lt;element name="CardIdent" type="{}max35Identifier" minOccurs="0"/&gt;
 *         &lt;element name="CardNumber" type="{}max16Identifier" minOccurs="0"/&gt;
 *         &lt;element name="CardConcealedNumber" type="{}max32Identifier" minOccurs="0"/&gt;
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
    "cardIdent",
    "cardNumber",
    "cardConcealedNumber"
})
@XmlRootElement(name = "CardIdentifier")
public class CardIdentifier {

    @XmlElement(name = "CardIdent")
    protected String cardIdent;
    @XmlElement(name = "CardNumber")
    protected String cardNumber;
    @XmlElement(name = "CardConcealedNumber")
    protected String cardConcealedNumber;

    /**
     * Gets the value of the cardIdent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardIdent() {
        return cardIdent;
    }

    /**
     * Sets the value of the cardIdent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardIdent(String value) {
        this.cardIdent = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the cardConcealedNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardConcealedNumber() {
        return cardConcealedNumber;
    }

    /**
     * Sets the value of the cardConcealedNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardConcealedNumber(String value) {
        this.cardConcealedNumber = value;
    }

}
