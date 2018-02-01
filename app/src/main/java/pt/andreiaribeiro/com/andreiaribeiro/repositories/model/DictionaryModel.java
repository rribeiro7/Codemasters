package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryModel {

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Keys")
    private List<KeyValueModel> keys = new ArrayList<>();


    public DictionaryModel() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<KeyValueModel> getKeys() {
        return keys;
    }

    public void setKeys(List<KeyValueModel> keys) {
        this.keys = keys;
    }

}