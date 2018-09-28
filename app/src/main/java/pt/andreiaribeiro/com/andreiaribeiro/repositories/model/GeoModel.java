package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoModel {

    @JsonProperty("GeoOne")
    private KeyValueModel geo1;

    @JsonProperty("GeoTwo")
    private KeyValueModel geo2;

    @JsonProperty("GeoThree")
    private KeyValueModel geo3;

    public KeyValueModel getGeo1() {
        return geo1;
    }

    public void setGeo1(KeyValueModel geo1) {
        this.geo1 = geo1;
    }

    public KeyValueModel getGeo2() {
        return geo2;
    }

    public void setGeo2(KeyValueModel geo2) {
        this.geo2 = geo2;
    }

    public KeyValueModel getGeo3() {
        return geo3;
    }

    public void setGeo3(KeyValueModel geo3) {
        this.geo3 = geo3;
    }
}
