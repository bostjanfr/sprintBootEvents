package at.allianz.inodis.sprevt.db.repos;

import at.allianz.inodis.sprevt.db.Execution;
import at.allianz.inodis.sprevt.db.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestCaseRepo extends JpaRepository<TestCase, Long> {
    List<TestCase> findByExecution(final Execution exec);
}
