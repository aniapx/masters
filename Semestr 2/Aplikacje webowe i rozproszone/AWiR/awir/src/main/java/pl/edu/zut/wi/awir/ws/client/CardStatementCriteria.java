
package pl.edu.zut.wi.awir.ws.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *           &lt;element name="CardStatementInfoType" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}CardStatInfoTypeCode" form="unqualified"/&gt;
 *           &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *           &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *           &lt;element name="CardAccountOwner" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}Party" form="unqualified"/&gt;
 *           &lt;element name="CustomerAccount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AccountNumber" form="unqualified"/&gt;
 *           &lt;element ref="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}CardIdentifier"/&gt;
 *           &lt;element name="CardAccount" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}AccountNumber" form="unqualified"/&gt;
 *           &lt;element name="CardFinancialInstitution" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FinancialInstitution" form="unqualified"/&gt;
 *           &lt;element name="CustomerFinancialInstitution" type="{http://www.wi.zut.edu.pl/xsd/payment/v1.0}FinancialInstitution" form="unqualified"/&gt;
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
    "cardStatementInfoTypeOrStartDateOrEndDate"
})
@XmlRootElement(name = "CardStatementCriteria")
public class CardStatementCriteria {

    @XmlElementRefs({
        @XmlElementRef(name = "CardStatementInfoType", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StartDate", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EndDate", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardAccountOwner", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustomerAccount", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardIdentifier", namespace = "http://www.wi.zut.edu.pl/xsd/payment/v1.0", type = CardIdentifier.class, required = false),
        @XmlElementRef(name = "CardAccount", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardFinancialInstitution", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustomerFinancialInstitution", type = JAXBElement.class, required = false)
    })
    protected List<Object> cardStatementInfoTypeOrStartDateOrEndDate;

    /**
     * Gets the value of the cardStatementInfoTypeOrStartDateOrEndDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardStatementInfoTypeOrStartDateOrEndDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardStatementInfoTypeOrStartDateOrEndDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link AccountNumber }{@code >}
     * {@link JAXBElement }{@code <}{@link AccountNumber }{@code >}
     * {@link JAXBElement }{@code <}{@link CardStatInfoTypeCode }{@code >}
     * {@link JAXBElement }{@code <}{@link FinancialInstitution }{@code >}
     * {@link JAXBElement }{@code <}{@link FinancialInstitution }{@code >}
     * {@link JAXBElement }{@code <}{@link Party }{@code >}
     * {@link CardIdentifier }
     * 
     * 
     */
    public List<Object> getCardStatementInfoTypeOrStartDateOrEndDate() {
        if (cardStatementInfoTypeOrStartDateOrEndDate == null) {
            cardStatementInfoTypeOrStartDateOrEndDate = new ArrayList<Object>();
        }
        return this.cardStatementInfoTypeOrStartDateOrEndDate;
    }

}
