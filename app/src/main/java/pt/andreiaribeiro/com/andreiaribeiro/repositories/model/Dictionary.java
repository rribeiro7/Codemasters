package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dictionary {

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Keys")
    private List<KeyValue> keys = new ArrayList<>();


    public Dictionary() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<KeyValue> getKeys() {
        return keys;
    }

    public void setKeys(List<KeyValue> keys) {
        this.keys = keys;
    }

}