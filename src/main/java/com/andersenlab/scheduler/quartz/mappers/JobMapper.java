package com.andersenlab.scheduler.quartz.mappers;

import com.andersenlab.scheduler.quartz.dtos.JobRequest;
import com.andersenlab.scheduler.quartz.jobs.Job;

public interface JobMapper {

  Job toEmailCronJob();

  Job toEmailJob(JobRequest jobRequest);
}
