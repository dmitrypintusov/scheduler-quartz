package com.andersenlab.scheduler.quartz.services;

public interface MailService {

  void send(String to, String subject, String text);
}
