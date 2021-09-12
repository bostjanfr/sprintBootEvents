package at.allianz.inodis.sprevt.service;


import at.allianz.inodis.sprevt.db.Execution;
import at.allianz.inodis.sprevt.db.TestCase;
import at.allianz.inodis.sprevt.db.repos.ExecutionRepo;
import at.allianz.inodis.sprevt.dto.ReportDto;
import at.allianz.inodis.sprevt.service.evt.EventExecution;
import at.allianz.inodis.sprevt.service.evt.EventGetTestCasesOfExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExecutionService {

    private final ExecutionRepo executionRepo;

    private final TestCaseService testCaseService;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Execution createExec(String externalId, boolean notify){
        Execution execution = new Execution();
        execution.setExternalId(externalId);

        if (notify) {
            applicationEventPublisher.publishEvent(new EventExecution(externalId));
        }
        return executionRepo.save(execution);
    }

    public ReportDto getReport(String externalId){
        final Execution execution = executionRepo.findByExternalId(externalId)
                .orElseThrow(() -> new RuntimeException(String.format("Not found: %s", externalId)));

        final List<TestCase> testCases = testCaseService.getTestCases(execution);
        return  new ReportDto(execution, testCases);
    }

    public ReportDto getReport2(String externalId){
        final Execution execution = executionRepo.findByExternalId(externalId)
                .orElseThrow(() -> new RuntimeException(String.format("Not found: %s", externalId)));

        final EventGetTestCasesOfExecution eventGetTestCasesOfExecution = new EventGetTestCasesOfExecution(execution);
        applicationEventPublisher.publishEvent(eventGetTestCasesOfExecution);
        return new ReportDto(execution, eventGetTestCasesOfExecution.getTestCases());
    }



}
