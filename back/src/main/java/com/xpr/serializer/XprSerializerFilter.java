package com.xpr.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.xpr.dao.helper.XprBaseModel;



public class XprSerializerFilter  extends SimpleBeanPropertyFilter {

    @Override
    public void serializeAsField (Object object, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {

        //XprBaseModel source = (XprBaseModel) object;
        
        writer.serializeAsField(object, jgen, provider);
    }

    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return true;
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return true;
    }
}
