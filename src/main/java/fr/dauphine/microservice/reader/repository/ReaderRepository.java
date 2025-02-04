package fr.dauphine.microservice.reader.repository;

import fr.dauphine.microservice.reader.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}
