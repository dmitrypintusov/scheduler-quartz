package com.andersenlab.scheduler.quartz.services.impl;

import com.andersenlab.scheduler.quartz.dtos.JobRequest;
import com.andersenlab.scheduler.quartz.dtos.JobResponse;
import com.andersenlab.scheduler.quartz.jobs.Job;
import com.andersenlab.scheduler.quartz.mappers.JobMapper;
import com.andersenlab.scheduler.quartz.services.JobSchedulerService;
import com.andersenlab.scheduler.quartz.services.SchedulerFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchedulerFacadeImpl implements SchedulerFacade {

  private final JobSchedulerService jobSchedulerService;
  private final JobMapper jobMapper;

  public void scheduleEmailCron() {
    Job job = jobMapper.toEmailCronJob();
    jobSchedulerService.update(job);
  }

  @Override
  public JobResponse scheduleJob(JobRequest jobRequest) {
    Job job = jobMapper.toEmailJob(jobRequest);
    jobSchedulerService.create(job);
    return JobResponse.builder()
        .key(job.getKey().toString())
        .build();
  }
}
