package com.ladders.oc.application;

import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;
import com.ladders.oc.resume.*;

/**
 * Handles job application requests.
 */
public class ApplicationProcessor
{
  /**
   * Creates a job application after verifying the inputs 
   * @param   seeker     JobSeeker object
   * @param   job        PostedJob object
   * @param   recruiter  Recruiter object
   * @param   resume     Resume belonging to JobSeeker (can be null if job does not need it)
   */
  public static void applyToJob(JobSeeker seeker, Job job, Recruiter recruiter, Resume resume)
  {
    if ((seeker == null) || (job == null) || (recruiter==null))
      throw new IllegalArgumentException();
    
    if (job.RequiresResume())
    {
      if (resume == null)
        throw new IllegalArgumentException();
      if (!resume.OwnedBy(seeker))
        throw new IllegalArgumentException();
    }

    Application app = new Application(job, recruiter, seeker);
    ApplicationRepository repo = ApplicationRepository.getInstance();
    repo.addApplication(app);
  }

}
