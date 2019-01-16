package pt.andreiaribeiro.com.andreiaribeiro.repositories.webservices;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.ser.Serializers;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseKeyValue;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseProfissional;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.KeyValueModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.MessagesDetailModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.MessagesModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ProfessionalModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SchedulerInfoModel;
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
    public void authenticate(String type, String email, String password, @NonNull Callback<BaseResponse<UserAuthInfoModel>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"type\": \""+type+"\",\r\n    \"email\": \""
                + email + "\",\r\n    \"password\": \"" + password + "\"\r\n}");

        Call<BaseResponse<UserAuthInfoModel>> call = service.authenticate(requestBody);
        call.enqueue(cb);
    }

    public void listProfessional(String query, int activityId, int serviceId, String name, int geoOne, int geoTwo, int geoThree,
                                 @NonNull Callback<BaseListResponse<SearchProfessionals>> cb){
                                 //RetrofitCallbacks<BaseListResponse<SearchProfessionals>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"query\": \""+ query + "\",\r\n    \"activity_id\": "+ activityId + ",\r\n    \"service_id\": "+ serviceId + ",\r\n    \"geoone_id\": "+ geoOne + ",\r\n    \"geotwo_id\": "+ geoTwo + ",\r\n    \"geothree_id\": "+ geoThree + ",\r\n    \"name\": \"" + name + "\"\r\n}");
        Call<BaseListResponse<SearchProfessionals>> call = service.listProfessional(requestBody);
        call.enqueue(cb);
    }

    public void detailProfessional(int id, @NonNull Callback<BaseProfissional> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"id\": "+ id + "}");
        Call<BaseProfissional> call = service.detailProfessional(requestBody);
        call.enqueue(cb);
    }

    public void registerUser(String type, String name, String email, String password, String confirmpass, String lang,  @NonNull Callback<BaseResponse<UserModel>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"type\": \""+ type + "\",\r\n    \"name\": \""+ name + "\",\r\n    \"email\": \""+ email + "\", \r\n    \"password\": \""+ password + "\", \r\n    \"confirmpass\": \""+ confirmpass + "\",\r\n    \"lang\": \"" + password + "\"\r\n}");
        Call<BaseResponse<UserModel>> call = service.registerUser(requestBody);
        call.enqueue(cb);
    }

    public void getAllMessages(String cookie, @NonNull Callback<BaseListResponse<MessagesModel>> cb){
        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "");
        Call<BaseListResponse<MessagesModel>> call = service.getAllMessages(cookie, requestBody);
        call.enqueue(cb);
    }

    public void getMessageById(String cookie, int id, @NonNull Callback<BaseListResponse<MessagesDetailModel>> cb){
        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"id\": "+ id + "}");
        Call<BaseListResponse<MessagesDetailModel>> call = service.getMessageById(cookie, requestBody);
        call.enqueue(cb);
    }

    //public Call<BaseResponse<MessagesModel>> getSendMessages(String cookie, int id,String message, @NonNull Callback<BaseResponse<MessagesModel>> cb){
    public Call<BaseResponse<MessagesModel>> getSendMessages(String cookie, int id,String message){
        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"destinationId\": "+ id + ",\r\n    \"messageText\": \""+ message + "\"}");
        return service.getSendMessages(cookie, requestBody);
        //Call<BaseResponse<MessagesModel>> call = service.getSendMessages(cookie, requestBody);
        //call.enqueue(cb);
    }

    public void addScheduleEvent(String cookie, int idUser, int idService, double price, String date, int duration, String location,String observations, String lang, @NonNull Callback<BaseResponse<MessagesModel>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"id_user\": "+ idUser +",\r\n    \"id_service\": "+ idService +",\r\n    \"price\": "+ price +",\r\n    \"date\": \""+ date +"\",\r\n    \"duration\": "+ duration +",\r\n    \"location\": \""+ location +"\",\r\n    \"observations\": \"" + observations + "\",\r\n    \"lang\": \""+ lang +"\"\r\n}");

        Call<BaseResponse<MessagesModel>> call = service.addScheduleEvent(cookie, requestBody);
        call.enqueue(cb);
    }

    public Call<BaseKeyValue<KeyValueModel>> getServiceByActivityId(int id) {
        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"id\": "+ id + "}");
        return service.getServiceByActivityId(requestBody);
    }

    public Call<BaseKeyValue<KeyValueModel>> getCouncilsByDistrict(int id) {
        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "{\r\n    \"id\": "+ id + "}");
        return service.getCouncilsByDistrict(requestBody);
    }

    public void getAllSchedules(String cookie, @NonNull Callback<BaseResponse<SchedulerInfoModel>> cb) {

        MediaType mediaType = MediaType.parse("application/json; chartset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, "");

        Call<BaseResponse<SchedulerInfoModel>> call = service.getAllSchedules(cookie, requestBody);
        call.enqueue(cb);
    }


}
