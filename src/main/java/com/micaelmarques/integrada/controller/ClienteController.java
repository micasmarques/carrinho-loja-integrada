package com.micaelmarques.integrada.controller;

import com.micaelmarques.integrada.dell.ResponseDell;
import com.micaelmarques.integrada.domains.Cliente;
import com.micaelmarques.integrada.repositories.ClienteRepository;
import com.micaelmarques.integrada.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private final ClienteRepository acoes;
    @Autowired
    private final ClienteService clienteService;

    public ClienteController(ClienteRepository acoes, ClienteService usuarioService) {
        this.acoes = acoes;
        this.clienteService = usuarioService;
    }

    //     Listar Produtos
    @GetMapping("/cliente")
    public List<Cliente> listar() {
        return acoes.findAll();
    }

    //    cadastrar produtos
    @PostMapping("/cliente")
    public Cliente cadastrar(@RequestBody Cliente c){
        return acoes.save(c);
    }

    //filtrar produtos
    @GetMapping("/cliente/{codigo}")
    public Cliente filtrar(@PathVariable Integer codigo) {
        return acoes.findById(codigo)
                .orElseThrow(()->new RuntimeException("Usuario não encontrado"));
    }

    //alterar produtos
    @PutMapping("/cliente")
    public Cliente alterar(@RequestBody Cliente c) {
        return acoes.save(c);
    }

    //deletar produtos
    @DeleteMapping("/cliente/{codigo}")
    public @ResponseBody ResponseDell deletar(@PathVariable Integer codigo) {
        ResponseDell response = new ResponseDell();
        try {
            Cliente c = filtrar(codigo);
            acoes.delete(c);
            response.setMensage("cliente removido com sucesso");
        } catch (Exception erro) {
            response.setMensage("Erro!!!!! Falha ao remover: " + erro.getMessage());
        }
        return response;
    }
}
