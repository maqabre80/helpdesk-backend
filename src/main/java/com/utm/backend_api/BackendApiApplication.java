package com.utm.backend_api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.utm.backend_api.model.Ticket;
import com.utm.backend_api.repository.TicketRepository;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BackendApiApplication {

    @Autowired
    private TicketRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(BackendApiApplication.class, args);
    }

    @Bean
    public Filter corsFilter() {
        return new Filter() {
            @Override
            public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                    throws IOException, ServletException {
                HttpServletResponse response = (HttpServletResponse) res;
                HttpServletRequest request = (HttpServletRequest) req;
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
                response.setHeader("Access-Control-Allow-Headers", "*");
                if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                    response.setStatus(HttpServletResponse.SC_OK);
                } else {
                    chain.doFilter(req, res);
                }
            }
        };
    }

    @GetMapping("/")
    public String home() {
        return "Help Desk API corriendo correctamente";
    }

    @GetMapping("/api/tickets")
    public List<Ticket> getAll() {
        return repo.findAll();
    }

    @PostMapping("/api/tickets")
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(ticket));
    }

    @PutMapping("/api/tickets/{id}")
    public ResponseEntity<Ticket> update(@PathVariable String id, @RequestBody Ticket datos) {
        Optional<Ticket> existing = repo.findById(id);
        if (existing.isEmpty()) return ResponseEntity.notFound().build();
        Ticket t = existing.get();
        if (datos.getEstado()  != null) t.setEstado(datos.getEstado());
        if (datos.getTecnico() != null) t.setTecnico(datos.getTecnico());
        if (datos.getTitulo()  != null) t.setTitulo(datos.getTitulo());
        if (datos.getDescripcion() != null) t.setDescripcion(datos.getDescripcion());
        if (datos.getCategoria()   != null) t.setCategoria(datos.getCategoria());
        if (datos.getPrioridad()   != null) t.setPrioridad(datos.getPrioridad());
        return ResponseEntity.ok(repo.save(t));
    }

    @DeleteMapping("/api/tickets/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.ok("Ticket eliminado correctamente");
    }
}