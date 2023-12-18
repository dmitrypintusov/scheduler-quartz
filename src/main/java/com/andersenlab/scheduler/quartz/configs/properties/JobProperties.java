package com.andersenlab.scheduler.quartz.configs.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "job")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobProperties {

  JobProperty email;
  JobProperty chain;

  @Data
  @FieldDefaults(level = AccessLevel.PRIVATE)
  public static class JobProperty {

    String name;
    String group;
    String cron;
  }
}
