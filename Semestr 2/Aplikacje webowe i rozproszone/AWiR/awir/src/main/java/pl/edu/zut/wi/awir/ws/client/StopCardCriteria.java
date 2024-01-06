
package pl.edu.zut.wi.awir.ws.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}CardDetails"/&gt;
 *           &lt;element name="CardAccountOwner" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Party" form="unqualified"/&gt;
 *           &lt;element name="CardAccount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AccountNumber" form="unqualified"/&gt;
 *           &lt;element name="CardFinancialInstitution" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FinancialInstitution" form="unqualified"/&gt;
 *           &lt;element name="AdditionalInformationType" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max35text" form="unqualified"/&gt;
 *           &lt;element name="AdditionalInformation" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}max70text" form="unqualified"/&gt;
 *         &lt;/choice&gt;
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
    "cardDetailsOrCardAccountOwnerOrCardAccount"
})
@XmlRootElement(name = "StopCardCriteria")
public class StopCardCriteria {

    @XmlElements({
        @XmlElement(name = "CardDetails", type = CardDetails.class),
        @XmlElement(name = "CardAccountOwner", namespace = "", type = Party.class),
        @XmlElement(name = "CardAccount", namespace = "", type = AccountNumber.class),
        @XmlElement(name = "CardFinancialInstitution", namespace = "", type = FinancialInstitution.class),
        @XmlElement(name = "AdditionalInformationType", namespace = "", type = Max35Text.class),
        @XmlElement(name = "AdditionalInformation", namespace = "", type = Max70Text.class)
    })
    protected List<Object> cardDetailsOrCardAccountOwnerOrCardAccount;

    /**
     * Gets the value of the cardDetailsOrCardAccountOwnerOrCardAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardDetailsOrCardAccountOwnerOrCardAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardDetailsOrCardAccountOwnerOrCardAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountNumber }
     * {@link CardDetails }
     * {@link FinancialInstitution }
     * {@link Max35Text }
     * {@link Max70Text }
     * {@link Party }
     * 
     * 
     */
    public List<Object> getCardDetailsOrCardAccountOwnerOrCardAccount() {
        if (cardDetailsOrCardAccountOwnerOrCardAccount == null) {
            cardDetailsOrCardAccountOwnerOrCardAccount = new ArrayList<Object>();
        }
        return this.cardDetailsOrCardAccountOwnerOrCardAccount;
    }

}
