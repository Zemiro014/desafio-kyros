package kyros.desafio.jeronimo.beans.to.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateProviderRequestTO implements Serializable {

    @NotEmpty @NotNull
    private String providerName;
    @NotEmpty @NotNull
    private String providerPhone;
    @CPF
    private String cpf;
    @CNPJ
    private String cnpj;

    @NotEmpty @NotNull @Email
    private String email;
    private CreateProviderAddressRequestTO providerAddress;


    @Schema(description = "Nome do fornecedor", required = true, example = "João José")
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Schema(description = "contato do fornecedor", required = true, example = "5196587421")
    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    @Schema(description = "cpf do fornecedor em caso de ele for um PF", example = "70434586099")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Schema(description = "cnpj do fornecedor em caso de ele for um PJ", example = "85043067000166")
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

    public CreateProviderAddressRequestTO getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(CreateProviderAddressRequestTO providerAddress) {
        this.providerAddress = providerAddress;
    }
}