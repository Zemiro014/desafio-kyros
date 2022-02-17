package kyros.desafio.jeronimo.entities;

import javax.persistence.*;

@Entity
@Table(name = "provider_tb")
public class Provider {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String providerName;
    private String providerPhone;
    private String cnpjCpf;
    private String email;
    @OneToOne
    @JoinColumn(name = "provider_address_id")
    private Address providerAddress;

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

    public Address getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(Address providerAddress) {
        this.providerAddress = providerAddress;
    }
}
