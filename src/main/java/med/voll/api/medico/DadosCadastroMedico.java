package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank //Checks if null or empty
        String nome,
        @NotBlank
        @Email //Validates Email
        String email,

        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //Validates if value is between 4 and 6 chars
        String crm,
        @NotNull //Spring alr validates if is Enum, but this confirms that it's not null
        Especialidade especialidade,

        @NotNull @Valid DadosEndereco endereco) { //Needs DadosEndereco to be valid
}
