package com.ladders.oc;

import java.util.UUID;

public class Recruiter
{
  UUID uId;
  Name name;

  /**
   * Constructs a Recruiter.
   * @param _name    a Name object
   */
  public Recruiter(Name _name) throws IllegalArgumentException
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
    if (!(o instanceof Recruiter))
      return false;
    Recruiter rec = (Recruiter) o;
    return rec.uId == uId;
  }
  
  @Override
  public int hashCode()
  {
    return (int)(uId.getLeastSignificantBits());
  }

}
