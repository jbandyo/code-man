package com.ladders.oc.view;

import com.ladders.oc.Name;
import com.ladders.oc.displayers.JobseekerDisplayer;
import com.ladders.oc.displayers.NameDisplayer;

public class ConsoleJobseekerDisplayer implements JobseekerDisplayer
{

  @Override
  public void displayJobseeker(Name name)
  {
    NameDisplayer nameDisplayer = new ConsoleNameDisplayer();
    name.displayInstance(nameDisplayer);

  }

}
