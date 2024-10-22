package br.com.fiap.ecommerce.mapper;

import br.com.fiap.ecommerce.dtos.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ProdutoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ProdutoResponseDto;
import br.com.fiap.ecommerce.model.Produto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {    
    
    private final ModelMapper modelMapper;

    public ProdutoResponseDto toDto(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDto.class);
    }

    public Produto toModel(ProdutoRequestCreateDto dto) {
        return modelMapper.map(dto, Produto.class);
    }

    public Produto toModel(Long id, ProdutoRequestUpdateDto dto) {
        Produto result = modelMapper.map(dto, Produto.class);
        result.setId(id);
        return result;
    }   

}
