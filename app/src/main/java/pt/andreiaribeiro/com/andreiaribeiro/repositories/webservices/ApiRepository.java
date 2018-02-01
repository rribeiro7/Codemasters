package pt.andreiaribeiro.com.andreiaribeiro.repositories.webservices;

import android.support.annotation.NonNull;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiRepository {

    private ApiService service;
    private Retrofit retrofit;

    public ApiRepository(String baseUrl) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    /**
     * @param email    {@see java.lang.String} The user email.
     * @param password {@see java.lang.String} The user password.
     * @param cb       {@see retrofit.Callback}<{@see BaseResponse}> The Callback of the request.
     */
    public void authenticate(String email, String password, @NonNull Callback<BaseResponse<UserAuthInfo>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"type\": \"user\",\r\n    \"email\": \""
                + email + "\",\r\n    \"password\": \"" + password + "\"\r\n}");

        Call<BaseResponse<UserAuthInfo>> call = service.authenticate(requestBody);
        call.enqueue(cb);
    }

}
