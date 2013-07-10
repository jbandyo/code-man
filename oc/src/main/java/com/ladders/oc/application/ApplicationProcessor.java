package com.ladders.oc.application;

import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;
import com.ladders.oc.resume.*;

public class ApplicationProcessor
{

  /**
   * Creates a job application after verifying the inputs 
   * @param   seeker     JobSeeker object
   * @param   job        PostedJob object
   * @param   resume     Resume belonging to JobSeeker (can be null if job does not need it)
   */
  public static void applyToJob(JobSeeker seeker, PostedJob postedJob, Resume resume)
  {
    if ((seeker == null) || (postedJob == null))
      throw new IllegalArgumentException();
    
    Job job = postedJob.getPosting();
    if (job.RequiresResume())
    {
      if (resume == null)
        throw new IllegalArgumentException();
      if (!resume.OwnedBy(seeker))
        throw new IllegalArgumentException();
    }

    Application app = new Application(job, postedJob.getRecruiter(), seeker);
    ApplicationRepository repo = ApplicationRepository.getInstance();
    repo.addApplication(app);
  }

}
