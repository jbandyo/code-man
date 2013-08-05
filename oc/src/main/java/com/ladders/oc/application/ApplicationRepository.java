package com.ladders.oc.application;

import java.util.*;

import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

/**
 * Maintains job application data.
 * Note: This class is thread-safe.
 */
public class ApplicationRepository
{
  private final Set<Application> appSet;

  private ApplicationRepository()
  {
    appSet = Collections.synchronizedSet(new HashSet<Application>());  
  }
  
  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final ApplicationRepository singleton = new ApplicationRepository();
  }
  public static ApplicationRepository getInstance()
  {
    return SingletonHolder.singleton;
  }

  /**
   * Adds an application to repository
   * @param  app    a valid application
   * @return true if the application was not added before
   */
  boolean addApplication(Application app)
  {
    assert (app != null);

    return appSet.add(app);
  }

  int getNumberOfApplications()
  {
    return appSet.size();
  }

  void deleteAllApplications()
  {
    appSet.clear();
  }

  public Applications getAllApplications()
  {
    Filter filter = createFilter(null, null, null, null);
    return getApplications(filter);
  }

  public Applications getApplications(Filter filter)
  {
    Applications apps = new Applications();
    synchronized (appSet)
    {
      Iterator<Application> iterator = appSet.iterator();
      while (iterator.hasNext())
      {
        Application app = iterator.next();
        if (!filter.pass(app))
          continue;
        apps.add(app);
      }
      return apps;
    }
  }

  public Filter createFilter(Job _job, Recruiter _recruiter, Jobseeker _seeker, Date _date)
  {
    return new Filter(_job, _recruiter, _seeker, _date);
  }
  
  public class Filter
  {
    final Job job;
    final Recruiter recruiter;
    final Jobseeker seeker;
    final Date date;
    
    private Filter(Job _job, Recruiter _recruiter, Jobseeker _seeker, Date _date) 
    {      
      job = _job;
      recruiter = _recruiter;
      seeker = _seeker;
      date = _date;
    }
    
    boolean pass(Application app)
    {
      if ((job != null) && (!app.containsJob(job)))
        return false;
      if ((recruiter != null) && (!app.containsRecruiter(recruiter)))
        return false;
      if ((seeker != null) && (!app.containsJobSeeker(seeker)))
        return false;;
      if ((job != null) && (!app.containsJob(job)))
        return false;
      return true;
    }
  }
 
}
