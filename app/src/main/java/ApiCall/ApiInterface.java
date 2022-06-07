package ApiCall;

import java.util.List;

import Models.MainDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("entries/en/{word}")
    Call<List<MainDetails>> getMeanings(
            @Path("word") String word
    );
}
