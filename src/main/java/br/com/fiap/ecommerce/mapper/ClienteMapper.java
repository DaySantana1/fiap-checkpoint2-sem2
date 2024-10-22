package br.com.fiap.ecommerce.mapper;

import br.com.fiap.ecommerce.dtos.ClienteRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ClienteRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ClienteResponseDto;
import br.com.fiap.ecommerce.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteMapper {
    private final ModelMapper modelMapper;
    public ClienteResponseDto toDto(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseDto.class);
    }
    public Cliente toModel(ClienteRequestCreateDto dto) {
        return modelMapper.map(dto, Cliente.class);
    }

    public Cliente toModel(Long id, ClienteRequestUpdateDto dto) {
        Cliente result = modelMapper.map(dto, Cliente.class);
        result.setId(id);
        return result;
    }
}
