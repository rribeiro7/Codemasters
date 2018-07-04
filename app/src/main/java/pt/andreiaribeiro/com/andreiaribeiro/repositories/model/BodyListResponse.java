package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyListResponse<T> {

    @JsonProperty("__type")
    private String type;

    @JsonProperty("Obj")
    private List<T> obj;

    @JsonProperty("OK")
    private boolean ok;

    @JsonProperty("Messages")
    private String message;

    @JsonProperty("ShowMessage")
    private boolean showMessage;

    @JsonProperty("MessageType")
    private int messageType;

    public BodyListResponse() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isShowMessage() {
        return showMessage;
    }

    public void setShowMessage(boolean showMessage) {
        this.showMessage = showMessage;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public List<T> getObj() {
        return obj;
    }

    public void setObj(List<T> obj) {
        this.obj = obj;
    }
}
