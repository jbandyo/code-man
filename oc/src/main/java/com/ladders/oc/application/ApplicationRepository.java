package com.ladders.oc.application;

import java.util.*;

import com.ladders.oc.application.ApplicationRepository.Filter;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

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
  public boolean addApplication(Application app)
  {
    if (app == null)
      throw new IllegalArgumentException();
    return appSet.add(app);
  }

  public int getNumberOfApplications()
  {
    return appSet.size();
  }

  public void deleteAllApplications()
  {
    appSet.clear();
  }

  public void getApplications(Filter filter)
  {
    Applications apps = new Applications();
    synchronized (appSet)
    {
      Iterator<Application> iterator = appSet.iterator();
      while (iterator.hasNext())
      {
        Application app = iterator.next();
        if ((filter.job != null) && (!app.containsJob(filter.job)))
          continue;
        if ((filter.recruiter != null) && (!app.containsRecruiter(filter.recruiter)))
          continue;
        if ((filter.seeker != null) && (!app.containsJobSeeker(filter.seeker)))
          continue;
        if ((filter.job != null) && (!app.containsJob(filter.job)))
          continue;
      }
    }

    
  }

  public Filter createFilter()
  {
    return new Filter();
  }
  
  public class Filter
  {
    Job job = null;
    Recruiter recruiter = null;
    JobSeeker seeker = null;
    Date date = null;
    
    private Filter() 
    {      
    }
    
    public Filter setJob(Job _job)
    {
      job = _job;
      return this;
    }

    public Filter setRecruiter(Recruiter _recruiter)
    {
      recruiter = _recruiter;
      return this;
    }

    public Filter setJobSeeker(JobSeeker _seeker)
    {
      seeker = _seeker;
      return this;
    }
    
    public Filter setDate(Date _date)
    {
      date = _date;
      return null;
    }
  }
 
}
