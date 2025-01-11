package testNGDemos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassB {

    @BeforeClass
    public void beforeClassB(){
        System.out.println("This is my before class in B");
        System.out.println("1b");
    }
    @Test
    public void FirsttestB(){
        System.out.println("This is my first test in BT");
    }
    @Test
    public void SecondtestB(){
        System.out.println("This is my second test in BT");
    }
    @AfterClass
    public void afterClassB(){
        System.out.println("This is my after class in B");
    }



}
