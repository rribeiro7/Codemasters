package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> {

    @JsonProperty("d")
    private BodyResponse<T> bodyresponse;

    public BaseResponse() {
    }

    public BodyResponse<T> getBodyResponse() {
        return bodyresponse;
    }

    public void setBodyResponse(BodyResponse<T> bodyresponse) {
        this.bodyresponse = bodyresponse;
    }


}
