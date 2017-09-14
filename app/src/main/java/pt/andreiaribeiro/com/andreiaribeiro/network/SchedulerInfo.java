package pt.andreiaribeiro.com.andreiaribeiro.network;

/**
 * Created by Rui on 13/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SchedulerInfo {

    @JsonProperty("Events")
    protected List<SchedulerEvent> mEvents = new ArrayList<>();
    @JsonProperty("Actions")
    protected List<ScheduleActions> mActions = new ArrayList<>();

    public SchedulerInfo() {
    }

    public List<SchedulerEvent> getEvents() {
        return mEvents;
    }

    public void setEvents(List<SchedulerEvent> mEvents) {
        this.mEvents = mEvents;
    }

    public List<ScheduleActions> getActions() {
        return mActions;
    }

    public void setActions(List<ScheduleActions> mActions) {
        this.mActions = mActions;
    }
}
