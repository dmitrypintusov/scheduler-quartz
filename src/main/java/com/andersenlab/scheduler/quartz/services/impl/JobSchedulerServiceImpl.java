package com.andersenlab.scheduler.quartz.services.impl;

import com.andersenlab.scheduler.quartz.exceptions.JobSchedulerException;
import com.andersenlab.scheduler.quartz.jobs.Job;
import com.andersenlab.scheduler.quartz.services.JobSchedulerService;
import com.andersenlab.scheduler.quartz.utils.JobDetailsUtil;
import com.andersenlab.scheduler.quartz.utils.JobTriggerUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobSchedulerServiceImpl implements JobSchedulerService {

  private final SchedulerFactoryBean schedulerFactoryBean;

  @Override
  public void create(Job job) {
    try {
      Scheduler scheduler = schedulerFactoryBean.getScheduler();
      JobDetail jobDetail = JobDetailsUtil.getJobDetails(job);

      if (scheduler.checkExists(jobDetail.getKey())) {
        log.debug(String.format("Job with name %s and job group %s has already existed",
            job.getName(),
            job.getGroup())
        );
        return;
      }
      Trigger trigger = JobTriggerUtil.getTrigger(job);
      scheduler.scheduleJob(jobDetail, trigger);
      log.debug(String.format("Job scheduled. Job name: %s. Job group: %s.",
          job.getName(),
          job.getGroup())
      );
    } catch (SchedulerException e) {
      throw new JobSchedulerException(
          String.format("Scheduling failed. Job name: %s. Job group: %s. Reason: %s",
              job.getName(),
              job.getGroup(),
              e.getMessage()));
    }
  }

  @Override
  public void delete(JobKey jobKey) {
    try {
      Scheduler scheduler = schedulerFactoryBean.getScheduler();
      scheduler.deleteJob(jobKey);
      log.debug(String.format("Job deleted successful. Job name: %s. Job group: %s.",
          jobKey.getName(),
          jobKey.getGroup())
      );
    } catch (SchedulerException e) {
      throw new JobSchedulerException(
          String.format("Job deleting failed. Job name: %s. Job group: %s. Reason: %s",
              jobKey.getName(),
              jobKey.getGroup(),
              e.getMessage()));
    }
  }

  @Override
  public void update(Job job) {
    delete(job.getKey());
    create(job);
  }
}
