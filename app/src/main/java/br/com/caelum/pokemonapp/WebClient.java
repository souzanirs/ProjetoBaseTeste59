package br.com.caelum.pokemonapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by solzanir on 02/11/16.
 */

public class WebClient {

    OkHttpClient client = new OkHttpClient();

    String execute(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

}
