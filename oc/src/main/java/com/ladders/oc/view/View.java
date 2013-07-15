package com.ladders.oc.view;

import java.util.*;

import com.ladders.oc.application.Application;
import com.ladders.oc.display.*;
import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobs.Jobs;
import com.ladders.oc.jobseekers.JobSeeker;
import com.ladders.oc.recruiters.Recruiter;

public class View implements DisplayHandler
{
  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final View singleton = new View();
  }
  public static View getInstance()
  {
    return SingletonHolder.singleton;
  }

  @Override
  public void displayItem(Displayable item)
  {
    System.out.print(item.getDisplayText());
  }

  @Override
  public void displayItemLF(Displayable item)
  {
    System.out.println(item.getDisplayText());
  }

  @Override 
  public void displayList(DisplayableCollection col)
  {
    List<String> strings = col.getDisplayTextList();
    for (String text : strings)
      System.out.println(text);
  }

  @Override
  public void displayObjectLF(DisplayableObject obj)
  {
    String[] texts = obj.getDisplayTextArray();
    System.out.print(texts[0]);
    System.out.print(":");
    System.out.print(texts[1]);
    System.out.print(":");
    System.out.print(texts[2]);
    System.out.print(":");
    System.out.print(texts[3]);
    System.out.println();
  }
  
  @Override
  public void displayJobSeekerJob(Application app)
  {
    ApplicationDisplayer appview = new JobsAppliedToView();
    app.displayInstance(appview);
  }

  @Override
  public void reportByCSVItem(Application app)
  {
    ApplicationDisplayer appview = new CSVReport();
    app.displayInstance(appview);
  }

  @Override
  public void reportByHtmlItem(Application app)
  {
    ApplicationDisplayer appview = new HtmlReport();
    app.displayInstance(appview);
  }

  public void displayRecruiterJobs(Displayable obj,
                                          DisplayableCollection col)
  {
    System.out.print("Jobs posted by: ");
    displayItemLF(obj);
    displayList(col);    
  }

  public void displayAllJobsStart()
  {
    System.out.println();
    System.out.println("List of all jobs");    
  }

  public void displayAllJobsItem(Displayable obj1,
                                 Displayable obj2)
  {
    displayItem(obj1);
    System.out.print(" posted by ");
    displayItemLF(obj2);    
  }

  public void displaySavedJobsStart(Displayable obj)
  {
    System.out.println();
    System.out.print("Jobs Saved by ");
    displayItemLF(obj);
  }

  public void displaySavedJobsItem(Displayable obj)
  {
    displayItemLF(obj);
  }

  public void displayAppliedToJobsStart(Displayable obj)
  {
    System.out.println();
    System.out.print("Jobs applied to by ");
    displayItemLF(obj);
  }

  public void displayJobSeekersByDate(Displayable obj,
                                           Date date,
                                           DisplayableCollection col)
  {
    System.out.println();
    System.out.println("Jobseekers list by date");
    System.out.print("Recruier: ");
    displayItemLF(obj);
    System.out.print("Date:     ");
    System.out.println(date.toString());
    displayList(col);
  }

  public void displayJobSeekersByJob(Displayable obj1,
                                          Displayable obj2,
                                          DisplayableCollection col)
  {
    System.out.println();
    System.out.println("Jobseekers list by job");
    System.out.print("Recruier: ");
    displayItemLF(obj1);
    System.out.print("Job     : ");
    displayItemLF(obj2);
    displayList(col);
  }

  public void displayJobSeekersByJobDate(Displayable obj1,
                                              Displayable obj2,
                                              Date date,
                                              DisplayableCollection col)
  {
    System.out.println();
    System.out.println("Jobseekers list by job and date");
    System.out.print("Recruier: ");
    displayItemLF(obj1);
    System.out.print("Job     : ");
    displayItemLF(obj2);
    System.out.print("Date    : ");
    System.out.println(date.toString());    
    displayList(col);
  }

  public void displayAggregateApplicationsByJob(Displayable obj,
                                           int count)
  {
    System.out.println();
    System.out.println("Aggregate Applications by Job");
    System.out.print("Job     : ");
    displayItemLF(obj);
    System.out.println("Total = " + count);
  }

  public void displayAggregateApplicationsByRecruiter(Displayable obj,
                                                      int count)
  {
    System.out.println();
    System.out.println("Aggregate Applications by Recruiter");
    System.out.print("Recruier: ");
    displayItemLF(obj);
    System.out.println("Total = " + count);
  }

  public void reportByCSVStart()
  {
    System.out.println();
    System.out.println("Applications Report by CSV");    
  }

  public void reportByHtmlStart()
  {
    System.out.println();
    System.out.println("Applications Report by Html");    
    System.out.println("<html>");
    System.out.println("<table>");    
  }

  public void reportByHtmlEnd()
  {
    System.out.println("</table>");
    System.out.println("</html>");
  }
  
}
