package web.player.constants;



public class ApiCommands {

    public enum Commands {

        GET_EMBED_CODE_CMD("return MTVNPlayer.getPlayers()[%d].getEmbedCode();"),
        GET_CURRENT_TIME_CMD("return MTVNPlayer.getPlayers()[%d].playhead;"),
        GET_TOTAL_CURRENT_TIME_CMD("return MTVNPlayer.getPlayers()[%d].absolutePlayhead;"),
        GET_CURRENT_VOLUME_CMD("return MTVNPlayer.getPlayers()[%d].volume();"),
        GET_END_TIME_CMD("return MTVNPlayer.getPlayers()[%d].getContentMetadata().duration;"),
        GET_VIDEOS_COUNT_CMD("return MTVNPlayer.getPlayers()[%d].playlistMetadata.items.length"),
        GET_SEGMENT_DURATION("return MTVNPlayer.getPlayers()[%d].playlistMetadata.items[%d].duration"),
        GET_PLAYER_STATE("return MTVNPlayer.getPlayers()[%d].state"),
        GET_PLAYER_READY_STATUS("return MTVNPlayer.getPlayers()[%d].ready"),
        GET_RENDITION_INDEX("return MTVNPlayer.getPlayers()[%d].metrics.getCurrentRenditionIndex();"),
        GET_CURRENT_SEGMENT_CMD("return MTVNPlayer.getPlayers()[%d].getContentMetadata().index;"),
        GET_TEXT_FROM_NATIVE_TRACKS_ELEMENTS("return EdgePlayer.getPlayer().contentElement.textTracks[1].activeCues[%d].text;"),
        GET_STARTTIME_FROM_NATIVE__TRACKS_ELEMENTS("return EdgePlayer.getPlayer().contentElement.textTracks[1].activeCues[%d].startTime"),
        GET_ENDTIME_FROM_NATIVE_TRACKS_ELEMENTS("return EdgePlayer.getPlayer().contentElement.textTracks[1].activeCues[%d].endTime"),
        GET_AD_COUNT("return MTVNPlayer.getPlayers()[0].getAdMetadata().adCount"),
        GET_PLAY_STATUS("function la(){var a = $('.now_playing > div > a')[%d];"
                + "{return window.getComputedStyle(a,':before').content;}} return la();"),
        GET_IS_FLASH_CMD("return MTVNPlayer.getPlayers()[%d].isFlash;"),
        GET_IS_AD_CMD("function la(){if(MTVNPlayer == null || MTVNPlayer.getPlayers()[%d] == null "
                + "|| MTVNPlayer.getPlayers()[%d].getContentMetadata() == null "
                + "|| MTVNPlayer.getPlayers()[%d].isAdBreak() == null){return false;} "
                + "else {return MTVNPlayer.getPlayers()[%d].isAdBreak();}} return la();"),
        GET_AD_STATUS("function la(){if(MTVNPlayer.getPlayers()[%d].state == 'playing'){return 'playing';} "
                + "else {if(MTVNPlayer.getPlayers()[%d].isAdBreak() == true){return 'adPresent';} "
                + "else {if(MTVNPlayer.getPlayers()[%d].isAdBreak() == null){return 'noDefined';} "
                + "else {return 'buffering';}}}} return la();"),
        SOUND_MUTE_CMD("MTVNPlayer.getPlayers()[%d].mute();"),
        SOUND_UNMUTE_CMD("MTVNPlayer.getPlayers()[%d].unmute();"),
        SEEK_VIDEO_CMD_TEMPLATE("MTVNPlayer.getPlayers()[%d].seek(%d);"),
        OPEN_COPY_LINK_WINDOW_CMD("MTVNPlayer.getPlayers()[%d].onCopy();"),
        OPEN_EMBED_LINK_WINDOW_CMD("MTVNPlayer.getPlayers()[%d].onEmbed();"),
        SHARE_ON_SOCIAL_NET_CMD("MTVNPlayer.getPlayers()[%d].onSocialShare('%s');"),
        ENABLE_CC_CMD("MTVNPlayer.getPlayers()[%d].enableCC();"),
        DISABLE_CC_CMD("MTVNPlayer.getPlayers()[%d].disableCC();"),
        CUSTOMIZE_CC_CMD("MTVNPlayer.getPlayers()[%d].customizeCC({ fontStyle: \"%s\", fontSize: \"%s\", " +
                "fontColor: \"%s\", fontOpacity: %s, backgroundColor: \"%s\", backgroundOpacity: %s, windowColor:" +
                " \"%s\", windowOpacity: %s });"),
        PLAY_SEGMENT_CMD_TEMPLATE("MTVNPlayer.getPlayers()[%d].playIndex(%d);"),
        PLAY_VIDEO_CMD("MTVNPlayer.getPlayers()[%d].play();"),
        PAUSE_VIDEO_CMD("MTVNPlayer.getPlayers()[%d].pause();"),
        GO_FULLSCREEN_CMD("MTVNPlayer.getPlayers()[%d].goFullScreen();"),
        EXIT_FULLSCREEN_CMD("MTVNPlayer.getPlayers()[%d].exitFullScreen();"),
        IS_FULLSCREEN_CMD("return MTVNPlayer.getPlayers()[%d].isFullScreen;"),
        IS_PAUSED_CMD("return MTVNPlayer.getPlayers()[%d].isPaused();"),
        SET_VOLUME("MTVNPlayer.getPlayers()[%d].volume(%d);"),
        DESTROY_PLAYER_CMD("MTVNPlayer.getPlayers()[%d].destroy();"),
        COUNTER_STRIKE_MODE("player.bento.counterStrikeMode()"),
        GET_VALUE_LOCAL_STORAGE_ITEM("return window.localStorage.getItem('edgeplayer-adBlocker')"),
        AD_BLOCKER_STATUS_EXECUTE("player.bento.adBlockerStatus(true)"),
        AD_SKIPPED_PLAYER_BENTO("player.bento.adSkipped(0,{level: 40, message: 'error message test'})"),
        AD_BREAK_TERMINATED_TRUE_PLAYER_BENTO("player.bento.adBreakTerminated(true)"),
        AD_ENABLE_DISABLEADGUI_STATE("EdgePlayer.getPlayer().bento.adStarted({disableAdGuiOnPlay: false, disableAdGui: true})"),
        AD_ENABLE_DISABLEADGUIONPLAY_STATE("EdgePlayer.getPlayer().bento.adStarted({disableAdGuiOnPlay: true, disableAdGui: false})"),
        GET_API_TIMING("return window.performance.now();"),
        SET_WRONG_BENTO("Bento.version=12345;"),
        SET_WRONG_ADS_PROFILEID("EdgePlayer.getPlayer().bento.adManifestRequest({profileId:1232343453},1);"),
        SET_INFO_LEVEL("EdgePlayer.log.setLevel(EdgePlayer.log.levels.INFO)"),
        SET_LANGUAGE("player.setLanguage(\"%s\")"),
        GET_READY_STATE("return document.readyState"),
        GET_TEXT_FROM_EMBED_TEXTAREA_FIELD("return document.getElementsByClassName('edge-share-modal-message')[0].value"),
        CLICK_BY_COORDINATES("document.elementFromPoint(%d, %d).click();");

        private String commandString;

        Commands(final String commandString){
            this.commandString = commandString;}

        public String getCommandString() {
            return commandString; }
        }
}
