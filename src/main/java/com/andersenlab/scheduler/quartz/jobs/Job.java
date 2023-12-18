package com.andersenlab.scheduler.quartz.jobs;

import java.util.Date;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.quartz.JobKey;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Job {

  Class<? extends org.quartz.Job> clazz;
  JobKey key;
  String name;
  String group;
  Date scheduleAt;
  String cron;
  Map<String, Object> data;
}
