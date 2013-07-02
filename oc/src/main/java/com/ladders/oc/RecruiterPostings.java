package com.ladders.oc;

import java.util.*;

import com.ladders.oc.jobs.*;

/**
 * Manages job postings by recruiters.
 */
class RecruiterPostings
{

  class RecPostTuple
  {
    Recruiter recruiter;
    JobPosting posting;
    
    public RecPostTuple(Recruiter _recruiter, JobPosting _posting)
    {
      recruiter = _recruiter;
      posting   = _posting;
    }
  }
  
  private List<RecPostTuple>  postingList = null;
  
  private RecruiterPostings() 
  {
    postingList = Collections.synchronizedList(new ArrayList<RecPostTuple>());  
  }

  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final RecruiterPostings singleton = new RecruiterPostings();
  }
  public static RecruiterPostings getInstance()
  {
    return SingletonHolder.singleton;
  }

  /**
   * Adds a job posting to repository.
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
    RecPostTuple rpost = new RecPostTuple(recruiter, posting);
    postingList.add(rpost);
  }
  
  public int getNumberOfPostings()
  {
    return postingList.size();
  }

  public void deleteAllPostings()
  {
    postingList.clear();
  }

  /**
   * Returns postings entered by a recruiter.
   * @param  recruiter  Recruiter instance
   * @return list of postings
   * @throws IllegalArgumentException
   */
  public List<JobPosting> listJobs(Recruiter recruiter) throws IllegalArgumentException
  {
    // validate
    if (recruiter == null)
      throw new IllegalArgumentException();

    List<JobPosting> jobList = new ArrayList<JobPosting>();
    synchronized (postingList)
    {
      Iterator<RecPostTuple> iterator = postingList.iterator();
      while (iterator.hasNext())
      {
        RecPostTuple tuple = iterator.next();
        if (tuple.recruiter == recruiter)
          jobList.add(tuple.posting);
      }
    }
    return jobList;
  }

  /**
   * Returns all postings.
   * @return list of postings
   */
  public List<JobPosting> listJobs()
  {
    List<JobPosting> jobList = new ArrayList<JobPosting>();
    synchronized (postingList)
    {
      Iterator<RecPostTuple> iterator = postingList.iterator();
      while (iterator.hasNext())
      {
          jobList.add(iterator.next().posting);
      }
    }
    return jobList;
  }
}
