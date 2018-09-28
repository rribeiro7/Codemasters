package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseKeyValue<T> {

    @JsonProperty("d")
    private List<KeyValueModel> lstKeyValue;

    public BaseKeyValue() {
    }

    public List<KeyValueModel> getLstKeyValue() {
        return lstKeyValue;
    }

    public void setLstKeyValue(List<KeyValueModel> lstKeyValue) {
        this.lstKeyValue = lstKeyValue;
    }

}
