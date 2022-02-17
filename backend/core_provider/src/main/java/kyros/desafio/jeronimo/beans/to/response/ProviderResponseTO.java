package kyros.desafio.jeronimo.beans.to.response;

import java.io.Serializable;

public class ProviderResponseTO implements Serializable {
    private String id;
    private String providerName;
    private String providerPhone;
    private String cnpjCpf;
    private String email;
    private AddressResponseTO providerAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressResponseTO getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(AddressResponseTO providerAddress) {
        this.providerAddress = providerAddress;
    }
}