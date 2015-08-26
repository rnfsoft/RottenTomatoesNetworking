package com.rnfsoft.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BoxOfficeActivity extends AppCompatActivity {

    private ListView lvMovies;
    private BoxOfficeMovieAdapter adapterMovies;
    public static final String MOVIE_DETAIL_KEY = "movie";

    RottenTomatoesClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_office);

        lvMovies = (ListView) findViewById(R.id.lvMovies);
        ArrayList<BoxOfficeMovie> aMovies = new ArrayList<BoxOfficeMovie>();
        adapterMovies = new BoxOfficeMovieAdapter(this, aMovies);
        lvMovies.setAdapter(adapterMovies);
        
        fetchBoxOfficeMovies();
        setupMovieSelectedListener();

        
    }


    private void fetchBoxOfficeMovies() {
        client = new RottenTomatoesClient();
        client.getBoxOfficeMovies(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray items = null;

                try {
                    items = response.getJSONArray("movies");
                    ArrayList<BoxOfficeMovie> movies = BoxOfficeMovie.fromJson(items);
                    for (BoxOfficeMovie movie : movies) {
                        adapterMovies.add(movie);
                    }
                    adapterMovies.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                super.onSuccess(statusCode, headers, response);
            }
        });

    }


    private void setupMovieSelectedListener() {
        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(BoxOfficeActivity.this, BoxOfficeDetailActivity.class);
                i.putExtra(MOVIE_DETAIL_KEY, adapterMovies.getItem(position));
                startActivity(i);
            }
        });


    }


}
