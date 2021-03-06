package com.ladders.oc.recruiters;

import com.ladders.oc.*;
import com.ladders.oc.jobs.*;
import com.ladders.oc.display.Displayable;

/**
 * Represents a single posted job consisting of recruiter and the posting details.
 */
public class PostedJob
{
  private Pair<Recruiter, Job> rjPair;
  
  public Recruiter getRecruiter()
  {
    return rjPair.first;
  }
  
  public Job getPosting()
  {
    return rjPair.second;
  }

  public PostedJob(Recruiter recruiter,
                   Job job)
  {
    rjPair = new Pair(recruiter, job);
  }

  @Override
  public boolean equals(Object o)
  {
    if (o == this)
      return true;
    if (!(o instanceof PostedJob))
      return false;
    PostedJob job = (PostedJob) o;
    return (job.rjPair.second.equals(rjPair.second));   // compare only job part
  }

  @Override
  public int hashCode()
  {
    return rjPair.second.hashCode();
  }
  
}
