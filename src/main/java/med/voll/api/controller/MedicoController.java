package med.voll.api.controller;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos") //URL Requisitada da API
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    //Requisição via POST
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) { //dto
        repository.save(new Medico(dados)); //Conversão de DTO para tipo Medico
    }
}
