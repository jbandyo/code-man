package com.ladders.oc.view;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ladders.oc.dispinterface.*;

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
    SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yy");
    System.out.println(sdf.format(date));
  }

  private void displayItem(Displayable item)
  {
    System.out.print(item.getDisplayText());
  }

  private void displayItemLF(Displayable item)
  {
    System.out.println(item.getDisplayText());
  }

  private void displayList(DisplayableCollection col)
  {
    List<String> strings = col.getDisplayTextList();
    for (String text : strings)
      System.out.println(text);
  }

  private void displayObjectLF(DisplayableObject obj)
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
  
  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayRecruiterJobs(com.ladders.oc.dispinterface.Displayable, com.ladders.oc.dispinterface.DisplayableCollection)
   */
  @Override
  public void displayRecruiterJobs(Displayable obj,
                                   DisplayableCollection col)
  {
    System.out.print("Jobs posted by: ");
    displayItemLF(obj);
    displayList(col);    
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayAllJobsStart()
   */
  @Override
  public void displayAllJobsStart()
  {
    System.out.println();
    System.out.println("List of all jobs");    
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayAllJobsItem(com.ladders.oc.dispinterface.Displayable, com.ladders.oc.dispinterface.Displayable)
   */
  @Override
  public void displayAllJobsItem(Displayable obj1,
                                 Displayable obj2)
  {
    displayItem(obj1);
    System.out.print(" posted by ");
    displayItemLF(obj2);    
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayAllJobsStart()
   */
  @Override
  public void displayAllJobsEnd()
  {
    System.out.println("==============================");
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displaySavedJobsStart(com.ladders.oc.dispinterface.Displayable)
   */
  @Override
  public void displaySavedJobsStart(Displayable obj)
  {
    System.out.println();
    System.out.print("Jobs Saved by ");
    displayItemLF(obj);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displaySavedJobsItem(com.ladders.oc.dispinterface.Displayable)
   */
  @Override
  public void displaySavedJobsItem(Displayable obj)
  {
    displayItemLF(obj);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displaySavedJobsStart(com.ladders.oc.dispinterface.Displayable)
   */
  @Override
  public void displaySavedJobsEnd()
  {
    System.out.println("==============================");
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayAppliedToJobsStart(com.ladders.oc.dispinterface.Displayable)
   */
  @Override
  public void displayAppliedToJobsStart(Displayable obj)
  {
    System.out.println();
    System.out.print("Jobs applied to by ");
    displayItemLF(obj);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayJobSeekerJob(com.ladders.oc.dispinterface.FieldDisplayable)
   */
  @Override
  public void displayAppliedToJobsItem(FieldDisplayable app)
  {
    ApplicationDisplayer appview = new JobsAppliedToView();
    app.displayInstance(appview);    
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayAppliedToJobsStart(com.ladders.oc.dispinterface.Displayable)
   */
  @Override
  public void displayAppliedToJobsEnd()
  {
    System.out.println("==============================");
  }


  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayJobSeekersByDate(com.ladders.oc.dispinterface.Displayable, java.util.Date, com.ladders.oc.dispinterface.DisplayableCollection)
   */
  @Override
  public void displayJobSeekersByDate(Displayable obj,
                                           Date date,
                                           DisplayableCollection col)
  {
    System.out.println();
    System.out.println("Jobseekers list by date");
    System.out.print("Recruier: ");
    displayItemLF(obj);
    System.out.print("Date:     ");
    printDate(date);
    displayList(col);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayJobSeekersByJob(com.ladders.oc.dispinterface.Displayable, com.ladders.oc.dispinterface.Displayable, com.ladders.oc.dispinterface.DisplayableCollection)
   */
  @Override
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

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayJobSeekersByJobDate(com.ladders.oc.dispinterface.Displayable, com.ladders.oc.dispinterface.Displayable, java.util.Date, com.ladders.oc.dispinterface.DisplayableCollection)
   */
  @Override
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
    printDate(date);
    displayList(col);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayAggregateApplicationsByJob(com.ladders.oc.dispinterface.Displayable, int)
   */
  @Override
  public void displayAggregateApplicationsByJob(Displayable obj,
                                           int count)
  {
    System.out.println();
    System.out.println("Aggregate Applications by Job");
    System.out.print("Job     : ");
    displayItemLF(obj);
    System.out.println("Total = " + count);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#displayAggregateApplicationsByRecruiter(com.ladders.oc.dispinterface.Displayable, int)
   */
  @Override
  public void displayAggregateApplicationsByRecruiter(Displayable obj,
                                                      int count)
  {
    System.out.println();
    System.out.println("Aggregate Applications by Recruiter");
    System.out.print("Recruier: ");
    displayItemLF(obj);
    System.out.println("Total = " + count);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#reportByCSVStart()
   */
  @Override
  public void reportByCSVStart()
  {
    System.out.println();
    System.out.println("Applications Report by CSV");    
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#reportByCSVItem(com.ladders.oc.dispinterface.FieldDisplayable)
   */
  @Override
  public void reportByCSVItem(FieldDisplayable app)
  {
    ApplicationDisplayer appview = new CSVReport();
    app.displayInstance(appview);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#reportByCSVStart()
   */
  @Override
  public void reportByCSVEnd()
  {
    System.out.println("==============================");
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#reportByHtmlStart()
   */
  @Override
  public void reportByHtmlStart()
  {
    System.out.println();
    System.out.println("Applications Report by Html");    
    System.out.println("<html>");
    System.out.println("<body>");
    System.out.println("<table>");    
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#reportByHtmlItem(com.ladders.oc.dispinterface.FieldDisplayable)
   */
  @Override
  public void reportByHtmlItem(FieldDisplayable app)
  {
    ApplicationDisplayer appview = new HtmlReport();
    app.displayInstance(appview);
  }

  /* (non-Javadoc)
   * @see com.ladders.oc.view.ConsoleView#reportByHtmlEnd()
   */
  @Override
  public void reportByHtmlEnd()
  {
    System.out.println("</table>");
    System.out.println("</body>");
    System.out.println("</html>");
  }
  
}
