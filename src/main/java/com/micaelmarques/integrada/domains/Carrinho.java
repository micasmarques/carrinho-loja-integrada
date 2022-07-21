package com.micaelmarques.integrada.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Carrinho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@Getter
	@Setter
	private Cliente cliente;


	@OneToMany(mappedBy="id.carrinho")
	@Getter
	@Setter
	private Set<ItemCarrinho> itens = new HashSet<>();
	
	public Carrinho() {

	}

	public Carrinho(Integer id, Cliente cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
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
		Carrinho other = (Carrinho) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}

}
