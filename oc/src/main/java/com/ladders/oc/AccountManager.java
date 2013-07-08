package com.ladders.oc;

public class AccountManager
{
  // singleton pattern implementation
  private static final class SingletonHolder 
  {
    static final AccountManager singleton = new AccountManager();
  }
  public static AccountManager getInstance()
  {
    return SingletonHolder.singleton;
  }

}
