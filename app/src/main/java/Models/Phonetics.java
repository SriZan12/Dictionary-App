package Models;

import com.google.gson.annotations.SerializedName;

public class Phonetics {

    @SerializedName("audio")
    String audio;

    public String getAudioUrl() {
        return audio;
    }

    public void setAudioUrl(String audio) {
        this.audio = audio;
    }
}
