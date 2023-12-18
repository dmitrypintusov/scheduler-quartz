package com.andersenlab.scheduler.quartz.services;

import com.andersenlab.scheduler.quartz.jobs.Job;
import org.quartz.JobKey;

public interface JobSchedulerService {

  void create(Job job);

  void update(Job job);

  void delete(JobKey jobKey);
}
