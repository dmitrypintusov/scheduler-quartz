package com.andersenlab.scheduler.quartz.mappers;

import com.andersenlab.scheduler.quartz.configs.properties.JobProperties;
import com.andersenlab.scheduler.quartz.configs.properties.JobProperties.JobProperty;
import com.andersenlab.scheduler.quartz.dtos.JobRequest;
import com.andersenlab.scheduler.quartz.jobs.EmailSenderJob;
import com.andersenlab.scheduler.quartz.jobs.Job;
import com.andersenlab.scheduler.quartz.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.quartz.JobKey;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobMapperImpl implements JobMapper {

  private final JobProperties jobProperties;

  @Override
  public Job toEmailCronJob() {
    JobProperty jobProperty = jobProperties.getEmail();
    return Job.builder()
        .clazz(EmailSenderJob.class)
        .key(toJobKey(jobProperty.getName(), jobProperty.getGroup()))
        .name(jobProperty.getName())
        .group(jobProperty.getGroup())
        .cron(jobProperty.getCron())
        .build();
  }

  @Override
  public Job toEmailJob(JobRequest jobRequest) {
    return Job.builder()
        .clazz(EmailSenderJob.class)
        .key(toJobKey(jobRequest.getName(), jobRequest.getGroup()))
        .name(jobRequest.getName())
        .group(jobRequest.getGroup())
        .scheduleAt(DateUtil.toDate(jobRequest.getScheduleAt()))
        .build();
  }

  private JobKey toJobKey(String name, String group) {
    return JobKey.jobKey(name, group);
  }
}
