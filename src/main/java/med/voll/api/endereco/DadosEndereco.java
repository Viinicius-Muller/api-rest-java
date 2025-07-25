package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        @NotBlank
        @Pattern(regexp = "\\d{8}") //regular-expresion = 8 digits
        String cep,
        @NotBlank
        String bairro,
        String numero,
        String complemento) {
}
