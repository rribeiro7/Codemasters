package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

/**
 * Created by Rui on 13/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @JsonProperty("OK")
    protected boolean mOK;
    @JsonProperty("Message")
    protected String mMessage;
    @JsonProperty("ShowMessage")
    protected boolean mShowMessage;
    @JsonProperty("MessageType")
    protected String mMessageType;
    @JsonProperty("Obj")
    protected Object mObj;

    public Result() {
    }

    public boolean isOK() {
        return mOK;
    }

    public void setOK(boolean mOK) {
        this.mOK = mOK;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public boolean isShowMessage() {
        return mShowMessage;
    }

    public void setShowMessage(boolean mShowMessage) {
        this.mShowMessage = mShowMessage;
    }

    public String getMessageType() {
        return mMessageType;
    }

    public void setMessageType(String mMessageType) {
        this.mMessageType = mMessageType;
    }

    public Object getObj() {
        return mObj;
    }

    public void setObj(Object mObj) {
        this.mObj = mObj;
    }
}
