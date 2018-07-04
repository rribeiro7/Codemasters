package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseProfissional<T> {

    @JsonProperty("d")
    private ProfessionalModel professionalModel;

    public BaseProfissional() {
    }

    public ProfessionalModel getProfessionalModel() {
        return professionalModel;
    }

    public void setProfessionalModel(ProfessionalModel professionalModel) {
        this.professionalModel = professionalModel;
    }
}
