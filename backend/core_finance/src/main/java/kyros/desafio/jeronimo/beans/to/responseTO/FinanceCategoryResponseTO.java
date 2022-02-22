package kyros.desafio.jeronimo.beans.to.responseTO;

import java.io.Serializable;

public class FinanceCategoryResponseTO implements Serializable {
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
