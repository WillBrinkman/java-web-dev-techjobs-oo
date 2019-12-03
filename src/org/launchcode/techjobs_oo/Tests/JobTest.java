package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;

    @Before
public void createJobObjects(){
    test_job1 =  new Job();
    test_job2 = new Job();
    test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    test_job5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    }

    @Test
    public void testSettingJobId(){
        assertTrue(test_job1.getId()!=test_job2.getId() && test_job2.getId() == test_job1.getId() + 1);
    }

    @Test
    public  void testJobConstructorSetsAllFields(){
    assertTrue(test_job3.getName() instanceof String);
    assertTrue(test_job3.getEmployer() instanceof Employer);
    assertTrue(test_job3.getLocation() instanceof Location);
    assertTrue(test_job3.getPositionType() instanceof PositionType);
    assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job test_job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    public void testToStringForBlankLines(){
        String testStr = test_job3.toString();
        Integer blankLine = "\n".length();
        assertTrue(testStr.substring(0, blankLine).contains("\n") && testStr.substring(testStr.length()-blankLine).contains("\n"));
    }

    @Test
    public void testToStringForLabelAndData(){
        assertTrue(test_job3.toString().contains("ID: " + test_job3.getId()));
        assertTrue(test_job3.toString().contains("Name: " + test_job3.getName()));
        assertTrue(test_job3.toString().contains("Employer: " + test_job3.getEmployer()));
        assertTrue(test_job3.toString().contains("Location: " + test_job3.getLocation()));
        assertTrue(test_job3.toString().contains("Position Type: " + test_job3.getPositionType()));
        assertTrue(test_job3.toString().contains("Core Competency: " + test_job3.getCoreCompetency()));
    }

    @Test
    public void testToStringForNoData(){
        assertTrue(test_job5.toString().contains("Name: Data not available"));
        assertTrue(test_job5.toString().contains("Employer: Data not available"));
        assertTrue(test_job5.toString().contains("Location: Data not available"));
        assertTrue(test_job5.toString().contains("Position Type: Data not available"));
        assertTrue(test_job5.toString().contains("Core Competency: Data not available"));

    }

}
