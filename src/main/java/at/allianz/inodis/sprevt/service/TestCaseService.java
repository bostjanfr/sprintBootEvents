package at.allianz.inodis.sprevt.service;


import at.allianz.inodis.sprevt.db.Execution;
import at.allianz.inodis.sprevt.db.TestCase;
import at.allianz.inodis.sprevt.db.repos.TestCaseRepo;
import at.allianz.inodis.sprevt.service.evt.EventGetTestCasesOfExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseService {

    private final TestCaseRepo testCaseRepo;

    @Transactional
    public TestCase createTestCase(final Execution execution,  final String name,  final String result ){
        final TestCase tc = new TestCase();
        tc.setExecution(execution);
        tc.setName(name);
        tc.setResult(result);
        return testCaseRepo.save(tc);
    }

    public List<TestCase> getTestCases(final Execution exec){
        return testCaseRepo.findByExecution(exec);
    }

    @EventListener
    public void handleGetTestCases(EventGetTestCasesOfExecution cse) {
        cse.setTestCases(getTestCases(cse.getExecution()));
    }
}
