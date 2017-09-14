package pt.andreiaribeiro.com.andreiaribeiro.network;

/**
 * Created by Rui on 14/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAuthInfo {

    @JsonProperty("UserID")
    protected int mUserID;
    @JsonProperty("Username")
    protected String mUsername;
    @JsonProperty("Language")
    protected String mLanguage;
    @JsonProperty("DisplayName")
    protected String mDisplayName;
    @JsonProperty("UserType")
    protected String mUserType;

    public UserAuthInfo() {
    }

    public int getUserID() {
        return mUserID;
    }

    public void setUserID(int mUserID) {
        this.mUserID = mUserID;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String mDisplayName) {
        this.mDisplayName = mDisplayName;
    }

    public String getUserType() {
        return mUserType;
    }

    public void setUserType(String mUserType) {
        this.mUserType = mUserType;
    }
}
