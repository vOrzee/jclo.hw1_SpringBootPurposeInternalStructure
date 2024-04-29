package ru.netology.hw1_SpringBootPurposeInternalStructure.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.hw1_SpringBootPurposeInternalStructure.profiles.DevProfile;
import ru.netology.hw1_SpringBootPurposeInternalStructure.profiles.ProductionProfile;
import ru.netology.hw1_SpringBootPurposeInternalStructure.profiles.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
