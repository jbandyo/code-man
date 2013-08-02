package com.ladders.oc.resume;

import com.ladders.oc.jobseekers.*;

public class ResumeCreator
{
  public static Resume createResume(Jobseeker seeker)
  {
    return new Resume(seeker);
  }
}
