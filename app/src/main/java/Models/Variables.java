package Models;

import java.util.List;

public class Variables {
    String partOfSpeech;
    String Definition;
    List<String> synonyms;
    List<String> antonyms;
    String searchedWord;
    String text;

    public Variables(String partOfSpeech, String definition,   List<String> synonyms ,List<String> antonyms,String searchedWord,String text) {
        this.partOfSpeech = partOfSpeech;
        Definition = definition;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
        this.searchedWord = searchedWord;
        this.text = text;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getDefinition() {
        return Definition;
    }

    public void setDefinition(String definition) {
        Definition = definition;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }

    public String getSearchedWord() {
        return searchedWord;
    }

    public void setSearchedWord(String searchedWord) {
        this.searchedWord = searchedWord;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
