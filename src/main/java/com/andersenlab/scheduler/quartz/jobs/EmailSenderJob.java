package com.andersenlab.scheduler.quartz.jobs;

import com.andersenlab.scheduler.quartz.services.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
@AllArgsConstructor
public class EmailSenderJob extends QuartzJobBean {

  private final MailService mailService;

  @Override
  protected void executeInternal(JobExecutionContext context) {
    mailService.send(
        "<your-email>",
        "Hey, don't forget!",
        "This is your friendly reminder.");
    log.info("Sent reminder email");
  }
}
