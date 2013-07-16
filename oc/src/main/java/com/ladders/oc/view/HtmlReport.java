package com.ladders.oc.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ladders.oc.dispinterface.ApplicationDisplayer;
import com.ladders.oc.jobs.Job;
import com.ladders.oc.jobseekers.JobSeeker;
import com.ladders.oc.recruiters.Recruiter;

public class HtmlReport implements ApplicationDisplayer
{

  @Override
  public void displayApplicationFields(Job job,
                                       Recruiter recruiter,
                                       JobSeeker seeker,
                                       Date date)
  {
    System.out.println("<tr>");
    System.out.print("  <td>");
    System.out.print(job.getDisplayText());
    System.out.println("  </td>");
    System.out.print("  <td>");
    System.out.print(recruiter.getDisplayText());
    System.out.println("  </td>");
    System.out.print("  <td>");
    System.out.print(seeker.getDisplayText());
    System.out.println("  </td>");
    System.out.print("  <td>");
    SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yy");
    System.out.print(sdf.format(date));
    System.out.println("  </td>");
    System.out.println("</tr>");
  }

}
