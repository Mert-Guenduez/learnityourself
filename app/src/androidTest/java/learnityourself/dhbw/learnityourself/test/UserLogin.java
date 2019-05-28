package learnityourself.dhbw.learnityourself.test;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class UserLogin {
    private final String USERNAME = "testuser1";
    private final String PASSWORD = "12345";

    public User loginUser() throws Exception {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/login.php","username",
                    USERNAME,"password",PASSWORD).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String inputString=HTTPRequestHandler.getStringFromInputStream(in);

        if(inputString.contains("false")){
            throw new Exception("User can't be logged in");
        } else {
            Gson gson= new Gson();
            User user = gson.fromJson(inputString, User.class);

            return user;
        }
    }
}
