package com.gerv.featureflag.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "featuretoggle")
class FeatureToggleConfig {
    private Map<String, Boolean> features;
}
