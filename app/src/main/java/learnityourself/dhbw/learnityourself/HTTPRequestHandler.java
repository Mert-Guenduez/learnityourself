package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.conn.ssl.SSLSocketFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
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
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class HTTPRequestHandler extends AsyncTask<String, Integer, InputStream> {
    @Override
    protected InputStream doInBackground(String... inUrl) {
      /*  URL url = null;
        try {
            url = new URL(inUrl[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpsURLConnection urlConnection = null;
        try {
            urlConnection = (HttpsURLConnection) url.openConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // urlConnection.setSSLSocketFactory(ssl.getSocketFactory());
        try {
            InputStream in = urlConnection.getInputStream();
            return in;
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
*/
        URL url = null;
        try {
            url = new URL(inUrl[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Map<String,Object> params = new LinkedHashMap<>();
        for(int i=1; i<inUrl.length; i+=2){
            params.put(inUrl[i], inUrl[i+1]);
        }
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
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
        }
        byte[] postDataBytes = new byte[0];
        try {
            postDataBytes = postData.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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

}

