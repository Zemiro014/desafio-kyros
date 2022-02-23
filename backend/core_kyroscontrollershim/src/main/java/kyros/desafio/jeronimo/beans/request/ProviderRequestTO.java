package kyros.desafio.jeronimo.beans.request;

import java.io.Serializable;

public class ProviderRequestTO implements Serializable {
    private String providerName;
    private String providerPhone;
    private String cpf;
    private String cnpj;
    private String email;
    private AddressRequestTO providerAddress;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressRequestTO getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(AddressRequestTO providerAddress) {
        this.providerAddress = providerAddress;
    }
}
