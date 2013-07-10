package com.ladders.oc.resume;

import com.ladders.oc.jobseekers.*;

public class Resume
{
  private final JobSeeker jobSeeker;
  Resume(JobSeeker seeker)
  {
    jobSeeker = seeker;
  }
  
  public boolean OwnedBy(JobSeeker seeker)
  {
    return (seeker == jobSeeker);
  }
}
