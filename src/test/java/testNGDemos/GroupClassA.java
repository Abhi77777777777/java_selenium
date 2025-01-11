package testNGDemos;

import org.testng.annotations.Test;

public class GroupClassA {
    @Test(groups = "regression")
    public void firstTestA(){
        System.out.println("this is my first test in A");
    }

    @Test(groups = "smoke")
    public void secondTestA(){
        System.out.println("this is my second test in A");
    }
}
