package com.micaelmarques.integrada.controller;

import com.micaelmarques.integrada.dell.ResponseDell;
import com.micaelmarques.integrada.domains.Produto;
import com.micaelmarques.integrada.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {
    private final ProdutoRepository acoes;

    public ProdutoController(ProdutoRepository acoes) {
        this.acoes = acoes;
    }

    //     Listar Produtos
    @GetMapping(value = "/produto")
    public List<Produto> listar() {
        return acoes.findAll();
    }

    //    cadastrar produtos
    @PostMapping(value = "/produto")
    public @ResponseBody Produto cadastrar(@RequestBody Produto produto){
        return acoes.save(produto);
    }

    //filtrar produtos
    @GetMapping(value = "/produto/{codigo}")
    public Produto filtrar(@PathVariable Integer codigo) {
        return acoes.findById(codigo)
                .orElseThrow(()->new RuntimeException("Produto não encontrado"));
    }

    //alterar produtos
    @PutMapping(value = "/produto")
    public Produto alterar(@RequestBody Produto p) {
        return acoes.save(p);
    }

    //deletar produtos
    @DeleteMapping(value = "/produto/{codigo}")
    public @ResponseBody ResponseDell deletar(@PathVariable Integer codigo) {
        ResponseDell response = new ResponseDell();
        try {
            Produto p = filtrar(codigo);
            acoes.delete(p);
            response.setMensage("Usuario removido com sucesso");
        } catch (Exception erro) {
            response.setMensage("Erro!!!!! Falha ao remover: " + erro.getMessage());
        }
        return response;
    }
}
