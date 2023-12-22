package com.crud.cliente.controller;

import com.crud.cliente.dto.cliente.ClienteDTO;
import com.crud.cliente.dto.cliente.ClienteMapper;
import com.crud.cliente.service.cliente.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO salvarCliente(@Valid @RequestBody final ClienteDTO clienteDTO) {
        return mapper.toDTO(clienteService.salvarCliente(mapper.fromDTO(clienteDTO)));
    }
}
