package com.shenchao.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shenchao.User;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by shenchao on 2017/2/4.
 */
public class TestJackson {
    public static void main(String[] args) throws IOException {
/***************************************序列化***************************************************/
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer,new User("sc",new Date(),2,"男","234"));
        System.out.println(writer.toString());
/***************************************反序列化**************************************************/
        String jsonStr = "{\"birthday\":\"2017-02-04\",\"password\":\"234\",\"HAHAHA\":\"男\"}";
        User user = mapper.readValue(jsonStr, User.class);
        System.out.println(user);
    }
}
