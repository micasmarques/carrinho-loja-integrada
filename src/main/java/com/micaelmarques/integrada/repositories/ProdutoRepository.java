package com.micaelmarques.integrada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.micaelmarques.integrada.domains.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
