package com.shenchao.config;

import com.shenchao.User;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by shenchao on 2017/2/4.
 */
public class UserConvert implements Converter<String,User> {
    @Override
    public User convert(String source) {
        String[] split = source.split(":");
        return new User(split[0],Integer.parseInt(split[1]),split[2]);
    }
}
