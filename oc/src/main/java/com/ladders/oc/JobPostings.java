package com.ladders.oc;

import java.util.ArrayList;
import java.util.List;
import com.ladders.oc.display.*;

/**
 * Wrapper class for a list of job postings.
 * Note: Not Threadsafe.
 */
public class JobPostings implements DisplayableCollection
{
  List<JobPosting> jobList = new ArrayList<JobPosting>();

  public Object getCount()
  {
    return jobList.size();
  }

  public void add(JobPosting posting) throws IllegalArgumentException
  {
    // validate
    if (posting == null)
      throw new IllegalArgumentException();
    
    jobList.add(posting);   
  }

  public void deleteAll()
  {
    jobList.clear();
  }

  // interface method implementation
  public List<String> getDisplayTextList()
  {
    List<String> texts = new ArrayList<String>();
    for (JobPosting posting : jobList)
    {
      texts.add(posting.getDisplayText());
    }
    return texts;
  }

}
