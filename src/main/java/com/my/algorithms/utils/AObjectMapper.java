/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.algorithms.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author Матвей
 */
public class AObjectMapper extends ObjectMapper {

    public AObjectMapper() {
        super();
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        setTimeZone(TimeZone.getDefault());

        registerModule(new JodaModule());
    }

    /**
     * Регистрирует модули в ObjectMapper
     * @param modules список регистрируемых модулей
     */
    public void setModuleList (List<Module> modules) {
        modules.forEach((module) -> registerModule(module));
    }
    
}
