package com.micaelmarques.integrada.services;

import java.util.Optional;

import com.micaelmarques.integrada.repositories.CarrinhoRepository;
import com.micaelmarques.integrada.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.micaelmarques.integrada.domains.Carrinho;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository repo;
	
	public Carrinho buscar(Integer id) {
		Optional<Carrinho> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Carrinho.class.getName()));
	}


}
