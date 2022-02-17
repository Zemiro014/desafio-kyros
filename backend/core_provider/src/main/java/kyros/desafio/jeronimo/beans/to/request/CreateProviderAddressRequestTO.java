package kyros.desafio.jeronimo.beans.to.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateProviderAddressRequestTO implements Serializable {
    @NotEmpty @NotNull
    private String street;
    @NotEmpty @NotNull
    private String cep;
    @NotEmpty @NotNull
    private String number;
    @NotEmpty @NotNull
    private String state;
    @NotEmpty @NotNull
    private String city;

    @Schema(description = "Rua do fornecedor", required = true, example = "Rua Osvaldo Aranha")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Schema(description = "CEP do fornecedor", required = true, example = "93110008")
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Schema(description = "Number da residência ou instituição do fornecedor", required = true, example = "1055")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Schema(description = "Estado do fornecedor", required = true, example = "RS")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Schema(description = "Cidade do fornecedor", required = true, example = "São Leopoldo")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}