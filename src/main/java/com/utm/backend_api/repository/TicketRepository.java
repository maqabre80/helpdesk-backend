package com.utm.backend_api.repository;

import com.utm.backend_api.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio CRUD para tickets usando Spring Data MongoDB.
 * @author Fausto Damian Guano Loya
 */
@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {
}