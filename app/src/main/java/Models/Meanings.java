package Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Meanings {

    @SerializedName("partOfSpeech")
    String partOfSpeech = "";

    @SerializedName("definitions")
    List<Definitions> definitionsList = new ArrayList<>();

    @SerializedName("synonyms")
    List<String> synonymsList = new ArrayList<>();

    @SerializedName("antonyms")
    List<String> antonymsList = new ArrayList<>();


    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Definitions> getDefinitionsList() {
        return definitionsList;
    }

    public void setDefinitionsList(List<Definitions> definitionsList) {
        this.definitionsList = definitionsList;
    }

    public List<String> getSynonymsList() {
        return synonymsList;
    }

    public void setSynonymsList(List<String> synonymsList) {
        this.synonymsList = synonymsList;
    }

    public List<String> getAntonymsList() {
        return antonymsList;
    }

    public void setAntonymsList(List<String> antonymsList) {
        this.antonymsList = antonymsList;
    }
}
