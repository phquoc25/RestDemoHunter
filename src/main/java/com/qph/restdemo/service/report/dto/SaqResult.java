//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.22 at 04:07:52 PM ICT 
//


package com.qph.restdemo.service.report.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SaqResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SaqResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saqQuestionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="question" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="answer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="global" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaqResult", propOrder = {
    "saqQuestionCode",
    "question",
    "answer",
    "global"
})
public class SaqResult {

    @XmlElement(required = true)
    protected String saqQuestionCode;
    @XmlElement(required = true)
    protected String question;
    @XmlElement(required = true)
    protected String answer;
    @XmlElement(required = true)
    protected String global;

    /**
     * Gets the value of the saqQuestionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaqQuestionCode() {
        return saqQuestionCode;
    }

    /**
     * Sets the value of the saqQuestionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaqQuestionCode(String value) {
        this.saqQuestionCode = value;
    }

    /**
     * Gets the value of the question property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the value of the question property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestion(String value) {
        this.question = value;
    }

    /**
     * Gets the value of the answer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the value of the answer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswer(String value) {
        this.answer = value;
    }

    /**
     * Gets the value of the global property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobal() {
        return global;
    }

    /**
     * Sets the value of the global property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobal(String value) {
        this.global = value;
    }

}
