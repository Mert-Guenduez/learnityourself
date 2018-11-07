package learnityourself.dhbw.learnityourself;

import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HelloWorld extends AppCompatActivity {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://91.205.172.109/index.php/?hello=true");
        System.out.println(url.getContent());

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String decodedString;
        while ((decodedString = in.readLine()) != null) {
            System.out.println(decodedString);
        }
        in.close();

    }
}
