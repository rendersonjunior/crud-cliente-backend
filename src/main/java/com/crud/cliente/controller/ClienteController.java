package com.crud.cliente.controller;

import com.crud.cliente.dto.cliente.ClienteDTO;
import com.crud.cliente.dto.cliente.ClienteMapper;
import com.crud.cliente.service.clienteService.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final IClienteService clienteService;
    private final ClienteMapper mapper;

    public ClienteController(IClienteService clienteService, ClienteMapper mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ClienteDTO> buscarTodosClientes() {
        return clienteService.buscarTodosClientes()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ClienteDTO salvarCliente(@RequestBody @Valid final ClienteDTO clienteDTO) throws Exception{
        return mapper.toDTO(clienteService.salvarCliente(mapper.fromDTO(clienteDTO)));
    }
}
