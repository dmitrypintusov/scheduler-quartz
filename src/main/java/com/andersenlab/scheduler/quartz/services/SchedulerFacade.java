package com.andersenlab.scheduler.quartz.services;

import com.andersenlab.scheduler.quartz.dtos.JobRequest;
import com.andersenlab.scheduler.quartz.dtos.JobResponse;

public interface SchedulerFacade {

  void scheduleEmailCron();

  JobResponse scheduleJob(JobRequest jobRequest);
}
