package br.com.fiap.ecommerce.controller;


import br.com.fiap.ecommerce.dtos.ClienteRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ClienteRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ClienteResponseDto;
import br.com.fiap.ecommerce.mapper.ClienteMapper;
import br.com.fiap.ecommerce.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> list() {
        List<ClienteResponseDto> dtos = clienteService.list()
            .stream()
            .map(clienteMapper::toDto)
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> create(@RequestBody ClienteRequestCreateDto dto) {        
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
                        clienteMapper.toDto(
        					clienteService.save(clienteMapper.toModel(dto))
                        )
        			);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody ClienteRequestUpdateDto dto) {
        if (! clienteService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
                        clienteMapper.toDto(
        				    clienteService.save(clienteMapper.toModel(id,dto))
                        )
        		);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! clienteService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        clienteService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				clienteService
    					.findById(id)
    					.map(clienteMapper::toDto)
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);
    	  		     
    }

}
