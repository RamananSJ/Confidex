package com.Ramanan.Project.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class LoggingConfiguration {
    @Bean
    public CommonsRequestLoggingFilter loggingFilter() {
        return new CommonsRequestLoggingFilter() {
            {
                setIncludeQueryString(true);
                setIncludePayload(true);
                setMaxPayloadLength(10000);
                setIncludeHeaders(false);
            }
        };
    }
}
