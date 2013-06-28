package com.ladders.oc.jobs;

public class JobTitle
{
  private String title;
  
  /**
   * Constructs a wrapper object for Job Title
   * @param _title    a string that describes Job Title
   * @throws IllegalArgumentException if the input argument is null or of length zero
   */
  public JobTitle(String _title) throws IllegalArgumentException
  {
    // validate
    if ((_title == null) || (_title.length() == 0))
      throw new IllegalArgumentException();
    // check for max length ???
    title = _title;
  }

}
