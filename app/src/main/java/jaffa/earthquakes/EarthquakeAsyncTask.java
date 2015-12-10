package jaffa.earthquakes;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by libby on 12/3/2015.
 */
public class EarthquakeAsyncTask extends AsyncTask<Long, Void, Earthquake>{


    private RecyclerView recyclerView;
    private Earthquake earthquakes;

    public EarthquakeAsyncTask(RecyclerView recyclerView){
            this.recyclerView = recyclerView;

        }

        /*run method - gets called in a separate thread*/
        @Override
        protected Earthquake doInBackground(Long... params) {

            URL url = null;
            earthquakes = null;
            try {
                url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson");
                HttpURLConnection connection = null;
                connection = (HttpURLConnection) url.openConnection();
                InputStream in = null;
                in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                GsonBuilder builder = new GsonBuilder();
                builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
                Gson gson = builder.create();
                earthquakes = gson.fromJson(reader, Earthquake.class);
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return earthquakes;
        }

        /*what to do when the AsyncTask completes
        * gets called on the UIThread. all text views can only be modified on the UIThread*/
        @Override
        protected void onPostExecute(Earthquake earthquakes) {
            /*update recycler view with adapter*/
            super.onPostExecute(earthquakes);

            EarthquakeRecyclerViewAdapter adapter = new EarthquakeRecyclerViewAdapter(earthquakes);

            recyclerView.setAdapter(adapter);
        }

    }