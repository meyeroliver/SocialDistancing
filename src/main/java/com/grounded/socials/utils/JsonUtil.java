package com.grounded.socials.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import spark.ResponseTransformer;

import javax.persistence.OneToMany;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    public static String toJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static ResponseTransformer json(){
        return JsonUtil::toJson;
    }

    public static ObjectMapper objectMapper(){
        return mapper;
    }
}
