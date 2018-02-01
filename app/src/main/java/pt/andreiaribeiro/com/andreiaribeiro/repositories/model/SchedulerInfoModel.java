package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SchedulerInfoModel {

    @JsonProperty("Events")
    private List<SchedulerEventModel> events = new ArrayList<>();

    @JsonProperty("Actions")
    private List<ScheduleActionsModel> actions = new ArrayList<>();

    public SchedulerInfoModel() {
    }

    public List<SchedulerEventModel> getEvents() {
        return events;
    }

    public void setEvents(List<SchedulerEventModel> events) {
        this.events = events;
    }

    public List<ScheduleActionsModel> getActions() {
        return actions;
    }

    public void setActions(List<ScheduleActionsModel> actions) {
        this.actions = actions;
    }
}
