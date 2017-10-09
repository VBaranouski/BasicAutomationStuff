package web.player.bean.mediagen;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaGen {

    public MediaGen(){}

    private Package aPackage;

    public Package getPackage() {
        return aPackage;
    }


}
