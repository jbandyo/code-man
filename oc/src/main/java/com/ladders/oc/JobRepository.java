package com.ladders.oc;

import java.util.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.recruiters.*;

/**
 * Manages job postings by recruiters.
 * Note: This class is thread-safe;
 */
public class JobRepository
{

  private Set<PostedJob> postedJobSet = null;
  
  private JobRepository() 
  {
    postedJobSet = Collections.synchronizedSet(new HashSet<PostedJob>());  
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
   * @throws IllegalArgumentException
   */
  public void postJob(Recruiter recruiter,
                      Job job) throws IllegalArgumentException
  {
    // validate
    if ((recruiter == null) || (job == null))
      throw new IllegalArgumentException();

    // add posting to repository
    PostedJob post = new PostedJob(recruiter, job);
    if (!postedJobSet.add(post))
      throw new IllegalArgumentException();      
  }
  
  public int getNumberOfPostings()
  {
    return postedJobSet.size();
  }

  public void deleteAllPostings()
  {
    postedJobSet.clear();
  }

  /**
   * Returns postings entered by a recruiter.
   * @param  recruiter  Recruiter instance
   * @return list of job postings
   * @throws IllegalArgumentException
   */
  public JobPostings getJobs(Recruiter recruiter) throws IllegalArgumentException
  {
    // validate
    if (recruiter == null)
      throw new IllegalArgumentException();

    JobPostings postings = new JobPostings();
    synchronized (postedJobSet)
    {
      Iterator<PostedJob> iterator = postedJobSet.iterator();
      while (iterator.hasNext())
      {
        PostedJob pair = iterator.next();
        if (pair.getRecruiter() == recruiter)
          postings.add(pair.getPosting());
      }
    }
    return postings;
  }

  /**
   * Returns all posted jobs.
   * @return list of postings
   */
  public PostedJobs getJobs()
  {
    PostedJobs jobList = new PostedJobs();
    synchronized (postedJobSet)
    {
      Iterator<PostedJob> iterator = postedJobSet.iterator();
      while (iterator.hasNext())
        jobList.add(iterator.next());
    }
    return jobList;
  }
}
