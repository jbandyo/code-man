package com.ladders.oc.view;

import java.util.Date;

import com.ladders.oc.displayables.*;

public interface ConsoleView
{
  void displayRecruiterJobs(DisplayableRecruiter recruiter,
                            DisplayableJobs jobs);

  void displayAllJobsStart();
  void displayAllJobsItem(DisplayableJob job,
                          DisplayableRecruiter recruiter);
  void displayAllJobsEnd();

  void displaySavedJobsStart(DisplayableJobseeker jobseeker);
  void displaySavedJobsItem(DisplayableJob job);
  void displaySavedJobsEnd();

  void displayAppliedToJobsStart(DisplayableJobseeker jobseeker);
  void displayAppliedToJobsItem(DisplayableApplication app);
  void displayAppliedToJobsEnd();

  void displayJobSeekersByDate(DisplayableRecruiter recruiter,
                               Date date,
                               DisplayableJobseekers seekers);
  void displayJobSeekersByJob(DisplayableRecruiter recruiter,
                              DisplayableJob job,
                              DisplayableJobseekers seekers);
  void displayJobSeekersByJobDate(DisplayableRecruiter recruiter,
                                  DisplayableJob job,
                                  Date date,
                                  DisplayableJobseekers seekers);

  void displayAggregateApplicationsByJob(DisplayableJob job,
                                         int count);

  void displayAggregateApplicationsByRecruiter(DisplayableJob job,
                                               int count);

  void reportByCSVStart();
  void reportByCSVItem(DisplayableApplication app);
  void reportByCSVEnd();

  void reportByHtmlStart();
  void reportByHtmlItem(DisplayableApplication app);
  void reportByHtmlEnd();

}
