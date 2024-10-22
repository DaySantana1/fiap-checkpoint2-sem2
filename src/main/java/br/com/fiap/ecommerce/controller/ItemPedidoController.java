package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.dtos.ItemPedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ItemPedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ItemPedidoResponseDto;
import br.com.fiap.ecommerce.mapper.ItemPedidoMapper;
import br.com.fiap.ecommerce.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemPedidos")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;
    private final ItemPedidoMapper itemPedidoMapper;

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> list() {
        List<ItemPedidoResponseDto> dtos = itemPedidoService.list()
            .stream()
            .map(itemPedidoMapper::toDto)
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> create(@RequestBody ItemPedidoRequestCreateDto dto) {        
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
                        itemPedidoMapper.toDto(
        					itemPedidoService.save(itemPedidoMapper.toModel(dto))
                        )
        			);
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody ItemPedidoRequestUpdateDto dto) {
        if (! itemPedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
                        itemPedidoMapper.toDto(
        				    itemPedidoService.save(itemPedidoMapper.toModel(id,dto))
                        )
        		);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! itemPedidoService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        itemPedidoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				itemPedidoService
    					.findById(id)
    					.map(itemPedidoMapper::toDto)
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);
    	  		     
    }

}
