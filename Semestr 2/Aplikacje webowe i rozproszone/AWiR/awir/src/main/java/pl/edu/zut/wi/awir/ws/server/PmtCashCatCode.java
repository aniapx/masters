
package pl.edu.zut.wi.awir.ws.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PmtCashCatCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PmtCashCatCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ZWG"/&gt;
 *     &lt;enumeration value="ZOK"/&gt;
 *     &lt;enumeration value="EWG"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PmtCashCatCode")
@XmlEnum
public enum PmtCashCatCode {

    ZWG,
    ZOK,
    EWG;

    public String value() {
        return name();
    }

    public static PmtCashCatCode fromValue(String v) {
        return valueOf(v);
    }

}
