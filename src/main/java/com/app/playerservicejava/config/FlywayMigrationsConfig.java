package com.app.playerservicejava.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayMigrationsConfig {

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy(Flyway flyway) {
        return flyway1 -> {
            try {
                // Repair Flyway to clean up failed migration entries
                flyway.repair();

                // Run migrations after repair
                flyway.migrate();
            } catch (Exception e) {
                throw new RuntimeException("Flyway migration failed after repair", e);
            }
        };
    }
}
