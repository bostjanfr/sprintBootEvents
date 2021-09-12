package at.allianz.inodis.sprevt.db.repos;

import at.allianz.inodis.sprevt.db.Execution;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExecutionRepo extends CrudRepository <Execution, Long> {
    Optional<Execution> findByExternalId(final String extId);
}
