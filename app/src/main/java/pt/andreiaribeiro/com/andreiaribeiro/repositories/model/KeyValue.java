package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

/**
 * Created by Rui on 13/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyValue {

    @JsonProperty("Key")
    protected String mKey;
    @JsonProperty("Value")
    protected String mValue;

    public KeyValue() {
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String mKey) {
        this.mKey = mKey;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String mValue) {
        this.mValue = mValue;
    }
}
