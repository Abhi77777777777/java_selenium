package testNGDemos;

import org.testng.annotations.Test;

public class GroupClassB {
    @Test(groups = "smoke")
    public void firstTestB(){
        System.out.println("this is my first test in B");
    }

    @Test(groups = "smoke")
    public void secondTestB(){
        System.out.println("this is my second test in B");
    }

}
