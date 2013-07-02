package com.ladders.oc;

import java.util.UUID;

/**
 * Represents a Job Seeker.
 */
public class JobSeeker
{
  UUID uId;
  Name name;

  /**
   * Constructor.
   * @param _name    a Name object
   */
  public JobSeeker(Name _name) throws IllegalArgumentException
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
    if (!(o instanceof JobSeeker))
      return false;
    JobSeeker user = (JobSeeker) o;
    return user.uId == uId;
  }
  
  @Override
  public int hashCode()
  {
    return (int)(uId.getLeastSignificantBits());
  }

}
