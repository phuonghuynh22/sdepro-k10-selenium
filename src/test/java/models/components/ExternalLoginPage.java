package models.components;

public class ExternalLoginPage extends LoginPage {
//    @Override
//    public String inputUsername(String username) {
//        System.out.println("Input username with External Login Page");
//        return null;
//    }
//
//    @Override
//    public String inputPassword(String password) {
//        System.out.println("Input password with External Login Page");
//        return null;
//    }
//
//    @Override
//    public String clickOnLoginBtn() {
//        System.out.println("Input password with External Login Page");
//        return null;
//    }

    @Override
    protected String username() {
        //System.out.println("Input username with External Login Page");
        return "Input username with External Login Page";
    }

    @Override
    protected String password() {
        //System.out.println("Input password with External Login Page");

        return "Input password with External Login Page";
    }

    @Override
    protected String loginBtn() {
        //System.out.println("Click on Login Btn with External Login Page);

        return "Click on Login Btn with External Login Page";
    }
}
