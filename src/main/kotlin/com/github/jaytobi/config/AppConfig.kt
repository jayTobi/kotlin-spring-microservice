package com.github.jaytobi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.ShallowEtagHeaderFilter
import javax.servlet.Filter

/**
 * Configuration class for common application settings.
 */
@Configuration
class AppConfig {
    /**
     * Filter configuration for ETag that can be used for (client side) caching.
     */
    @Bean
    fun shallowETagHeaderFilter(): Filter {
        return ShallowEtagHeaderFilter()
    }
}