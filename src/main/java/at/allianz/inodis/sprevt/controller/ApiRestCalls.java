package at.allianz.inodis.sprevt.controller;

import at.allianz.inodis.sprevt.db.Execution;
import at.allianz.inodis.sprevt.dto.ReportDto;
import at.allianz.inodis.sprevt.service.ExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiRestCalls {

    private final ExecutionService executionService;


    @GetMapping("hello")
    public  String hello(){
        return "hello back";
    }

    @GetMapping("report/{extId}")
    public ReportDto report(@PathVariable(name = "extId") String extId){
        return executionService.getReport(extId);
    }

    @GetMapping("report2/{extId}")
    public ReportDto report2(@PathVariable(name = "extId") String extId){
        return executionService.getReport2(extId);
    }

    @PostMapping("execution/{extId}")
    public Execution createExecution(@PathVariable(name = "extId") String extId){
        return executionService.createExec(extId, true);
    }
}

