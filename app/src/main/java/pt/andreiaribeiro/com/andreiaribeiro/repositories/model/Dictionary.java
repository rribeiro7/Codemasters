package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

/**
 * Created by Rui on 13/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dictionary {

    @JsonProperty("Language")
    protected String mLanguage;
    @JsonProperty("Keys")
    protected List<KeyValue> mKeys = new ArrayList<>();


    public Dictionary() {
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
    }

    public List<KeyValue> getKeys() {
        return mKeys;
    }

    public void setKeys(List<KeyValue> mKeys) {
        this.mKeys = mKeys;
    }

}