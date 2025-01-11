package testNGDemos;

import org.testng.annotations.*;

public class ClassA {
    @BeforeSuite
    public void beforesuitA(){
        System.out.println("This is my before suite in class A");
        System.out.println("1");
    }
    @BeforeTest
    public void beforetestA(){
        System.out.println("This is my before test in class A33333333");
    }
    @BeforeClass
    public void beforeClassA(){
        System.out.println("This is my before class in A");
        System.out.println("22");
    }
    @Test
    public void FirsttestA(){
        System.out.println("This is my first test in AT");
    }
    @Test
    public void SecondtestA(){
        System.out.println("This is my second test in AT");
    }
    @AfterClass
    public void afterClassA(){
        System.out.println("This is my after class in AT");
    }
}
