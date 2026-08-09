package com.utm.backend_api.controller;

import com.utm.backend_api.model.Ticket;
import com.utm.backend_api.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketRepository repo;

    @GetMapping
    public List<Ticket> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getById(@PathVariable String id) {
        Optional<Ticket> ticket = repo.findById(id);
        return ticket.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
        Ticket saved = repo.save(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> update(@PathVariable String id,
                                          @RequestBody Ticket datos) {
        Optional<Ticket> existing = repo.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Ticket ticket = existing.get();
        if (datos.getTitulo()      != null) ticket.setTitulo(datos.getTitulo());
        if (datos.getDescripcion() != null) ticket.setDescripcion(datos.getDescripcion());
        if (datos.getCategoria()   != null) ticket.setCategoria(datos.getCategoria());
        if (datos.getPrioridad()   != null) ticket.setPrioridad(datos.getPrioridad());
        if (datos.getEstado()      != null) ticket.setEstado(datos.getEstado());
        if (datos.getTecnico()     != null) ticket.setTecnico(datos.getTecnico());
        return ResponseEntity.ok(repo.save(ticket));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.ok("Ticket eliminado correctamente");
    }
}