package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicos") //URL Requisitada da API
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    //Requisição via POST
    @PostMapping
    @Transactional //Transação em um banco de dados
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) { //dto
        repository.save(new Medico(dados)); //Conversão de DTO para tipo Medico
    }

    //Retorna todos os médicos do DB
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) { //Pageable -> Spring
        //Converter Medicos para DadosListagemMedico
        return repository.findAll(paginacao).map(DadosListagemMedico::new); //Page
    }
}
