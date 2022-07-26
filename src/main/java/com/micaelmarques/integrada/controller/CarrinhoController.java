package com.micaelmarques.integrada.controller;

import com.micaelmarques.integrada.dell.ResponseDell;
import com.micaelmarques.integrada.domains.Carrinho;
import com.micaelmarques.integrada.repositories.CarrinhoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarrinhoController {
    private final CarrinhoRepository acoes;

    public CarrinhoController(CarrinhoRepository acoes) {
        this.acoes = acoes;
    }

    // Listar Produtos
    @GetMapping(value = "/carrinho")
    public @ResponseBody List<Carrinho> listar(){
        return acoes.findAll();
    }

    //cadastrar produtos
    @PostMapping(value = "/carrinho")
    public @ResponseBody Carrinho cadastrar(@RequestBody Carrinho carrinho){
        return acoes.save(carrinho);
    }

    //filtrar produtos
    @GetMapping(value = "/carrinho/{codigo}")
    public @ResponseBody Carrinho filtrar(@PathVariable Integer codigo){
        return acoes.findById(codigo).
                orElseThrow(()->new RuntimeException("Carrinho de compras não encontrado"));
    }

    //alterar produtos
    @PutMapping(value = "/carrinho")
    public @ResponseBody Carrinho alterar(@RequestBody Carrinho carrinho){
        return acoes.save(carrinho);
    }

    //deletar produtos
    @DeleteMapping(value = "/carrinho/{codigo}")
    public @ResponseBody ResponseDell deletar(@PathVariable Integer codigo){
        ResponseDell response = new ResponseDell();
        try{
            Carrinho carrinho = filtrar(codigo);
            acoes.delete(carrinho);
            response.setMensage("Carrinho removido com sucesso");
        } catch (Exception erro){
            response.setMensage("Erro!!!!! Falha ao remover: " + erro.getMessage());
        }
        return response;
    }
}
