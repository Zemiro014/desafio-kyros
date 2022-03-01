package kyros.desafio.jeronimo.factoryObject;

import kyros.desafio.jeronimo.beans.to.request.CreateProviderAddressRequestTO;
import kyros.desafio.jeronimo.beans.to.request.CreateProviderRequestTO;

public class BuildObject {

    public CreateProviderRequestTO createProviderRequestTO(){
        CreateProviderRequestTO requestTO = new CreateProviderRequestTO();
        requestTO.setProviderName("João José");
        requestTO.setProviderPhone("5196587421");
        requestTO.setCnpj("85043067000166");
        requestTO.setEmail("joao@gmail.com");
        CreateProviderAddressRequestTO addressRequestTO = new CreateProviderAddressRequestTO();
        addressRequestTO.setCep("93110008");
        addressRequestTO.setCity("São Leopoldo");
        addressRequestTO.setState("RS");
        addressRequestTO.setNumber("1055");
        requestTO.setProviderAddress(addressRequestTO);
        return requestTO;
    }
}
