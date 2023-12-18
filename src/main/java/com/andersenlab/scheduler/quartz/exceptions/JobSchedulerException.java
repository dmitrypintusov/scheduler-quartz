package com.andersenlab.scheduler.quartz.exceptions;

public class JobSchedulerException extends RuntimeException {

  public JobSchedulerException(final String message) {
    super(message);
  }
}
