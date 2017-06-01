package com.example.vinipachecov.trabalhofinal;

import android.content.Intent;
import android.net.Network;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import okhttp3.Response;

import static android.R.id.message;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    TextView textView;
    String serverurl = "http://wwww.unifra.com";

    private static final String TAG = "MainActivity";



    public void VolleyRequest(){
        RequestQueue mRequestQueue;

// Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        mRequestQueue = new RequestQueue(cache, network);

// Start the queue
        mRequestQueue.start();

        String url ="http://wwww.unifra.br/site";

// Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("Resposta " + response);
                        // Do something with the response
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

// Add the request to the RequestQueue.
        mRequestQueue.add(stringRequest);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        VolleyRequest();
//
//        //tarefa asíncrona com okHttp
//        new AsyncTask<Void,Void, String>(){
//
//            @Override
//            protected String doInBackground(Void... params) {
//                OkHttpClient client = new OkHttpClient();
//
//                Request request = new Request.Builder()
//                        .url("http://wwww.unifra.br/site")
//                        .build();
//                try {
//                    Response response = client.newCall(request).execute();
//                    //System.out.println(response.body().string());
//                    Log.d(TAG, "doInBackground() body: " + "párams" + response.body().string()  );
//                    Log.d(TAG, "doInBackground() response: " + "párams" + response.toString()  );//
//                    return  response.body().string();
//                }catch (Exception e){
//
//                }
//                return null;
//
//            }
//        }.execute();
    }

    public void Login(View v){
        Intent intent = new Intent(this, mainmenu.class);
        startActivity(intent);
    }
}
