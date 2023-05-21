package com.github.hugovallada.primeiroprojetospringbatch.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class DatasourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    fun springDataSource(): DataSource {
        return DataSourceBuilder.create()
            .build()
    }

    @Bean
    @ConfigurationProperties(prefix = "app.datasource")
    fun appDataSource(): DataSource {
        return DataSourceBuilder.create()
            .build()
    }
}