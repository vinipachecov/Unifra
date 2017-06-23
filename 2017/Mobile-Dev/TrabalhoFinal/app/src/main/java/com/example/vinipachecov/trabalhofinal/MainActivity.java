package com.example.vinipachecov.trabalhofinal;

import android.content.Intent;
import android.net.Network;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.R.id.message;
import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;

public class MainActivity extends AppCompatActivity {

    private final String USER_AGENT = "Mozilla/5.0";

    private static final String TAG = "MainActivity";

    public void fazGet(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("Resposta", response);
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("deu pau");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://wwww.unifra.br/site";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println("Resposta" + response.toString());

    }

    public void sendPost() throws Exception {
        String urlParameters = "Login=2016011370&Senha=Cardalb1";
        byte[] postData = urlParameters.getBytes("UTF-8");
        int postDataLength = postData.length;
        String url = "https://wwww.unifra.br/Agenda";
        URL obj = new URL(url);
        System.out.println("vai abrir conexão");
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        System.out.println("abriu conexão");
        con.setInstanceFollowRedirects(true);
        //add reuqest header
        con.setRequestMethod("POST");

        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("charset", "utf-8");
        con.setRequestProperty("Content-Length", Integer.toString(postDataLength));

        con.setRequestProperty("User-Agent", USER_AGENT);


        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


        // Send post request
        System.out.println("deu pau" + con.getOutputStream());
        con.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());

        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    public void Pst() {
        try {
            URL url = new URL("http://wwww.unifra.br/Agenda");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("Login", "2016011370")
                    .appendQueryParameter("Senha", "Cardlab1");
            String query = builder.build().getEncodedQuery();

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            conn.connect();
        } catch (Exception e) {

        }
    }

//-------------------------
    CookieManager manager;
    public void fazPost() {
        manager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(manager);


        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://wwww.unifra.br/Agenda";


        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.i("Resposta: ", "Passou");
                        Log.d("Response", response);
                        Document doc = Jsoup.parse(response);
                        System.out.println("DOC: " + doc.head().getElementsByTag("script"));
                        System.out.println("nova url = " + url + response.substring(44, 106));
                        String novaurl = url + response.substring(44, 106);
                        Log.d("URIS", manager.getCookieStore().getURIs().toString());

                        Log.d("COOKIE", manager.getCookieStore().getCookies().toString());
                        //fazGet(novaurl);
                        //fazGet("http://wwww.unifra.br/Agenda");//
                        fazPost2(novaurl);
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Login", "2016011370");
                params.put("Senha", "Cardalb1");

                return params;
            }
        };
        queue.add(postRequest);
    }


    public void fazPost2(String novaURL) {
        /*manager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(manager);*/
        final String url = novaURL;
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.i("Resposta: ", "Passou");
                        Log.d("Response", response);
                        Document doc = Jsoup.parse(response);
                        System.out.println("DOC: " + doc.head().getElementsByTag("script"));
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Login", "2016011370");
                params.put("Senha", "Cardalb1");

                return params;
            }
        };
        queue.add(postRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        EditText login = (EditText) findViewById(R.id.loginTextField);
        EditText password = (EditText) findViewById(R.id.passwordTextFIeld);
//
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                try {

                    System.out.println("começando a thread");
                    fazPost();
                } catch (Exception e) {
                }
                return null;
            }


        }.execute();


    }


    public void Login(View v) {
        Intent intent = new Intent(this, mainmenu.class);
        startActivity(intent);
    }
}
