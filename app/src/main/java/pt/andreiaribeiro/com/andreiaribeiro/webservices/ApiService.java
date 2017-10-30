package pt.andreiaribeiro.com.andreiaribeiro.webservices;

import pt.andreiaribeiro.com.andreiaribeiro.network.UserAuthInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rui on 23/10/2017.
 */

public class ApiService {

    @GET("login")
    Call<UserAuthInfo> getUser(@Query("type") String type, @Query("email") String strEmail, @Query("password") String strPassword);

//    @GET("users/self/media/recent")
//    Call<UserMediaRecentResponse> getUserMediaRecent(@Query("access_token") String accessToken);

}
