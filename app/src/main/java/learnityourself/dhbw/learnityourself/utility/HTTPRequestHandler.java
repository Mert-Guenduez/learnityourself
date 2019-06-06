package learnityourself.dhbw.learnityourself.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class HTTPRequestHandler extends AsyncTask<String, Integer, InputStream> {

    private final String DEFAULT_HOST ="https://91.205.173.109/";
    private Context context;

    public void setContext(Context c){
        this.context = c;
    }

    @Override
    protected InputStream doInBackground(String... inUrl) {
        URL url = null;
        try {
            url = new URL(getHost()+inUrl[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Map<String,Object> params = new LinkedHashMap<>();
        for(int i=1; i<inUrl.length; i+=2){
            params.put(inUrl[i], inUrl[i+1]);
        }
        byte[] postDataBytes = getPostDataFromMap(params);

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setConnectTimeout(1000);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        try {
            conn.getOutputStream().write(postDataBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Reader in = null;

        try {
            return conn.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getHost() {
        SharedPreferences settings = context.getSharedPreferences("LearnItYourself", 0);
        String host = settings.getString("host", null);

        if(host==null || host.isEmpty()){
            return DEFAULT_HOST;
        }else{
            return host;
        }
    }

    private byte[] getPostDataFromMap(Map<String, Object> params) {
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            buildPostData(param, postData);
        }
        byte[] postDataBytes = new byte[0];
        try {
            postDataBytes = postData.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return postDataBytes;
    }

    private void buildPostData(Map.Entry<String, Object> param, StringBuilder postData) {
        if (postData.length() != 0) postData.append('&');
        try {
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        postData.append('=');
        try {
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return;
    }

    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }


}

