package com.ladders.oc.resume;

import com.ladders.oc.jobseekers.*;

public class ResumeCreator
{
  public static Resume createResume(JobSeeker seeker)
  {
    return new Resume(seeker);
  }
}
