
package com.wishmaster.ifmo.ws.jaxws.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentsFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentsFilter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="studyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="speciality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="semesterBounds" type="{http://jaxws.ws.ifmo.wishmaster.com/}intBounds" minOccurs="0"/&gt;
 *         &lt;element name="debtsBounds" type="{http://jaxws.ws.ifmo.wishmaster.com/}intBounds" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentsFilter", propOrder = {
    "name",
    "studyType",
    "speciality",
    "semesterBounds",
    "debtsBounds"
})
public class StudentsFilter {

    protected String name;
    protected String studyType;
    protected String speciality;
    protected IntBounds semesterBounds;
    protected IntBounds debtsBounds;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the studyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStudyType() {
        return studyType;
    }

    /**
     * Sets the value of the studyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStudyType(String value) {
        this.studyType = value;
    }

    /**
     * Gets the value of the speciality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Sets the value of the speciality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpeciality(String value) {
        this.speciality = value;
    }

    /**
     * Gets the value of the semesterBounds property.
     * 
     * @return
     *     possible object is
     *     {@link IntBounds }
     *     
     */
    public IntBounds getSemesterBounds() {
        return semesterBounds;
    }

    /**
     * Sets the value of the semesterBounds property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntBounds }
     *     
     */
    public void setSemesterBounds(IntBounds value) {
        this.semesterBounds = value;
    }

    /**
     * Gets the value of the debtsBounds property.
     * 
     * @return
     *     possible object is
     *     {@link IntBounds }
     *     
     */
    public IntBounds getDebtsBounds() {
        return debtsBounds;
    }

    /**
     * Sets the value of the debtsBounds property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntBounds }
     *     
     */
    public void setDebtsBounds(IntBounds value) {
        this.debtsBounds = value;
    }

}
