package com.andersenlab.scheduler.quartz.utils;

import com.andersenlab.scheduler.quartz.jobs.Job;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

@UtilityClass
public class JobDetailsUtil {

  public JobDetail getJobDetails(Job job) {
    JobBuilder jobBuilder = JobBuilder
        .newJob(job.getClazz())
        .withIdentity(job.getName(), job.getGroup())
        .storeDurably(false);

    if (Objects.nonNull(job.getData())) {
      jobBuilder.usingJobData(new JobDataMap(job.getData()));
    }

    return jobBuilder.build();
  }
}
