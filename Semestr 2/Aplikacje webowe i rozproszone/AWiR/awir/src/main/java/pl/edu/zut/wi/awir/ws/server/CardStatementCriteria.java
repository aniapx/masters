
package pl.edu.zut.wi.awir.ws.server;

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
 *         &lt;element name="CardStatementInfoType" type="{}CardStatInfoTypeCode"/&gt;
 *         &lt;element name="StartDate" type="{}Date"/&gt;
 *         &lt;element name="EndDate" type="{}Date" minOccurs="0"/&gt;
 *         &lt;element name="CardAccountOwner" type="{}Party" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="CustomerAccount" type="{}AccountNumber"/&gt;
 *             &lt;element ref="{}CardIdentifier" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="CardAccount" type="{}AccountNumber"/&gt;
 *             &lt;element ref="{}CardIdentifier" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;element ref="{}CardIdentifier"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="CardFinancialInstitution" type="{}FinancialInstitution" minOccurs="0"/&gt;
 *         &lt;element name="CustomerFinancialInstitution" type="{}FinancialInstitution" minOccurs="0"/&gt;
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
    "content"
})
@XmlRootElement(name = "CardStatementCriteria")
public class CardStatementCriteria {

    @XmlElementRefs({
        @XmlElementRef(name = "CardStatementInfoType", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StartDate", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EndDate", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardAccountOwner", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustomerAccount", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardIdentifier", type = CardIdentifier.class, required = false),
        @XmlElementRef(name = "CardAccount", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardFinancialInstitution", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustomerFinancialInstitution", type = JAXBElement.class, required = false)
    })
    protected List<Object> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "CardIdentifier" is used by two different parts of a schema. See: 
     * line 45 of file:/C:/development/projects/idea/awir/src/main/resources/xsd/CardComponents.xsd
     * line 41 of file:/C:/development/projects/idea/awir/src/main/resources/xsd/CardComponents.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CardStatInfoTypeCode }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Party }{@code >}
     * {@link JAXBElement }{@code <}{@link AccountNumber }{@code >}
     * {@link CardIdentifier }
     * {@link JAXBElement }{@code <}{@link AccountNumber }{@code >}
     * {@link JAXBElement }{@code <}{@link FinancialInstitution }{@code >}
     * {@link JAXBElement }{@code <}{@link FinancialInstitution }{@code >}
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}
