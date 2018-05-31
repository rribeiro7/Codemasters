package pt.andreiaribeiro.com.andreiaribeiro.repositories.webservices;

import android.support.annotation.NonNull;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ProfessionalModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfoModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserModel;
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
    public void authenticate(String email, String password, @NonNull Callback<BaseResponse<UserAuthInfoModel>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"type\": \"user\",\r\n    \"email\": \""
                + email + "\",\r\n    \"password\": \"" + password + "\"\r\n}");

        Call<BaseResponse<UserAuthInfoModel>> call = service.authenticate(requestBody);
        call.enqueue(cb);
    }

    public void listProfessional(String query, int activityId, int serviceId, String name, int geoOne, int geoTwo, int geoThree, @NonNull Callback<BaseListResponse<SearchProfessionals>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"query\": \""+ query + "\",\r\n    \"activity_id\": "+ activityId + ",\r\n    \"service_id\": "+ serviceId + ",\r\n    \"geoone_id\": "+ geoOne + ",\r\n    \"geotwo_id\": "+ geoTwo + ",\r\n    \"geothree_id\": "+ geoThree + ",\r\n    \"name\": \"" + name + "\"\r\n}");
        Call<BaseListResponse<SearchProfessionals>> call = service.listProfessional(requestBody);
        call.enqueue(cb);
    }

    //TODO this is wrong
    public void detailProfessional(int id, @NonNull Callback<BaseResponse<SearchProfessionals>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"id\": "+ id + "}");
        Call<BaseResponse<SearchProfessionals>> call = service.detailProfessional(requestBody);
        call.enqueue(cb);
    }

    public void registerUser(String type, String name, String email, String password, String confirmpass, String lang,  @NonNull Callback<BaseResponse<UserModel>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"type\": \""+ type + "\",\r\n    \"name\": \""+ name + "\",\r\n    \"email\": \""+ email + "\", \r\n    \"password\": \""+ password + "\", \r\n    \"confirmpass\": \""+ confirmpass + "\",\r\n    \"lang\": \"" + password + "\"\r\n}");
        Call<BaseResponse<UserModel>> call = service.registerUser(requestBody);
        call.enqueue(cb);
    }

}
