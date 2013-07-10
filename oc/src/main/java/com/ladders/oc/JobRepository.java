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

  private final Set<PostedJob> postedJobSet;
  
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
   * @return true if the job was not posted before
   * @throws IllegalArgumentException
   */
  public boolean postJob(Recruiter recruiter,
                      Job job)
  {
    // validate
    if ((recruiter == null) || (job == null))
      throw new IllegalArgumentException();

    // add posting to repository
    PostedJob post = new PostedJob(recruiter, job);
    return postedJobSet.add(post);
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
  public Jobs getRecruiterJobs(Recruiter recruiter)
  {
    // validate
    if (recruiter == null)
      throw new IllegalArgumentException();

    Jobs postings = new Jobs();
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
  public PostedJobs getPostedJobs()
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
