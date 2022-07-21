package com.micaelmarques.integrada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.micaelmarques.integrada.domains.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {

}
