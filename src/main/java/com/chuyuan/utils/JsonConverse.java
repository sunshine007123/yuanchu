package com.chuyuan.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @ClassName JsonConverse
 * @Description TODO
 * @author yaoxw
 * @date 2017年5月8日下午11:52:57
 *
 */
public class JsonConverse {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    private static final JsonFactory FACTORY = new JsonFactory();

    @SuppressWarnings("unchecked")
    public static <T> T jsonToObject(String json, Class<?> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        return (T) MAPPER.readValue(json, clazz);
    }
    
    public static String ObjectToJson(Object obj) throws IOException {
        StringWriter sw = new StringWriter();
        JsonGenerator jsonGenerator = FACTORY.createGenerator(sw);
        MAPPER.writeValue(jsonGenerator, obj);
        return sw.toString();
    }
    
    public static String ObjectListToJson(List<?> list) {
        String result = null;
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", list.size());
        map.put("rows", list);
        try {
            result = MAPPER.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
