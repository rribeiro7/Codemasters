package pt.andreiaribeiro.com.andreiaribeiro.webservices;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pt.andreiaribeiro.com.andreiaribeiro.network.UserAuthInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Rui on 23/10/2017.
 */

public class ApiRepository {

    private ApiService mService;
    private Retrofit mRetrofit;

    public ApiRepository(String endpoint) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(httpClient.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        mService = mRetrofit.create(ApiService.class);
    }

    /**
     * Procedure responsible for getting user's information
     *
     * @param type {@see java.lang.String} The Type of user required.
     * @param cb   {@see retrofit.Callback}<{@see UserResponse}> The Callback of the request.
     */
    public void getUser(String type, String email, String password, @NonNull Callback<UserAuthInfo> cb) {
        Call<UserAuthInfo> call = mService.getUser(type, email, password);
        call.enqueue(cb);
    }

    /**
     * Procedure responsible for getting user's recent media information
     *
     * @param accessToken {@see java.lang.String} The Access Token required.
     * @param cb          {@see retrofit.Callback}<{@see UserMediaRecentResponse}> The Callback of the request.
     */
//    public void getUserRecentMedia(String accessToken, @NonNull Callback<UserMediaRecentResponse> cb) {
//        Call<UserMediaRecentResponse> call = mService.getUserMediaRecent(accessToken);
//        call.enqueue(cb);
//    }
}
