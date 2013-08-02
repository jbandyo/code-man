package com.ladders.oc.jobs;

import com.ladders.oc.displayables.*;
import com.ladders.oc.displayers.JobTitleDisplayer;

/**
 * Creates a wrapper object for job title.
 */
public class JobTitle implements DisplayableJobTitle
{
  private final String title;
  
  /**
   * Constructor.
   * @param _title    a string that describes Job Title
   * @throws IllegalArgumentException if the input argument is null or of length zero
   */
  public JobTitle(String _title)
  {
    // validate
    if ((_title == null) || (_title.length() == 0))
      throw new IllegalArgumentException();
 
    // check for max length ???
    title = _title;
  }

  @Override
  public void displayInstance(JobTitleDisplayer titleDisplayer)
  {
    titleDisplayer.displayJobTitle(title);
    
  }

}
