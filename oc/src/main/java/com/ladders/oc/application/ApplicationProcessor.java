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
   * @throws  IllegalArgumentException if resume required but not provided or resume is not owned
   */
  public static void applyToJob(Jobseeker seeker, Job job, Recruiter recruiter, Resume resume)
  {
    if (job.RequiresResume())
    {
      if (resume == null)
        throw new IllegalArgumentException("Resume is required for this job");
      if (!resume.ownedBy(seeker))
        throw new IllegalArgumentException("The Resume is not owned by Jobseeker");
    }

    Application app = new Application(job, recruiter, seeker);
    ApplicationRepository repo = ApplicationRepository.getInstance();
    repo.addApplication(app);
  }

}
