package web.player.bean.pmt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {

    private String title;

    public Feed (String title){ this.title = title; }

    public String getTitle() {
        return title;
    }

}
