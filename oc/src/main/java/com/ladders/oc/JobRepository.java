package com.ladders.oc;

import java.util.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.recruiters.*;

/**
 * Manages job postings by recruiters.
 * Note: This class is thread-safe;
 */
class JobRepository
{

  private List<PostedJob>  postedJobList = null;
  
  private JobRepository() 
  {
    postedJobList = Collections.synchronizedList(new ArrayList<PostedJob>());  
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

    // create posting with posting time
    Date now = new Date();
    JobPosting posting = new JobPosting(job, now);

    // add posting to repository
    PostedJob rpost = new PostedJob(recruiter, posting);
    postedJobList.add(rpost);
  }
  
  public int getNumberOfPostings()
  {
    return postedJobList.size();
  }

  public void deleteAllPostings()
  {
    postedJobList.clear();
  }

  /**
   * Returns postings entered by a recruiter.
   * @param  recruiter  Recruiter instance
   * @return list of postings
   * @throws IllegalArgumentException
   */
  public JobPostings listJobs(Recruiter recruiter) throws IllegalArgumentException
  {
    // validate
    if (recruiter == null)
      throw new IllegalArgumentException();

    JobPostings postings = new JobPostings();
    synchronized (postedJobList)
    {
      Iterator<PostedJob> iterator = postedJobList.iterator();
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
  public PostedJobs listJobs()
  {
    PostedJobs jobList = new PostedJobs();
    synchronized (postedJobList)
    {
      Iterator<PostedJob> iterator = postedJobList.iterator();
      while (iterator.hasNext())
        jobList.add(iterator.next());
    }
    return jobList;
  }
}
