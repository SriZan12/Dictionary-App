package Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MainDetails {

    @SerializedName("word")
    String word = "";

    @SerializedName("phonetic")
    String phonetic = "";

    @SerializedName("phonetics")
    List<Phonetics> audio = new ArrayList<>();

    @SerializedName("meanings")
    List<Meanings> meaningsList = new ArrayList<>();

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public List<Phonetics> getAudio() {
        return audio;
    }

    public void setAudio(List<Phonetics> audio) {
        this.audio = audio;
    }

    public List<Meanings> getMeaningsList() {
        return meaningsList;
    }

    public void setMeaningsList(List<Meanings> meaningsList) {
        this.meaningsList = meaningsList;
    }
}
