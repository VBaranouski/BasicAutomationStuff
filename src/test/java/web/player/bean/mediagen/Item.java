package web.player.bean.mediagen;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private String origination_date;

    public String getOrigination_date() {
        return origination_date;
    }

    public void setOrigination_date(String origination_date) {
        this.origination_date = origination_date;
    }
}
