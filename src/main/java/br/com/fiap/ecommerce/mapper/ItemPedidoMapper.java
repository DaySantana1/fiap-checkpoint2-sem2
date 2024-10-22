package br.com.fiap.ecommerce.mapper;


import br.com.fiap.ecommerce.dtos.ItemPedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ItemPedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ItemPedidoResponseDto;
import br.com.fiap.ecommerce.model.ItemPedido;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemPedidoMapper {
    private final ModelMapper modelMapper;
    public ItemPedidoResponseDto toDto(ItemPedido itemPedido) {
        return modelMapper.map(itemPedido, ItemPedidoResponseDto.class);
    }
    public ItemPedido toModel(ItemPedidoRequestCreateDto dto) {
        return modelMapper.map(dto, ItemPedido.class);
    }

    public ItemPedido toModel(Long id, ItemPedidoRequestUpdateDto dto) {
        ItemPedido result = modelMapper.map(dto, ItemPedido.class);
        result.setId(id);
        return result;
    }
}
