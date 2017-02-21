package com.shenchao;

import com.shenchao.config.UserConvert;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * Created by shenchao on 2017/2/4.
 */
public class UserFormatterRegistry implements FormatterRegistrar {
    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addConverter(new UserConvert());
    }

}

