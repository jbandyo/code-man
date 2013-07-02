package com.ladders.oc;

import java.util.*;
import com.ladders.oc.jobs.*;

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
  
  private static final class SingletonHolder 
  {
    static final RecruiterPostings singleton = new RecruiterPostings();
  }

  private RecruiterPostings() 
  {
    postingList = Collections.synchronizedList(new ArrayList<RecPostTuple>());  
  }

  public static RecruiterPostings getInstance()
  {
    return SingletonHolder.singleton;
  }

  public void postJob(Recruiter recruiter,
                      Job job) throws IllegalArgumentException
  {
    if ((recruiter == null) || (job == null))
      throw new IllegalArgumentException();

    Date now = new Date();
    JobPosting posting = new JobPosting(job, now);

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

  public List<JobPosting> listJobs(Recruiter recruiter)
  {
    List<JobPosting> jobList = new ArrayList<JobPosting>();
    synchronized(postingList)
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

}
