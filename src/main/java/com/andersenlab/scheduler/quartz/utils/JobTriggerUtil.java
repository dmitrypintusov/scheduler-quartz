package com.andersenlab.scheduler.quartz.utils;

import static org.quartz.TriggerBuilder.newTrigger;

import com.andersenlab.scheduler.quartz.jobs.Job;
import java.util.Objects;
import java.util.TimeZone;
import lombok.experimental.UtilityClass;
import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;

@UtilityClass
public class JobTriggerUtil {

  public Trigger getTrigger(Job job) {
    if (Objects.isNull(job.getCron())) {
      return getSimpleTrigger(job);
    }
    return getCronTrigger(job);
  }

  private Trigger getSimpleTrigger(Job job) {
    return newTrigger()
        .withIdentity(job.getName(), job.getGroup())
        .startAt(job.getScheduleAt())
        .forJob(job.getName(), job.getGroup())
        .build();
  }

  private Trigger getCronTrigger(Job job) {
    return newTrigger()
        .withIdentity(job.getName(), job.getGroup())
        .withSchedule(CronScheduleBuilder
            .cronSchedule(job.getCron())
            .inTimeZone(TimeZone.getTimeZone(Constants.GMT_ID)))
        .forJob(job.getName(), job.getGroup())
        .build();
  }
}
