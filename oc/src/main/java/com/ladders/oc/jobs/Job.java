package com.ladders.oc.jobs;

import java.util.UUID;
import com.ladders.oc.*;
import com.ladders.oc.display.View;
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
   */
  Job(JobTitle _title) throws IllegalArgumentException
  {
    // validate
    if (_title == null)
      throw new IllegalArgumentException();

    title = _title;
    // create a unique ID
    uId = UUID.randomUUID();
  }
  
  @Override
  public boolean equals(Object o)
  {
    if (o == this)
      return true;
    if (o.getClass() != this.getClass())
      return false;
    Job job = (Job) o;
    return job.uId == uId;
  }
  
  @Override
  public int hashCode()
  {
    return (int)(uId.getLeastSignificantBits());
  }
  
  // interface method implementation
  public String getDisplayText()
  {
    return title.getDisplayText();    
  }

}