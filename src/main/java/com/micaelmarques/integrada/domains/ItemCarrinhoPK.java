package com.micaelmarques.integrada.domains;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemCarrinhoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="carrinho_id")
	@Getter
	@Setter
	private Carrinho carrinho;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	@Getter
	@Setter
	private Produto produto;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrinho == null) ? 0 : carrinho.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemCarrinhoPK other = (ItemCarrinhoPK) obj;
		if (carrinho == null) {
			if (other.carrinho != null)
				return false;
		} else if (!carrinho.equals(other.carrinho))
			return false;
		if (produto == null) {
			return other.produto == null;
		} else return produto.equals(other.produto);
	}

}
