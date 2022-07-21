package com.micaelmarques.integrada.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String nome;
	@Getter
	@Setter
	private Double preco;

	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemCarrinho> itens = new HashSet<>();

	@Getter
	@Setter
	private Integer estoque;

	public Produto() {

	}

	public Produto(Integer id, String nome, Double preco, Integer estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	@JsonIgnore
	public List<Carrinho> getCarrinhos(){
		List<Carrinho> lista = new ArrayList<>();
		
		for(ItemCarrinho x : itens) {
			lista.add(x.getId().getCarrinho());
		}
		return lista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}

}
