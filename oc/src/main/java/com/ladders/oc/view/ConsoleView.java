package com.ladders.oc.view;

import java.util.Date;

import com.ladders.oc.dispinterface.Displayable;
import com.ladders.oc.dispinterface.DisplayableCollection;
import com.ladders.oc.dispinterface.FieldDisplayable;

public interface ConsoleView
{

  void displayRecruiterJobs(Displayable obj,
                                   DisplayableCollection col);

  void displayAllJobsStart();
  void displayAllJobsItem(Displayable obj1,
                                 Displayable obj2);
  void displayAllJobsEnd();

  void displaySavedJobsStart(Displayable obj);
  void displaySavedJobsItem(Displayable obj);
  void displaySavedJobsEnd();

  void displayAppliedToJobsStart(Displayable obj);
  void displayAppliedToJobsItem(FieldDisplayable app);
  void displayAppliedToJobsEnd();

  void displayJobSeekersByDate(Displayable obj,
                                      Date date,
                                      DisplayableCollection col);
  void displayJobSeekersByJob(Displayable obj1,
                                     Displayable obj2,
                                     DisplayableCollection col);
  void displayJobSeekersByJobDate(Displayable obj1,
                                         Displayable obj2,
                                         Date date,
                                         DisplayableCollection col);

  void displayAggregateApplicationsByJob(Displayable obj,
                                                int count);

  void displayAggregateApplicationsByRecruiter(Displayable obj,
                                                      int count);

  void reportByCSVStart();
  void reportByCSVItem(FieldDisplayable app);
  void reportByCSVEnd();

  void reportByHtmlStart();
  void reportByHtmlItem(FieldDisplayable app);
  void reportByHtmlEnd();

}
