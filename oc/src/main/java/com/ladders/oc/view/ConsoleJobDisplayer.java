package com.ladders.oc.view;

import com.ladders.oc.displayers.JobDisplayer;
import com.ladders.oc.displayers.JobTitleDisplayer;
import com.ladders.oc.jobs.JobTitle;

public class ConsoleJobDisplayer implements JobDisplayer
{

  @Override
  public void displayJob(JobTitle title)
  {
    JobTitleDisplayer titleDisplayer = new ConsoleJobTitleDisplayer();
    title.displayInstance(titleDisplayer);
  }

}
