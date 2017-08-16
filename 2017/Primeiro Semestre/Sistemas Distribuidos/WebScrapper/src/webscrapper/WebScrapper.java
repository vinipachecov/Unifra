/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vinipachecov
 */
public class WebScrapper {
    
    	private final String USER_AGENT = "Mozilla/5.0";
        
        
        public static void main(String[] args) throws Exception {

		WebScrapper http = new WebScrapper();
                //CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL ) );
                System.out.println("Testing 1 - Send Http Get request");
                //http.sendGet("http://ava.unifra.br/login/index2.php?dados=A24AA6DB38AEDAEFD12440D8DFDBDB124D7EACD9EC92F334C4E0EA951A34A3BC");
                //http.test();
		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}
        
        private void sendGet() throws Exception {

        String url = "http://wwww.unifra.br/Agenda?Login=20116011370&Senha=Cardalb1";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //definição de que iremos utilizar o método GET
        con.setRequestMethod("GET");

        //adicionamos o cabeçalho da requisição, definindo o "user agent", ou seja, o perfil de navegação
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nEnviando requisição 'GET' para a URL : " + url);
        System.out.println("Código de resposta : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String linha;

        //mostramos o resultado
        while ((linha = in.readLine()) != null) {
            System.out.println(linha);
            //response.append(inputLine);
        }
        in.close();

    }
        
        private void sendGet(String url) throws Exception {

        

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
      

        //definição de que iremos utilizar o método GET
        con.setRequestMethod("GET");

        //adicionamos o cabeçalho da requisição, definindo o "user agent", ou seja, o perfil de navegação
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nEnviando requisição 'GET' para a URL : " + url);
        System.out.println("Código de resposta : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String linha;

        //mostramos o resultado
        while ((linha = in.readLine()) != null) {
            System.out.println(linha);
            //response.append(inputLine);
        }
        in.close();

    }
        
//        
//        public void test(){
//            try {
//                URLConnection url = new URLConnection(new URL("http://wwww.unifra.br/Agenda")) {
//                    @Override
//                    public void connect() throws IOException {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                    }
//                };
//                url.connect();
//               List<String> cookies = url.getHeaderFields().get("Set-Cookie");
//                System.out.println("Cookies = " + cookies);
//            } catch (Exception e) {
//            }
//        }
    // HTTP POST request
	private void sendPost() throws Exception {
        URL url = new URL("http://wwww.unifra.br/Agenda");
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("Login", "2016011370");
        params.put("Senha", "Cardalb1");        

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        
          
//        java.net.CookieManager msCookieManager = new java.net.CookieManager();
//        
//        
//        Map<String, List<String>> headerFields = conn.getHeaderFields();
//        List<String> cookiesHeader = headerFields.get("Set-Cookie");
//            System.out.println("Valor nos cookies = " + cookiesHeader);
//
//        if (cookiesHeader != null) {
//            for (String cookie : cookiesHeader) {
//                msCookieManager.getCookieStore().add(null,HttpCookie.parse(cookie).get(0));
//            }               
//        }
        
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
            System.out.println(conn.getHeaderFields());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;)
            System.out.print((char)c);
        
        sendGet("https://wwww.unifra.br/Agenda/Aluno/9FF14811A9EFB909/C918E21D0CD46796815AFADC1B473D28/aluno");
    }
    
	

    
}
