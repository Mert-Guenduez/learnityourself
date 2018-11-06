package learnityourself.dhbw.learnityourself;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloWorld {

    public static void main(String[] args) throws IOException, JSONException {
        Socket socket = new Socket("91.205.172.109", 0);
        System.out.println("Connected to server");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),
                "UTF-8"));

        JSONObject jsonObject = new JSONObject(reader.readLine());

        System.out.println("Message from server: " + jsonObject.toString());

        socket.close();

    }
}
