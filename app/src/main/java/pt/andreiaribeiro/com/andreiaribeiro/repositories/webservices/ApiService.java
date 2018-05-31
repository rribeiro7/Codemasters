package pt.andreiaribeiro.com.andreiaribeiro.repositories.webservices;

import okhttp3.RequestBody;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ProfessionalModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfoModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("AuthWS.asmx/login")
    Call<BaseResponse<UserAuthInfoModel>> authenticate(@Body RequestBody requestBody);

    @POST("ProfessionalWS.asmx/SearchProfessionals")
    Call<BaseListResponse<SearchProfessionals>> listProfessional(@Body RequestBody requestBody);

    @POST("ProfessionalWS.asmx/GetProfessionalDetails")
    Call<BaseResponse<SearchProfessionals>> detailProfessional(@Body RequestBody requestBody);

    @POST("AuthWS.asmx/Register")
    Call<BaseResponse<UserModel>> registerUser(@Body RequestBody requestBody);
}