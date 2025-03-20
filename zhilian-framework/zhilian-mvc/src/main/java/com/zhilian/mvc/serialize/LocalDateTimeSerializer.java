package com.zhilian.mvc.serialize;

import com.zhilian.common.utils.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeSerializer extends JsonSerializer {
    public static final LocalDateTimeSerializer instance = new LocalDateTimeSerializer();

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (o != null && o instanceof LocalDateTime) {
            LocalDateTime time = (LocalDateTime) o;
            jsonGenerator.writeString(DateUtils.format(time, DateUtils.DEFAULT_DATE_TIME_FORMAT));
        }
    }


}
