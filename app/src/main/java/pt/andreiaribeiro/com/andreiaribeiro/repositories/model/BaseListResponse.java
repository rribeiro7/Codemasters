package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseListResponse<T> {

    @JsonProperty("d")
    private BodyListResponse<T> bodyresponse;

    public BaseListResponse() {
    }

    public BodyListResponse<T> getBodyResponse() {
        return bodyresponse;
    }

    public void setBodyResponse(BodyListResponse<T> bodyresponse) {
        this.bodyresponse = bodyresponse;
    }

}
