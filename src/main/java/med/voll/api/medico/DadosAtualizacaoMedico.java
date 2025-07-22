package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

import java.util.Optional;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        Optional<String> nome,
        Optional<String> telefone,
        Optional<DadosEndereco> endereco
) {
}
