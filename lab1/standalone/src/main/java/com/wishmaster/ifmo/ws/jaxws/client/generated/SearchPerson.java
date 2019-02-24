
package com.wishmaster.ifmo.ws.jaxws.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchPerson"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="personName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="personSubname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="personAgeFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="personAgeTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="personStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="personHouseNumberFrom" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="personHouseNumberTo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchPerson", propOrder = {
    "personName",
    "personSubname",
    "personAgeFrom",
    "personAgeTo",
    "personStreet",
    "personHouseNumberFrom",
    "personHouseNumberTo"
})
public class SearchPerson {

    protected String personName;
    protected String personSubname;
    protected Integer personAgeFrom;
    protected Integer personAgeTo;
    protected String personStreet;
    protected Integer personHouseNumberFrom;
    protected Integer personHouseNumberTo;

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonName(String value) {
        this.personName = value;
    }

    /**
     * Gets the value of the personSubname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonSubname() {
        return personSubname;
    }

    /**
     * Sets the value of the personSubname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonSubname(String value) {
        this.personSubname = value;
    }

    /**
     * Gets the value of the personAgeFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPersonAgeFrom() {
        return personAgeFrom;
    }

    /**
     * Sets the value of the personAgeFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPersonAgeFrom(Integer value) {
        this.personAgeFrom = value;
    }

    /**
     * Gets the value of the personAgeTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPersonAgeTo() {
        return personAgeTo;
    }

    /**
     * Sets the value of the personAgeTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPersonAgeTo(Integer value) {
        this.personAgeTo = value;
    }

    /**
     * Gets the value of the personStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonStreet() {
        return personStreet;
    }

    /**
     * Sets the value of the personStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonStreet(String value) {
        this.personStreet = value;
    }

    /**
     * Gets the value of the personHouseNumberFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPersonHouseNumberFrom() {
        return personHouseNumberFrom;
    }

    /**
     * Sets the value of the personHouseNumberFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPersonHouseNumberFrom(Integer value) {
        this.personHouseNumberFrom = value;
    }

    /**
     * Gets the value of the personHouseNumberTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPersonHouseNumberTo() {
        return personHouseNumberTo;
    }

    /**
     * Sets the value of the personHouseNumberTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPersonHouseNumberTo(Integer value) {
        this.personHouseNumberTo = value;
    }

}
