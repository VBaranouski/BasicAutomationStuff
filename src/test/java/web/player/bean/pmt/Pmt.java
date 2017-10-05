package web.player.bean.pmt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pmt {

    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Pmt() {
    }

    private String originalFeed;

    public String getOriginalFeed() {
        return originalFeed;
    }

}



