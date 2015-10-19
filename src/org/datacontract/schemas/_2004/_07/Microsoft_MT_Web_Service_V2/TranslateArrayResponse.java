/**
 * TranslateArrayResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2;

public class TranslateArrayResponse  implements java.io.Serializable {
    private java.lang.String error;

    private java.lang.String from;

    private int[] originalTextSentenceLengths;

    private java.lang.String state;

    private java.lang.String translatedText;

    private int[] translatedTextSentenceLengths;

    public TranslateArrayResponse() {
    }

    public TranslateArrayResponse(
           java.lang.String error,
           java.lang.String from,
           int[] originalTextSentenceLengths,
           java.lang.String state,
           java.lang.String translatedText,
           int[] translatedTextSentenceLengths) {
           this.error = error;
           this.from = from;
           this.originalTextSentenceLengths = originalTextSentenceLengths;
           this.state = state;
           this.translatedText = translatedText;
           this.translatedTextSentenceLengths = translatedTextSentenceLengths;
    }


    /**
     * Gets the error value for this TranslateArrayResponse.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this TranslateArrayResponse.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
    }


    /**
     * Gets the from value for this TranslateArrayResponse.
     * 
     * @return from
     */
    public java.lang.String getFrom() {
        return from;
    }


    /**
     * Sets the from value for this TranslateArrayResponse.
     * 
     * @param from
     */
    public void setFrom(java.lang.String from) {
        this.from = from;
    }


    /**
     * Gets the originalTextSentenceLengths value for this TranslateArrayResponse.
     * 
     * @return originalTextSentenceLengths
     */
    public int[] getOriginalTextSentenceLengths() {
        return originalTextSentenceLengths;
    }


    /**
     * Sets the originalTextSentenceLengths value for this TranslateArrayResponse.
     * 
     * @param originalTextSentenceLengths
     */
    public void setOriginalTextSentenceLengths(int[] originalTextSentenceLengths) {
        this.originalTextSentenceLengths = originalTextSentenceLengths;
    }


    /**
     * Gets the state value for this TranslateArrayResponse.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this TranslateArrayResponse.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the translatedText value for this TranslateArrayResponse.
     * 
     * @return translatedText
     */
    public java.lang.String getTranslatedText() {
        return translatedText;
    }


    /**
     * Sets the translatedText value for this TranslateArrayResponse.
     * 
     * @param translatedText
     */
    public void setTranslatedText(java.lang.String translatedText) {
        this.translatedText = translatedText;
    }


    /**
     * Gets the translatedTextSentenceLengths value for this TranslateArrayResponse.
     * 
     * @return translatedTextSentenceLengths
     */
    public int[] getTranslatedTextSentenceLengths() {
        return translatedTextSentenceLengths;
    }


    /**
     * Sets the translatedTextSentenceLengths value for this TranslateArrayResponse.
     * 
     * @param translatedTextSentenceLengths
     */
    public void setTranslatedTextSentenceLengths(int[] translatedTextSentenceLengths) {
        this.translatedTextSentenceLengths = translatedTextSentenceLengths;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TranslateArrayResponse)) return false;
        TranslateArrayResponse other = (TranslateArrayResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError()))) &&
            ((this.from==null && other.getFrom()==null) || 
             (this.from!=null &&
              this.from.equals(other.getFrom()))) &&
            ((this.originalTextSentenceLengths==null && other.getOriginalTextSentenceLengths()==null) || 
             (this.originalTextSentenceLengths!=null &&
              java.util.Arrays.equals(this.originalTextSentenceLengths, other.getOriginalTextSentenceLengths()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.translatedText==null && other.getTranslatedText()==null) || 
             (this.translatedText!=null &&
              this.translatedText.equals(other.getTranslatedText()))) &&
            ((this.translatedTextSentenceLengths==null && other.getTranslatedTextSentenceLengths()==null) || 
             (this.translatedTextSentenceLengths!=null &&
              java.util.Arrays.equals(this.translatedTextSentenceLengths, other.getTranslatedTextSentenceLengths())));
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
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        if (getFrom() != null) {
            _hashCode += getFrom().hashCode();
        }
        if (getOriginalTextSentenceLengths() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOriginalTextSentenceLengths());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOriginalTextSentenceLengths(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getTranslatedText() != null) {
            _hashCode += getTranslatedText().hashCode();
        }
        if (getTranslatedTextSentenceLengths() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTranslatedTextSentenceLengths());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTranslatedTextSentenceLengths(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TranslateArrayResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "TranslateArrayResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "Error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("from");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "From"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalTextSentenceLengths");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "OriginalTextSentenceLengths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "State"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("translatedText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "TranslatedText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("translatedTextSentenceLengths");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", "TranslatedTextSentenceLengths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
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
