package testNGDemos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTestInTestNG {
    @BeforeClass
    public void beforeClassDemo()
    {
        System.out.println("this is my before method");
    }
    @Test
    public void firstTest()
    {
        System.out.println("this is my first test method");

    }
    @AfterMethod
    public void afterMethodDemo()
    {
        System.out.println("this is my method");
    }
    @AfterClass
    public void afterClassDemo()
    {
        System.out.println("this is my after class");
    }

}
