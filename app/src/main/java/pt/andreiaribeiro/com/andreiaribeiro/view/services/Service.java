package pt.andreiaribeiro.com.andreiaribeiro.view.services;

public class Service {

    private String description;
    private String professional;
    private String date;
    private String image;

    public Service(String description, String professional, String date, String image) {
        this.description = description;
        this.professional = professional;
        this.date = date;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
