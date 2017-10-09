package web.player.bean.pmt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pmt {

    public Pmt() { }

    private String freewheelFlashSiteSection;

    private String originalFeed;

    private Feed feed;

    public String getFreewheelFlashSiteSection() {
        return freewheelFlashSiteSection;
    }

    public void setFreewheelFlashSiteSection(String freewheelFlashSiteSection) {
        this.freewheelFlashSiteSection = freewheelFlashSiteSection;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public String getOriginalFeed() {
        return originalFeed;
    }

}



