package com.micaelmarques.integrada.domains;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ItemCarrinho implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	@Getter
	@Setter
	private ItemCarrinhoPK id = new ItemCarrinhoPK();
	@Getter
	@Setter
	private Integer quantidade;
	@Getter
	@Setter
	private Double preco;

	public ItemCarrinho() {

	}

	public ItemCarrinho(Carrinho carrinho, Produto produto, Integer quantidade, Double preco) {
		super();
		this.id.setCarrinho(carrinho);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
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
		ItemCarrinho other = (ItemCarrinho) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}

}
