package kyros.desafio.jeronimo.beans.response;

import java.io.Serializable;

public class CategoryResponseTO implements Serializable {
    private String id;
    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}