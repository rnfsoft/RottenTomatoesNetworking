package com.rnfsoft.myapplication;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by taehee on 8/25/15.
 */
public class RottenTomatoesClient {
    private final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";
    private final String API_BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    private AsyncHttpClient client;

    public RottenTomatoesClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    public void getBoxOfficeMovies(JsonHttpResponseHandler handler) {
        // http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=<key>
        String url = getApiUrl("lists/movies/box_office.json");
        RequestParams params = new RequestParams("apikey", API_KEY);
        client.get(url,params,handler);

    }
}
