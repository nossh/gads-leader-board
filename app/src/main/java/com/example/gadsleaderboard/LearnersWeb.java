package com.example.gadsleaderboard;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
public interface LearnersWeb {

    @GET("api/hours/")
    Call<List<ListLearners>> getAllLearners();
}
