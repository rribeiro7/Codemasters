package pt.andreiaribeiro.com.andreiaribeiro;

import android.app.Application;
import android.content.Context;

import pt.andreiaribeiro.com.andreiaribeiro.repositories.webservices.ApiRepository;

public class LiberiixApplication extends Application {

    private static ApiRepository API_REPOSITORY_INSTANCE;

    public static ApiRepository getApiRepositoryInstance(Context context) {
        if (API_REPOSITORY_INSTANCE == null) {
            API_REPOSITORY_INSTANCE =
                    new ApiRepository("http://liberiix.com/webservices/AuthWS.asmx/");
        }
        return API_REPOSITORY_INSTANCE;
    }

    public void destroyApiRepositoryInstance() {
        API_REPOSITORY_INSTANCE = null;
    }

}
