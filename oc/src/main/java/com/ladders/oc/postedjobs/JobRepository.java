package com.ladders.oc.postedjobs;

import java.util.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.recruiters.*;

/**
 * Manages job postings by recruiters.
 * Note: This class is thread-safe;
 */
public class JobRepository
{
  // Note: if more fields are added toa posted job, follow the similar data structure as Application. 
  private final Map<Job,Recruiter> postedJobs;
  
  private JobRepository() 
  {
    postedJobs = Collections.synchronizedMap(new HashMap<Job,Recruiter>());  
  }

  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final JobRepository singleton = new JobRepository();
  }
  public static JobRepository getInstance()
  {
    return SingletonHolder.singleton;
  }

  /**
   * Adds a job posting along with recruiter reference to repository.
   * @param recruiter  Recruiter instance
   * @param job        Job instance
   * @return true if the job was not posted before
   */
  public boolean postJob(Recruiter recruiter,
                      Job job)
  {
    // add posting to repository
    if (postedJobs.containsKey(job))
      return false;
    
    postedJobs.put(job, recruiter);
    return true;
  }
  
  public int getNumberOfPostings()
  {
    return postedJobs.size();
  }

  public void deleteAllPostings()
  {
    postedJobs.clear();
  }

  /**
   * Returns postings entered by a recruiter.
   * @param  recruiter  Recruiter instance
   * @return list of job postings
   */
  public Jobs jobsPostedBy(Recruiter recruiter)
  {
    Jobs postings = new Jobs();
    synchronized (postedJobs)
    {
      for (Map.Entry<Job, Recruiter> entry : postedJobs.entrySet())
      {
        if (entry.getValue() == recruiter)
          postings.add(entry.getKey());
      }
    }
    return postings;
  }

  /**
   * Returns all posted jobs.
   * @return list of postings
   */
  public Jobs allPostedJobs()
  {
    Jobs postings = new Jobs();
    synchronized (postedJobs)
    {
      for (Map.Entry<Job, Recruiter> entry : postedJobs.entrySet())
      {
          postings.add(entry.getKey());
      }
    }
    return postings;
  }

  /**
   * Returns recruiter who posted a given job.
   * @param  job  Job instance
   * @return recruiter instance
   */
  public Recruiter getRecruiterByJob(Job job)
  {
    return postedJobs.get(job);
  }
}
