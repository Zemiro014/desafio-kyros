package kyros.desafio.jeronimo.beans.to.requestTO;

import java.io.Serializable;

public class FinanceCategoryRequestTO implements Serializable {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
