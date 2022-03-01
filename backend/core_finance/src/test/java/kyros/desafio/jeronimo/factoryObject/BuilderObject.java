package kyros.desafio.jeronimo.factoryObject;

import kyros.desafio.jeronimo.beans.to.requestTO.FinanceCategoryRequestTO;
import kyros.desafio.jeronimo.beans.to.requestTO.FinanceRequestTO;

public class BuilderObject {
    public FinanceCategoryRequestTO createCategoryObject(){
        FinanceCategoryRequestTO categoryRequestTO = new FinanceCategoryRequestTO();
        categoryRequestTO.setCategory("Viagem");
        return categoryRequestTO;
    }

    public FinanceRequestTO createFinance(){
        FinanceRequestTO finance = new FinanceRequestTO();
        FinanceCategoryRequestTO categoryRequestTO = new FinanceCategoryRequestTO();
        categoryRequestTO.setId("03829942-93cc-11ec-8c37-9b8d38e3f462");
        categoryRequestTO.setCategory("Estudos");
        finance.setCategory(categoryRequestTO);
        finance.setFinanceType("Despesa");
        finance.setDescription("Pagamento de mensalidade");
        finance.setDueData("20/02/2022");
        finance.setStatus("Pago");
        finance.setValue("2000.00");
        finance.setPaymentData("16/02/2022");
        return finance;
    }
}
