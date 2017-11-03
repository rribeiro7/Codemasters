package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

/**
 * Created by Rui on 13/09/2017.
 */
/*TODO refactor desta classe quando estiver totalmente certa no serviço
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SchedulerEvent {

    @JsonProperty("id_schedule")
    protected int mId_schedule;
    @JsonProperty("title")
    protected String mtitle;
    @JsonProperty("editable")
    protected boolean meditable;
    @JsonProperty("start")
    protected String mstart;
    @JsonProperty("end")
    protected String mend;
    @JsonProperty("state")
    protected String mstate;
    @JsonProperty("obs")
    protected String mobs;
    @JsonProperty("backgroundColor")
    protected String mbackgroundColor;

    public SchedulerEvent() {
    }

    public int getmId_schedule() {
        return mId_schedule;
    }

    public void setmId_schedule(int mId_schedule) {
        this.mId_schedule = mId_schedule;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public boolean isMeditable() {
        return meditable;
    }

    public void setMeditable(boolean meditable) {
        this.meditable = meditable;
    }

    public String getMstart() {
        return mstart;
    }

    public void setMstart(String mstart) {
        this.mstart = mstart;
    }

    public String getMend() {
        return mend;
    }

    public void setMend(String mend) {
        this.mend = mend;
    }

    public String getMstate() {
        return mstate;
    }

    public void setMstate(String mstate) {
        this.mstate = mstate;
    }

    public String getMobs() {
        return mobs;
    }

    public void setMobs(String mobs) {
        this.mobs = mobs;
    }

    public String getMbackgroundColor() {
        return mbackgroundColor;
    }

    public void setMbackgroundColor(String mbackgroundColor) {
        this.mbackgroundColor = mbackgroundColor;
    }
}
