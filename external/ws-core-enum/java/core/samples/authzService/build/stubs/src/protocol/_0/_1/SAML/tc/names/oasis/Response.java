/**
 * Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package protocol._0._1.SAML.tc.names.oasis;

public class Response  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private org.apache.axis.message.MessageElement [] _any;
    private java.lang.String responseID;  // attribute
    private java.lang.String inResponseTo;  // attribute
    private int majorVersion;  // attribute
    private int minorVersion;  // attribute
    private java.lang.String issueInstant;  // attribute
    private java.lang.String recipient;  // attribute

    public Response() {
    }

    public Response(
           org.apache.axis.message.MessageElement [] _any,
           java.lang.String inResponseTo,
           java.lang.String issueInstant,
           int majorVersion,
           int minorVersion,
           java.lang.String recipient,
           java.lang.String responseID) {
           this._any = _any;
           this.responseID = responseID;
           this.inResponseTo = inResponseTo;
           this.majorVersion = majorVersion;
           this.minorVersion = minorVersion;
           this.issueInstant = issueInstant;
           this.recipient = recipient;
    }


    /**
     * Gets the _any value for this Response.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this Response.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }


    /**
     * Gets the responseID value for this Response.
     * 
     * @return responseID
     */
    public java.lang.String getResponseID() {
        return responseID;
    }


    /**
     * Sets the responseID value for this Response.
     * 
     * @param responseID
     */
    public void setResponseID(java.lang.String responseID) {
        this.responseID = responseID;
    }


    /**
     * Gets the inResponseTo value for this Response.
     * 
     * @return inResponseTo
     */
    public java.lang.String getInResponseTo() {
        return inResponseTo;
    }


    /**
     * Sets the inResponseTo value for this Response.
     * 
     * @param inResponseTo
     */
    public void setInResponseTo(java.lang.String inResponseTo) {
        this.inResponseTo = inResponseTo;
    }


    /**
     * Gets the majorVersion value for this Response.
     * 
     * @return majorVersion
     */
    public int getMajorVersion() {
        return majorVersion;
    }


    /**
     * Sets the majorVersion value for this Response.
     * 
     * @param majorVersion
     */
    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }


    /**
     * Gets the minorVersion value for this Response.
     * 
     * @return minorVersion
     */
    public int getMinorVersion() {
        return minorVersion;
    }


    /**
     * Sets the minorVersion value for this Response.
     * 
     * @param minorVersion
     */
    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }


    /**
     * Gets the issueInstant value for this Response.
     * 
     * @return issueInstant
     */
    public java.lang.String getIssueInstant() {
        return issueInstant;
    }


    /**
     * Sets the issueInstant value for this Response.
     * 
     * @param issueInstant
     */
    public void setIssueInstant(java.lang.String issueInstant) {
        this.issueInstant = issueInstant;
    }


    /**
     * Gets the recipient value for this Response.
     * 
     * @return recipient
     */
    public java.lang.String getRecipient() {
        return recipient;
    }


    /**
     * Sets the recipient value for this Response.
     * 
     * @param recipient
     */
    public void setRecipient(java.lang.String recipient) {
        this.recipient = recipient;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Response)) return false;
        Response other = (Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any()))) &&
            ((this.responseID==null && other.getResponseID()==null) || 
             (this.responseID!=null &&
              this.responseID.equals(other.getResponseID()))) &&
            ((this.inResponseTo==null && other.getInResponseTo()==null) || 
             (this.inResponseTo!=null &&
              this.inResponseTo.equals(other.getInResponseTo()))) &&
            this.majorVersion == other.getMajorVersion() &&
            this.minorVersion == other.getMinorVersion() &&
            ((this.issueInstant==null && other.getIssueInstant()==null) || 
             (this.issueInstant!=null &&
              this.issueInstant.equals(other.getIssueInstant()))) &&
            ((this.recipient==null && other.getRecipient()==null) || 
             (this.recipient!=null &&
              this.recipient.equals(other.getRecipient())));
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
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResponseID() != null) {
            _hashCode += getResponseID().hashCode();
        }
        if (getInResponseTo() != null) {
            _hashCode += getInResponseTo().hashCode();
        }
        _hashCode += getMajorVersion();
        _hashCode += getMinorVersion();
        if (getIssueInstant() != null) {
            _hashCode += getIssueInstant().hashCode();
        }
        if (getRecipient() != null) {
            _hashCode += getRecipient().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:oasis:names:tc:SAML:1.0:protocol", ">Response"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("responseID");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ResponseID"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("inResponseTo");
        attrField.setXmlName(new javax.xml.namespace.QName("", "InResponseTo"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("majorVersion");
        attrField.setXmlName(new javax.xml.namespace.QName("", "MajorVersion"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("minorVersion");
        attrField.setXmlName(new javax.xml.namespace.QName("", "MinorVersion"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("issueInstant");
        attrField.setXmlName(new javax.xml.namespace.QName("", "IssueInstant"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("recipient");
        attrField.setXmlName(new javax.xml.namespace.QName("", "Recipient"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
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
