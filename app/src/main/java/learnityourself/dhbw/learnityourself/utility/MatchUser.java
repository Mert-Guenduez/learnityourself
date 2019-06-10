package learnityourself.dhbw.learnityourself.utility;

import android.content.Context;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.controller.AuthorizedController;
import learnityourself.dhbw.learnityourself.model.User;

public class MatchUser extends AuthorizedController {

    public MatchUser(User user, Context context){
        super(user, context);
    }


    public User[] matchUser(String matchuser){
        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        InputStream in  = null;
        try {
            in = handler.execute("matchUser.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "matchuser", matchuser)
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(HTTPRequestHandler.getStringFromInputStream(in), User[].class);
    }

    @Override
    protected void init() {

    }
}
