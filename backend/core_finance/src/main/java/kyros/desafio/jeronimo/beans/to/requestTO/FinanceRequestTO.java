package kyros.desafio.jeronimo.beans.to.requestTO;

import java.io.Serializable;

public class FinanceRequestTO implements Serializable {
    private String description;
    private String financeType;
    private String value;
    private String status;
    private String dueData;
    private String paymentData;
    private FinanceCategoryRequestTO category;

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

    public FinanceCategoryRequestTO getCategory() {
        return category;
    }

    public void setCategory(FinanceCategoryRequestTO category) {
        this.category = category;
    }
}