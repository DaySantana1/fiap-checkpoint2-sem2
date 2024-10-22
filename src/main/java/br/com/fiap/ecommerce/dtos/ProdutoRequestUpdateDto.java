package br.com.fiap.ecommerce.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProdutoRequestUpdateDto {

	private String nome;
	private BigDecimal valor;

}
