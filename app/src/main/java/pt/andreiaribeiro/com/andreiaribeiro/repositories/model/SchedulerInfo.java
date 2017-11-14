package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SchedulerInfo {

    @JsonProperty("Events")
    private List<SchedulerEvent> events = new ArrayList<>();

    @JsonProperty("Actions")
    private List<ScheduleActions> actions = new ArrayList<>();

    public SchedulerInfo() {
    }

    public List<SchedulerEvent> getEvents() {
        return events;
    }

    public void setEvents(List<SchedulerEvent> events) {
        this.events = events;
    }

    public List<ScheduleActions> getActions() {
        return actions;
    }

    public void setActions(List<ScheduleActions> actions) {
        this.actions = actions;
    }
}
