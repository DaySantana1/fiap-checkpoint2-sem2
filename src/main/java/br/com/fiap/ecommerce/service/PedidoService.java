package br.com.fiap.ecommerce.service;

import br.com.fiap.ecommerce.model.Pedido;
import br.com.fiap.ecommerce.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> list() {
        return pedidoRepository.findAll();
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public boolean existsById(Long id) {
        return pedidoRepository.existsById(id);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }
}
