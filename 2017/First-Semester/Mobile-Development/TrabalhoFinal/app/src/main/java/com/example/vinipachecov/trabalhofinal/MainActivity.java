package com.example.vinipachecov.trabalhofinal;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
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


import junit.framework.Assert;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

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






public class MainActivity extends AppCompatActivity {

    private final String USER_AGENT = "Mozilla/5.0";

    private static final String TAG = "MainActivity";

    String currentUrl;

    public void fazGet(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("Resposta", response);
                        System.out.println("Reeeesposta: " + response);
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



//-------------------------










    CookieManager manager;
    public void fazPost() {
        manager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(manager);


        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://wwww.unifra.br/Agenda";

        StringRequest postRequest = createRequest(url, Request.Method.POST);

        queue.add(postRequest);

//        postRequest = createRequest(currentUrl, Request.Method.POST);
//
//        queue.add(postRequest);


    }


    public StringRequest createRequest(String newurl, int method){
        final String url = newurl;

        StringRequest request = null;

        if(method == Request.Method.POST){
             request = new StringRequest(Request.Method.POST, url,
                    new com.android.volley.Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Link Utilizado:", url);
                            Log.d("Response", response);
                            Document doc = Jsoup.parse(response);
                            System.out.println();
                            Elements links = doc.select("a[href]");
                            System.out.println("LINKS: " + links);
                            //System.out.println("DOC: " + doc.head().getElementsByTag("script"));
                            //System.out.println("nova url = " + url + response.substring(44, 106));
                            String novaurl= url + response.substring(44, 106);
                            fazPost2(novaurl);
                            //fazPost2(url + "/Aluno/ListaServicos");
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

        }else{
            request = new StringRequest(Request.Method.GET, url,
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
        }


        return request;

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
                        Log.d("Response2", response);
                        Document doc = Jsoup.parse(response);
                        Elements links = doc.select("a[href]");
                        System.out.println("LINKS: " + links);
                        //fazPost3("http://wwww.unifra.br/Agenda/Aluno/Frame?app=BOLETO&name=Imprimir%20Boletos");
                        fazPost3("http://wwww.unifra.br/Agenda/Aluno/Disciplina/Disciplina");
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



    public void fazPost3(String novaURL) {
        /*manager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(manager);*/
        final String url = novaURL;
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Url usada", url);
                        Document doc = Jsoup.parse(response);
                        Log.d("Response3", doc.toString());
                        Elements links = doc.select("a[href]");
                        System.out.println("LINKS: " + links);
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
//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... params) {
//                try {
//
//                    System.out.println("começando a thread");
//                    fazPost();
//                } catch (Exception e) {
//                }
//                return null;
//            }
//
//        }.execute();


    }


    public void Login(View v) {
        Intent intent = new Intent(this, mainmenu.class);
        startActivity(intent);
    }
}
