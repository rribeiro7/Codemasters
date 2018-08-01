package pt.andreiaribeiro.com.andreiaribeiro.repositories.webservices;

import okhttp3.RequestBody;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseProfissional;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.MessagesModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ProfessionalModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfoModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @POST("AuthWS.asmx/login")
    Call<BaseResponse<UserAuthInfoModel>> authenticate(@Body RequestBody requestBody);

    @POST("ProfessionalWS.asmx/SearchProfessionals")
    Call<BaseListResponse<SearchProfessionals>> listProfessional(@Body RequestBody requestBody);

    @POST("ProfessionalWS.asmx/GetProfessionalDetails")
    Call<BaseProfissional> detailProfessional(@Body RequestBody requestBody);

    @POST("AuthWS.asmx/Register")
    Call<BaseResponse<UserModel>> registerUser(@Body RequestBody requestBody);

    @POST("MessageWs.asmx/GetAllMessages")
    Call<BaseListResponse<MessagesModel>> getAllMessages(@Body RequestBody requestBody);
}