package br.com.fiap.ecommerce.mapper;

import br.com.fiap.ecommerce.dtos.PedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.PedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.PedidoResponseDto;
import br.com.fiap.ecommerce.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoMapper {
    private final ModelMapper modelMapper;
    public PedidoResponseDto toDto(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResponseDto.class);
    }
    public Pedido toModel(PedidoRequestCreateDto dto) {
        return modelMapper.map(dto, Pedido.class);
    }

    public Pedido toModel(Long id, PedidoRequestUpdateDto dto) {
        Pedido result = modelMapper.map(dto, Pedido.class);
        result.setId(id);
        return result;
    }

}
