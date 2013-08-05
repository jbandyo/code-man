package com.ladders.oc.application;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ladders.oc.Name;
import com.ladders.oc.jobs.*;
import com.ladders.oc.jobseekers.*;
import com.ladders.oc.recruiters.*;

public class ApplicationsTest
{
  static Recruiter recruiter1 = null;
  static Recruiter recruiter2 = null;
  static Jobseeker seeker1 = null;
  static Jobseeker seeker2 = null;
  static Job job1 = null;
  static Job job2 = null;
  static Application app1 = null;
  static Application app2 = null;
  static Application app3 = null;
  static Applications apps = null;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    apps = new Applications();
    recruiter1 = new Recruiter(new Name("John"));
    recruiter2 = new Recruiter(new Name("Henry"));
    seeker1 = new Jobseeker(new Name("David"));
    seeker2 = new Jobseeker(new Name("Adam"));
    job1 = JobFactory.createATSJob(new JobTitle("Developer"));
    job2 = JobFactory.createATSJob(new JobTitle("Architect"));
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {}

  @Before
  public void setUp() throws Exception
  {}

  @After
  public void tearDown() throws Exception
  {
    apps.deleteAll();
  }

  @Test
  public void testConstructor()
  {
    assertNotNull("Applications constructor must create the object", apps);
    assertEquals("Newly constructed Applications instance should have zero size", apps.getCount(), 0);
  }

  @Test
  public void testAdd()
  {
    assertEquals("Application count should be zero before test", apps.getCount(), 0);
    app1 = new Application(job1, recruiter1, seeker1);
    apps.add(app1);
    assertEquals("Application count should go up by one after add", apps.getCount(), 1);
    apps.deleteAll();
    assertEquals("Application count should be zero after deleteAll", apps.getCount(), 0);
  }

  @Test
  public void testIterator()
  {
    Iterator<Application> iterator = apps.getIterator();
    assertFalse("Iterator should have zero items in an empty set", iterator.hasNext());      
    app1 = new Application(job1, recruiter1, seeker1);
    apps.add(app1);
    app2 = new Application(job2, recruiter1, seeker2);
    apps.add(app2);
    app3 = new Application(job2, recruiter1, seeker1);
    apps.add(app3);
    iterator = apps.getIterator();
    Set<Application> appset = new HashSet<Application>();
    appset.add(app1);
    appset.add(app2);
    appset.add(app3);
    assertTrue("Iterator should iterate through all items", appset.contains(iterator.next()));
    assertTrue("Iterator should iterate through all items", appset.contains(iterator.next()));
    assertTrue("Iterator should iterate through all items", appset.contains(iterator.next()));      
    assertFalse("Iterator should return same number of items as inserted", iterator.hasNext());      
  }

}
