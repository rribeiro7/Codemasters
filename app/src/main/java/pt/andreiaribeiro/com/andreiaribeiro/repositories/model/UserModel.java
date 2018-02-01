package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(tableName = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

    @PrimaryKey
    @JsonProperty("ID")
    private int id;

    @ColumnInfo(name = "name")
    @JsonProperty("Name")
    private String name;

    @ColumnInfo(name = "birth_date")
    @JsonProperty("Birthdate")
    private String birthdate;

    @ColumnInfo(name = "email")
    @JsonProperty("Email")
    private String email;

    @ColumnInfo(name = "iban")
    @JsonProperty("IBAN")
    private String iban;

    @ColumnInfo(name = "credit_card")
    @JsonProperty("CreditCard")
    private String creditCard;

    public UserModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}


