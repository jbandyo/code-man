package com.ladders.oc.jobseekers;

import java.util.UUID;

import com.ladders.oc.Name;
import com.ladders.oc.displayables.DisplayableJobseeker;
import com.ladders.oc.displayers.JobseekerDisplayer;

/**
 * Represents a Job Seeker.
 */
public class Jobseeker implements DisplayableJobseeker
{
  private final UUID uId;
  private final Name name;

  /**
   * Constructor.
   * @param _name    a Name object
   */
  public Jobseeker(Name _name) throws IllegalArgumentException
  {
    if (_name == null)
      throw new IllegalArgumentException();
    
    name = _name;
    // create a unique ID
    uId = UUID.randomUUID();
  }

  @Override
  public boolean equals(Object o)
  {
    if (o == this)
      return true;
    if (!(o instanceof Jobseeker))
      return false;
    Jobseeker user = (Jobseeker) o;
    return user.uId.equals(uId);
  }
  
  @Override
  public int hashCode()
  {
    return (int)(uId.hashCode());
  }

  // interface method implementation
  @Override
  public void displayInstance(JobseekerDisplayer displayer)
  {
    displayer.displayJobseeker(name);
    
  }

}
