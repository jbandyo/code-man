package com.ladders.oc.jobs;

import java.util.*;
import com.ladders.oc.display.Displayable;

/**
 * Abstract base class for all job types.
 */
public abstract class Job implements Displayable
{
  protected final UUID uId;
  protected final JobTitle title;
  
  /**
   * Base class constructor 
   * @param _title    a JobTitle object
   * @throws IllegalArgumentException if title is null
   */
  Job(JobTitle _title) 
  {
    // validate
    if (_title == null)
      throw new IllegalArgumentException();

    title = _title;
    // create a unique ID
    uId = UUID.randomUUID();
  }

  public abstract boolean RequiresResume();

  @Override
  public boolean equals(Object o)
  {
    if (o == this)
      return true;
    if (o == null)
      return false;
    if (o.getClass() != this.getClass())
      return false;
    Job job = (Job) o;
    return job.uId.equals(uId);
  }
  
  @Override
  public int hashCode()
  {
    return (int)(uId.hashCode());
  }
  
  // interface method implementation
  public String getDisplayText()
  {
    return title.getDisplayText();    
  }

}