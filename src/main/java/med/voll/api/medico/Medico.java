package med.voll.api.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco()); //passa os dados de endereço pra JPA Endereco
    }

    public void atualizarInfo(@Valid DadosAtualizacaoMedico dados) {
        dados.nome().ifPresent(valorNome -> {
            if (valorNome.trim().isEmpty()) {
                throw new IllegalArgumentException("Campo 'nome' não pode ser enviado em branco.");
            }
            this.nome = valorNome;
        });

        dados.telefone().ifPresent(valorTelefone -> {
            if (valorTelefone.trim().isEmpty()) {
                throw new IllegalArgumentException("Campo 'telefone' não pode ser enviado em branco.");
            }
            this.telefone = telefone;
        });

        dados.endereco().ifPresent(valorEndereco -> { this.endereco.atualizarInfo(valorEndereco);});
    }

    public void excluir() {
        this.ativo = false;
    }
}
