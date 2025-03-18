package com.zhilian.mvc.config;

import com.zhilian.mvc.filter.PackResultFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PackResultFilter.class)
public class FilterConfiguration {
}
