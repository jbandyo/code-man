package com.ladders.oc.resume;

import com.ladders.oc.jobseekers.*;

public class Resume
{
  private final Jobseeker jobSeeker;
  Resume(Jobseeker seeker)
  {
    jobSeeker = seeker;
  }
  
  public boolean OwnedBy(Jobseeker seeker)
  {
    return (seeker == jobSeeker);
  }
}
