package com.ladders.oc.jobs;

import com.ladders.oc.display.*;

/**
 * Creates a wrapper object for job title.
 */
public class JobTitle implements Displayable
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

  // interface method implementation
  public String getDisplayText()
  {
    return title;    
  }

}
