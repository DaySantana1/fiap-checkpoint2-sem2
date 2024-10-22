package br.com.fiap.ecommerce.service;

import br.com.fiap.ecommerce.model.ItemPedido;
import br.com.fiap.ecommerce.repository.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> list() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido save(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public boolean existsById(Long id) {
        return itemPedidoRepository.existsById(id);
    }

    public void delete(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public Optional<ItemPedido> findById(Long id) {
        return itemPedidoRepository.findById(id);
    }
}
