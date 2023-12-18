package com.andersenlab.scheduler.quartz.configs;

import com.andersenlab.scheduler.quartz.services.SchedulerFacade;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SchedulerInitializer {

  private final SchedulerFacade schedulerFacade;

  @EventListener(ApplicationReadyEvent.class)
  public void scheduleTransferDeleteJob() {
    schedulerFacade.scheduleEmailCron();
  }
}
