
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
 *         &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}CardDetails" maxOccurs="unbounded"/&gt;
 *         &lt;element name="CardAccountOwner" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Party" minOccurs="0"/&gt;
 *         &lt;element name="CardAccount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Account" minOccurs="0"/&gt;
 *         &lt;element name="CardFinancialInstitution" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FinancialInstitution" minOccurs="0"/&gt;
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
    "cardDetails",
    "cardAccountOwner",
    "cardAccount",
    "cardFinancialInstitution"
})
@XmlRootElement(name = "StoppedCardList")
public class StoppedCardList {

    @XmlElement(name = "CardDetails", required = true)
    protected List<CardDetails> cardDetails;
    @XmlElement(name = "CardAccountOwner")
    protected Party cardAccountOwner;
    @XmlElement(name = "CardAccount")
    protected Account cardAccount;
    @XmlElement(name = "CardFinancialInstitution")
    protected FinancialInstitution cardFinancialInstitution;

    /**
     * Gets the value of the cardDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardDetails }
     * 
     * 
     */
    public List<CardDetails> getCardDetails() {
        if (cardDetails == null) {
            cardDetails = new ArrayList<CardDetails>();
        }
        return this.cardDetails;
    }

    /**
     * Gets the value of the cardAccountOwner property.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getCardAccountOwner() {
        return cardAccountOwner;
    }

    /**
     * Sets the value of the cardAccountOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setCardAccountOwner(Party value) {
        this.cardAccountOwner = value;
    }

    /**
     * Gets the value of the cardAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getCardAccount() {
        return cardAccount;
    }

    /**
     * Sets the value of the cardAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setCardAccount(Account value) {
        this.cardAccount = value;
    }

    /**
     * Gets the value of the cardFinancialInstitution property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitution }
     *     
     */
    public FinancialInstitution getCardFinancialInstitution() {
        return cardFinancialInstitution;
    }

    /**
     * Sets the value of the cardFinancialInstitution property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitution }
     *     
     */
    public void setCardFinancialInstitution(FinancialInstitution value) {
        this.cardFinancialInstitution = value;
    }

}
