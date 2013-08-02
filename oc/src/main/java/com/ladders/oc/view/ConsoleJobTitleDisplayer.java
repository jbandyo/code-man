package com.ladders.oc.view;

import com.ladders.oc.displayers.JobTitleDisplayer;

public class ConsoleJobTitleDisplayer implements JobTitleDisplayer
{

  @Override
  public void displayJobTitle(String title)
  {
    System.out.print(title);
    
  }

}
