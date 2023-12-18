package com.andersenlab.scheduler.quartz.controllers;

import com.andersenlab.scheduler.quartz.dtos.JobRequest;
import com.andersenlab.scheduler.quartz.dtos.JobResponse;
import com.andersenlab.scheduler.quartz.services.SchedulerFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class SchedulerController {

  private final SchedulerFacade schedulerFacade;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public JobResponse contactUs(@RequestBody JobRequest jobRequest) {
    return schedulerFacade.scheduleJob(jobRequest);
  }
}
