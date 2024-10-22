package br.com.fiap.ecommerce.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Data
public class ProdutoResponseDto {

    private Long id;
	private String nome;
	private BigDecimal valor;

}
