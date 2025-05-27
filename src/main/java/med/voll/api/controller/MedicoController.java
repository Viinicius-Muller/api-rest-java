package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos") //URL Requisitada da API
public class MedicoController {

    //Requisição via POST
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) { //o parametro é o "corpo da requisição"
        System.out.println(dados);
    }
}
