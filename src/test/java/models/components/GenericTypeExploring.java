package models.components;

import java.lang.reflect.Constructor;

public class GenericTypeExploring {

    public <Teo extends LoginPage> void login (Class<Teo> loginPageClass){
        Class<?>[] parameter = new Class[]{};

        try {
            Constructor<Teo> constructor = loginPageClass.getConstructor(parameter);
            Teo loginPageObj = constructor.newInstance();
            loginPageObj.login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GenericTypeExploring().login(InternalLoginPage.class);
        new GenericTypeExploring().login(ExternalLoginPage.class);

    }
}
