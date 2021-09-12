package at.allianz.inodis.sprevt.init;

import at.allianz.inodis.sprevt.db.Execution;
import at.allianz.inodis.sprevt.service.ExecutionService;
import at.allianz.inodis.sprevt.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class FillDb {

    private final ExecutionService executionService;
    private final TestCaseService testCaseService;

    @PostConstruct
    @Transactional
    protected void onStartup(){
        final Execution one = executionService.createExec("one", false);
        testCaseService.createTestCase(one, " TC1", "success");
        testCaseService.createTestCase(one, " TC2", "fail");
    }
}
