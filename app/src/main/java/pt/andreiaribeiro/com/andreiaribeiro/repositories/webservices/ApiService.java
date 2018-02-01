package pt.andreiaribeiro.com.andreiaribeiro.repositories.webservices;

import okhttp3.RequestBody;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    Call<BaseResponse<UserAuthInfo>> authenticate(@Body RequestBody requestBody);
}