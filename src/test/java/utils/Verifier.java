package utils;

public class Verifier {

    public static void equals (int num1, int num2){
        if (num1 != num2){
            throw new RuntimeException("Expecting " + num1 + " but showing " + num2);
        }
    }
}
