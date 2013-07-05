package com.ladders.oc.recruiters;

import com.ladders.oc.*;

/**
 * Represents a single posted job consisting of recruiter and the posting details.
 */
public class PostedJob
{

  private Pair<Recruiter, JobPosting> rpPair;
  
  public Recruiter getRecruiter()
  {
    return rpPair.first;
  }
  
  public JobPosting getPosting()
  {
    return rpPair.second;
  }

  public PostedJob(Recruiter recruiter,
                   JobPosting posting)
  {
    rpPair = new Pair(recruiter, posting);
  }
  
}
