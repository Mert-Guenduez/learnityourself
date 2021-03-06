package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.LoginActivity;
import learnityourself.dhbw.learnityourself.OptionsActivity;
import learnityourself.dhbw.learnityourself.ViewAchievementsActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.ViewRewardsActivity;
import learnityourself.dhbw.learnityourself.model.CompletedTaskInformation;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.SSLHandler;

public class MainController {

    private User user;
    private Context context;
    private CompletedTaskInformation[] completedTaskInformation;

    public MainController(User user, Context context){
        this.user = user;

        this.context = context;
        setSSL();
        if(checkAuthorized());

    }


    private void setSSL(){

        SSLHandler sslHandler = null;
        try {
            sslHandler= new SSLHandler(context.getApplicationContext());
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean checkAuthorized() {


        /* TODO
        If user ==null try reading from file
        if(user==null){
            read from file;
        }

        */
        if(user==null){
            Intent intent = new Intent(context, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
            return false;

        }else{
            HTTPRequestHandler handler = new HTTPRequestHandler();
            handler.setContext(context);
            InputStream in  = null;
            try {
                in = handler.execute("login.php","username", user.getUsername(),"sessionkey",user.getSessionkey()).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String inputString=HTTPRequestHandler.getStringFromInputStream(in);

            if(inputString.contains("true")) {
                return true;
            }else{
                context.startActivity(new Intent(context, LoginActivity.class));
                return false;
            }
        }

    }

    public void viewRewards() {
        Intent intent = new Intent(context, ViewRewardsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    public void viewMissions() {
        Intent intent = new Intent(context, ViewMissionsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    public User getUser() {
        return user;
    }

    public void keyBackHandler(){
    }

    public void logout() {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        try {
            handler.execute("logout.php","username", user.getUsername(),"sessionkey",user.getSessionkey()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    public void fetchUserPoints() {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        InputStream in  = null;
        try {
            in = handler.execute("getUserPoints.php","username", user.getUsername(),"sessionkey",user.getSessionkey()).get();
            JSONObject object = new JSONObject(HTTPRequestHandler.getStringFromInputStream(in));
            user.setPoints(object.getInt("user_points"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> fetchCompletedTaskDates() {
        Map<String, Integer> completedTaskFromUserMap = new HashMap<>();

        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        InputStream in  = null;
        try {
            in = handler.execute("allCompletedTasksFromUser.php","username", user.getUsername(),
                    "sessionkey",user.getSessionkey()).get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        completedTaskInformation = new Gson().fromJson(HTTPRequestHandler.getStringFromInputStream(in), CompletedTaskInformation[].class);

        for (int i = 0; i < completedTaskInformation.length; i++) {
            CompletedTaskInformation completedTask = completedTaskInformation[i];
            completedTaskFromUserMap.put(completedTask.getCompletedDate(), completedTask.getCount());
        }

        return completedTaskFromUserMap;
    }

    public void openOptions() {
        Intent intent = new Intent(context, OptionsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    public void viewAchiements() {
        Intent intent = new Intent(context, ViewAchievementsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
