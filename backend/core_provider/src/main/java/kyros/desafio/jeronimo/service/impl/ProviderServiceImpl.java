package kyros.desafio.jeronimo.service.impl;

import com.google.common.base.Strings;
import kyros.desafio.jeronimo.beans.to.request.CreateProviderRequestTO;
import kyros.desafio.jeronimo.beans.to.response.AddressResponseTO;
import kyros.desafio.jeronimo.beans.to.response.ProviderResponseTO;
import kyros.desafio.jeronimo.constants.ProviderExceptionConstants;
import kyros.desafio.jeronimo.dao.api.postgres.ProviderPostgresDaoApi;
import kyros.desafio.jeronimo.entities.Address;
import kyros.desafio.jeronimo.entities.Provider;
import kyros.desafio.jeronimo.exception.custom.ProviderException;
import kyros.desafio.jeronimo.service.api.ProviderServiceApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProviderServiceImpl implements ProviderServiceApi {

    @Inject
    private ProviderPostgresDaoApi dao;

    @Override
    public void createProvider(CreateProviderRequestTO to) throws ProviderException {
        Provider entity = convertRequestToEntity(to);
        if(Strings.isNullOrEmpty(entity.getId()))
            entity.setId(UUID.randomUUID().toString());
        dao.create(entity);
    }

    @Override
    public List<ProviderResponseTO> findAllProviders() {
        List<Provider> providers = dao.findAll();
        return  providers.stream().map(this::convertEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public ProviderResponseTO findProviderById(String id) throws ProviderException {
        Provider provider = dao.findById(id);
        if (provider == null)
            throw new ProviderException(ProviderExceptionConstants.ERROR_CODE_PROVIDER_NOT_FOUND, id);
        return convertEntityToResponse(provider);
    }

    private Provider convertRequestToEntity(CreateProviderRequestTO to) throws ProviderException {
        Provider entity = new Provider();
        entity.setProviderName(to.getProviderName());
        entity.setProviderPhone(to.getProviderPhone());
        entity.setEmail(to.getEmail());
        entity.setCnpjCpf(setCnpjCPF(to.getCpf(), to.getCnpj()));
        Address address = new Address();
        address.setCep(to.getProviderAddress().getCep());
        address.setCity(to.getProviderAddress().getCity());
        address.setNumber(to.getProviderAddress().getNumber());
        address.setState(to.getProviderAddress().getState());
        address.setStreet(to.getProviderAddress().getStreet());
        entity.setProviderAddress(address);
        return entity;
    }
    private ProviderResponseTO convertEntityToResponse(Provider entity){
        ProviderResponseTO responseTO = new ProviderResponseTO();
        responseTO.setProviderName(entity.getProviderName());
        responseTO.setProviderPhone(entity.getProviderPhone());
        responseTO.setEmail(entity.getEmail());
        responseTO.setCnpjCpf(entity.getCnpjCpf());
        AddressResponseTO address = new AddressResponseTO();
        address.setCep(entity.getProviderAddress().getCep());
        address.setCity(entity.getProviderAddress().getCity());
        address.setNumber(entity.getProviderAddress().getNumber());
        address.setState(entity.getProviderAddress().getState());
        address.setStreet(entity.getProviderAddress().getStreet());
        responseTO.setProviderAddress(address);
        return responseTO;
    }

    private String setCnpjCPF(String cpf, String cnpj) throws ProviderException {
        if(Strings.isNullOrEmpty(cpf) && Strings.isNullOrEmpty(cnpj))
            throw new ProviderException(ProviderExceptionConstants.ERROR_CODE_PROVIDER_CNPJ_OR_CPF_REQUIRED);
        if(!Strings.isNullOrEmpty(cpf) && !Strings.isNullOrEmpty(cnpj))
            throw new ProviderException(ProviderExceptionConstants.ERROR_CODE_PROVIDER_INFORM_CNPJ_OR_CPF, cpf, cnpj);
        if(Strings.isNullOrEmpty(cnpj))
            return cpf;
        else
            return cnpj;
    }
}