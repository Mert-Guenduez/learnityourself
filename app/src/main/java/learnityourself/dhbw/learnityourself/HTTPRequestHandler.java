package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class HTTPRequestHandler extends AsyncTask<String, Integer, InputStream> {

    private SSLContext sslContext;
    public HTTPRequestHandler(SSLContext sslContext){
        this.sslContext=sslContext;
    }
    @Override
    protected InputStream doInBackground(String... inUrl) {
        URL url = null;
        try {
            url = new URL(inUrl[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpsURLConnection urlConnection = null;
        try {
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setSSLSocketFactory(sslContext.getSocketFactory());



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

    }

}

