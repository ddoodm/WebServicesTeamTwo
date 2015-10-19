/**
 * TranslationMatch.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2;

public class TranslationMatch  implements java.io.Serializable {
    private int count;

    private java.lang.String error;

    private int matchDegree;

    private java.lang.String matchedOriginalText;

    private int rating;

    private java.lang.String translatedText;

    public TranslationMatch() {
    }

    public TranslationMatch(
           int count,
           java.lang.String error,
           int matchDegree,
           java.lang.String matchedOriginalText,
           int rating,
           java.lang.String translatedText) {
           this.count = count;
           this.error = error;
           this.matchDegree = matchDegree;
           this.matchedOriginalText = matchedOriginalText;
           this.rating = rating;
           this.translatedText = translatedText;
    }


    /**
     * Gets the count value for this TranslationMatch.
     * 
     * @return count
     */
    public int getCount() {
        return count;
    }


    /**
     * Sets the count value for this TranslationMatch.
     * 
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }


    /**
     * Gets the error value for this TranslationMatch.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this TranslationMatch.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
    }


    /**
     * Gets the matchDegree value for this TranslationMatch.
     * 
     * @return matchDegree
     */
    public int getMatchDegree() {
        return matchDegree;
    }


    /**
     * Sets the matchDegree value for this TranslationMatch.
     * 
     * @param matchDegree
     */
    public void setMatchDegree(int matchDegree) {
        this.matchDegree = matchDegree;
    }


    /**
     * Gets the matchedOriginalText value for this TranslationMatch.
     * 
     * @return matchedOriginalText
     */
    public java.lang.String getMatchedOriginalText() {
        return matchedOriginalText;
    }


    /**
     * Sets the matchedOriginalText value for this TranslationMatch.
     * 
     * @param matchedOriginalText
     */
    public void setMatchedOriginalText(java.lang.String matchedOriginalText) {
        this.matchedOriginalText = matchedOriginalText;
    }


    /**
     * Gets the rating value for this TranslationMatch.
     * 
     * @return rating
     */
    public int getRating() {
        return rating;
    }


    /**
     * Sets the rating value for this TranslationMatch.
     * 
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }


    /**
     * Gets the translatedText value for this TranslationMatch.
     * 
     * @return translatedText
     */
    public java.lang.String getTranslatedText() {
        return translatedText;
    }


    /**
     * Sets the translatedText value for this TranslationMatch.
     * 
     * @param translatedText
     */
    public void setTranslatedText(java.lang.String translatedText) {
        this.translatedText = translatedText;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TranslationMatch)) return false;
        TranslationMatch other = (TranslationMatch) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.count == other.getCount() &&
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError()))) &&
            this.matchDegree == other.getMatchDegree() &&
            ((this.matchedOriginalText==null && other.getMatchedOriginalText()==null) || 
             (this.matchedOriginalText!=null &&
              this.matchedOriginalText.equals(other.getMatchedOriginalText()))) &&
            this.rating == other.getRating() &&
            ((this.translatedText==null && other.getTranslatedText()==null) || 
             (this.translatedText!=null &&
              this.translatedText.equals(other.getTranslatedText())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCount();
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        _hashCode += getMatchDegree();
        if (getMatchedOriginalText() != null) {
            _hashCode += getMatchedOriginalText().hashCode();
        }
        _hashCode += getRating();
        if (getTranslatedText() != null) {
            _hashCode += getTranslatedText().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TranslationMatch.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "TranslationMatch"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("count");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "Count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "Error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchDegree");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "MatchDegree"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchedOriginalText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "MatchedOriginalText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rating");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "Rating"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("translatedText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "TranslatedText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
