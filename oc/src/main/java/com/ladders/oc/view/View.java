package com.ladders.oc.view;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ladders.oc.displayables.*;
import com.ladders.oc.displayers.*;

public class View implements ConsoleView
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
  
  private void printDate(Date date)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
    System.out.println(sdf.format(date));
  }

  @Override
  public void displayRecruiterJobs(DisplayableRecruiter recruiter,
                                   DisplayableJobs jobs)
  {
    System.out.print("Jobs posted by: ");
    RecruiterDisplayer recDisplayer = new ConsoleRecruiterDisplayer();
    recruiter.displayInstance(recDisplayer);
    System.out.println();
    JobsDisplayer displayer = new ConsoleJobsDisplayer();
    jobs.displayCollection(displayer);
  }

  @Override
  public void displayAllJobsStart()
  {
    System.out.println();
    System.out.println("List of all jobs");    
  }

  @Override
  public void displayAllJobsItem(DisplayableJob job,
                                 DisplayableRecruiter recruiter)
  {
    System.out.print("- ");
    JobDisplayer jobDisplayer = new ConsoleJobDisplayer();
    job.displayInstance(jobDisplayer);
    System.out.print(" posted by ");
    RecruiterDisplayer recDisplayer = new ConsoleRecruiterDisplayer();
    recruiter.displayInstance(recDisplayer);
    System.out.println();
  }

  @Override
  public void displayAllJobsEnd()
  {
    System.out.println("==============================");
  }

  @Override
  public void displaySavedJobsStart(DisplayableJobseeker jobseeker)
  {
    System.out.println();
    System.out.print("Jobs Saved by ");
    JobseekerDisplayer displayer = new ConsoleJobseekerDisplayer();
    jobseeker.displayInstance(displayer);
    System.out.println();
  }

  @Override
  public void displaySavedJobsItem(DisplayableJob job)
  {
    System.out.print("- ");
    JobDisplayer jobDisplayer = new ConsoleJobDisplayer();
    job.displayInstance(jobDisplayer);
    System.out.println();
  }

  @Override
  public void displaySavedJobsEnd()
  {
    System.out.println("==============================");
  }

  @Override
  public void displayAppliedToJobsStart(DisplayableJobseeker jobseeker)
  {
    System.out.println();
    System.out.print("Jobs applied to by ");
    JobseekerDisplayer displayer = new ConsoleJobseekerDisplayer();
    jobseeker.displayInstance(displayer);
    System.out.println();
  }

  @Override
  public void displayAppliedToJobsItem(DisplayableApplication app)
  {
    System.out.print("- ");
    ApplicationDisplayer displayer = new ConsoleApplicationDisplayer();
    app.displayInstance(displayer);    
    System.out.println();
  }

  @Override
  public void displayAppliedToJobsEnd()
  {
    System.out.println("==============================");
  }

  @Override
  public void displayJobSeekersByDate(DisplayableRecruiter recruiter,
                                      Date date,
                                      DisplayableJobseekers seekers)
  {
    System.out.println();
    System.out.println("Jobseekers list by date");
    System.out.print("Recruier: ");
    RecruiterDisplayer recDisplayer = new ConsoleRecruiterDisplayer();
    recruiter.displayInstance(recDisplayer);
    System.out.println();
    System.out.print("Date:     ");
    printDate(date);
    JobseekersDisplayer displayer = new ConsoleJobseekersDisplayer();
    seekers.displayCollection(displayer);
  }

  @Override
  public void displayJobSeekersByJob(DisplayableRecruiter recruiter,
                                     DisplayableJob job,
                                     DisplayableJobseekers seekers)
  {
    System.out.println();
    System.out.println("Jobseekers list by job");
    System.out.print("Recruier: ");
    RecruiterDisplayer recDisplayer = new ConsoleRecruiterDisplayer();
    recruiter.displayInstance(recDisplayer);
    System.out.println();
    System.out.print("Job     : ");
    JobDisplayer jobDisplayer = new ConsoleJobDisplayer();
    job.displayInstance(jobDisplayer);
    System.out.println();
    JobseekersDisplayer displayer = new ConsoleJobseekersDisplayer();
    seekers.displayCollection(displayer);
  }

  @Override
  public void displayJobSeekersByJobDate(DisplayableRecruiter recruiter,
                                         DisplayableJob job,
                                         Date date,
                                         DisplayableJobseekers seekers)
  {
    JobDisplayer jobDisplayer = new ConsoleJobDisplayer();
    System.out.println();
    System.out.println("Jobseekers list by job and date");
    System.out.print("Recruier: ");
    RecruiterDisplayer recDisplayer = new ConsoleRecruiterDisplayer();
    recruiter.displayInstance(recDisplayer);
    System.out.println();
    System.out.print("Job     : ");
    job.displayInstance(jobDisplayer);
    System.out.println();
    System.out.print("Date    : ");
    printDate(date);
    JobseekersDisplayer displayer = new ConsoleJobseekersDisplayer();
    seekers.displayCollection(displayer);
  }

  @Override
  public void displayAggregateApplicationsByJob(DisplayableJob job,
                                                int count)
  {
    JobDisplayer jobDisplayer = new ConsoleJobDisplayer();
    System.out.println();
    System.out.println("Aggregate Applications by Job");
    System.out.print("Job     : ");
    job.displayInstance(jobDisplayer);
    System.out.println();
    System.out.println("Total = " + count);
  }

  @Override
  public void displayAggregateApplicationsByRecruiter(DisplayableJob job,
                                                      int count)
  {
    JobDisplayer jobDisplayer = new ConsoleJobDisplayer();
    System.out.println();
    System.out.println("Aggregate Applications by Recruiter");
    System.out.print("Recruier: ");
    job.displayInstance(jobDisplayer);
    System.out.println();
    System.out.println("Total = " + count);
  }

  @Override
  public void reportByCSVStart()
  {
    System.out.println();
    System.out.println("Applications Report by CSV");    
  }

  @Override
  public void reportByCSVItem(DisplayableApplication app)
  {
    ApplicationDisplayer appview = new CSVReport();
    app.displayInstance(appview);
  }

  @Override
  public void reportByCSVEnd()
  {
    System.out.println("==============================");
  }

  @Override
  public void reportByHtmlStart()
  {
    System.out.println();
    System.out.println("Applications Report by Html");    
    System.out.println("<html>");
    System.out.println("<body>");
    System.out.println("<table>");    
  }

  @Override
  public void reportByHtmlItem(DisplayableApplication app)
  {
    ApplicationDisplayer appview = new HtmlReport();
    app.displayInstance(appview);
  }

  @Override
  public void reportByHtmlEnd()
  {
    System.out.println("</table>");
    System.out.println("</body>");
    System.out.println("</html>");
  }
 
}
