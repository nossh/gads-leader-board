package com.example.gadsleaderboard;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstFragment extends Fragment {

    public FirstFragment () {
        //Empty
    }

    private static String JSON_URL = "https://gadsapi.herokuapp.com";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);
        final RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.leader_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Network Connection
        Retrofit.Builder build = new Retrofit.Builder()
                .baseUrl(JSON_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = build.build();
        LearnersWeb learnersWeb = retrofit.create(LearnersWeb.class);
        learnersWeb.getAllLearners().enqueue(new Callback<List<ListLearners>>() {
            @Override
            public void onResponse(Call<List<ListLearners>> call, Response<List<ListLearners>> response) {
                //Log.e("response". res)
                recyclerView.setAdapter(new Adapter(getContext(), response.body()));
            }

            @Override
            public void onFailure(Call<List<ListLearners>> call, Throwable throwable) {
                Toast.makeText(getContext(), "Connection lost, please check back.", Toast.LENGTH_LONG).show();
            }
        });


    return view;

    }


}
