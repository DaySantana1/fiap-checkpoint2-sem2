package br.com.fiap.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    private Long idPedido;
    private Long idProduto;

    @Column(precision = 16, scale = 2)
    private BigDecimal quantidade;

    @Column(precision = 16, scale = 2)
    private BigDecimal valorTotal;


}
