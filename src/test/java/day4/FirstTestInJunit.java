package day4;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstTestInJunit {
    @BeforeEach
    public void setup()
    {
        System.out.println("this is my before method");
    }
    @BeforeAll
   public static void precondition()
    {
        System.out.println("pre condition");
    }
    @Test
    public void LoginTest()
    {
        System.out.println("Login Test Case");
    }

    @Test
    public void LogoutTest()
    {
        System.out.println("Lougut Test case");
    }



}
