package test.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Verifier;

public class TestNgOrder {

    // Default: method is run one by one in the alphabetical order by method name when setting @Test()

    // Should not run by priority. Only use it for demoing
    /*
    @Test(priority = 1)
    public void testB(){
        System.out.println("TestB");
    }

    @Test(priority = 2)
    public void testA(){
        System.out.println("TestA");
    }

     */


    @Test(dependsOnMethods = {"testB"})
    public void testA(){
        System.out.println("TestA");
    }
    @Test()
    public void testB(){
        System.out.println("TestB");
        //throw new IllegalArgumentException("Erro: ..............");

        // Verifier.equals(1,2);

        /**
         *  Hard assertion: whenever one row Assert failed, other beneath rows will not be executed
         */
        //Assert.assertEquals(1,2);
        //Assert.assertEquals(3,4,"[ERR] failed from Assert");
        //Assert.assertTrue(false, "Expecting true but.....!");
        //Assert.assertFalse(true, "Not meet expectation!");

        /**
         *  Soft assertion: continuing to do asserting while there are failed tests
         *  Need to be declared
         */
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1,2);
        softAssert.assertEquals(3,4,"[ERR] failed from Assert");
        softAssert.assertTrue(false, "Expecting true but.....!");
        softAssert.assertAll(); // print out the log for failed tests from this line of code upwards
        softAssert.assertFalse(true, "Not meet expectation!");
    }





}
