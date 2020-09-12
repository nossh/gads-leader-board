package com.example.gadsleaderboard;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;

public class Learner extends AsyncTask<Void, Void, Void> {

    public RecyclerView recyclerView;
    List<ListLearners> listLearners;
    private static String JSON_URL = "https://gadsapi.herokuapp.com/api/hours";
    Adapter adapter;

    Activity activity;

    public Context mContext;
//    public AsyncTask (Context context) {
//        this.mContext = context;
//    }

//    private void extractLearners() {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest(Request.Method.GET, JSON_URL, )
//    }





    String leaderData = "";
    String dataParsed = "";
    String leanerName = "";
    String hour = "";
    String country = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL leaderULR = new URL("https://gadsapi.herokuapp.com/api/hours");
            HttpURLConnection httpCon = (HttpURLConnection) leaderULR.openConnection();
            InputStream inStream = httpCon.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
            String line = "";
            while (line != null){
                line = bufferedReader.readLine();
                leaderData = leaderData + line;
            }
            JSONArray jsonArray = new JSONArray(leaderData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                leanerName = (String) jsonObject.get("name");
                hour = (String) jsonObject.get("hour");
                country = jsonObject.getString("country");

                ListLearners listLearner = new ListLearners();
                listLearner.setLeanerName(jsonObject.get("name").toString());
                listLearner.setLeanerHour(jsonObject.get("hour").toString());
                listLearner.setLearnerCountry(jsonObject.get("country").toString());

                listLearners.add(listLearner);


                dataParsed = dataParsed + country;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute (Void eVoid) {
        super.onPostExecute(eVoid);
        //MainActivity.leaderData.setText(this.dataParsed);
        recyclerView = recyclerView.findViewById(R.id.learners_list);
        listLearners = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));
        adapter = new Adapter(activity.getApplicationContext(), listLearners);
        recyclerView.setAdapter(adapter);
    }
}
