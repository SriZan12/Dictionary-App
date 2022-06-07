package Models;

import com.google.gson.annotations.SerializedName;

public class Definitions {

    @SerializedName("definition")
    String definitions = "";

    @SerializedName("example")
    String example = "";

    public String getDefinitions() {
        return definitions;
    }

    public void setDefinitions(String definitions) {
        this.definitions = definitions;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
