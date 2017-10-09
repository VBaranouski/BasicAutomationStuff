package web.player.bean.pmt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

    private String isMature;

    private String duration;

    private String description;

    private Group group;

    public Group getGroup() {
        return group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIsMature() {
        return isMature;
    }

    public void setIsMature(String isMature) {
        this.isMature = isMature;
    }
}
