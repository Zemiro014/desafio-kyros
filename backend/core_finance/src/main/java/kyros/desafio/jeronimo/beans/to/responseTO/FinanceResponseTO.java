package kyros.desafio.jeronimo.beans.to.responseTO;

import java.io.Serializable;

public class FinanceResponseTO implements Serializable {

    private String id;
    private String description;
    private String financeType;
    private String value;
    private String status;
    private String dueData;
    private String paymentData;
    private FinanceCategoryResponseTO category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFinanceType() {
        return financeType;
    }

    public void setFinanceType(String financeType) {
        this.financeType = financeType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDueData() {
        return dueData;
    }

    public void setDueData(String dueData) {
        this.dueData = dueData;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public FinanceCategoryResponseTO getCategory() {
        return category;
    }

    public void setCategory(FinanceCategoryResponseTO category) {
        this.category = category;
    }
}
