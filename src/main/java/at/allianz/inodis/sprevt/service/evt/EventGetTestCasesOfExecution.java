package at.allianz.inodis.sprevt.service.evt;


import at.allianz.inodis.sprevt.db.Execution;
import at.allianz.inodis.sprevt.db.TestCase;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class EventGetTestCasesOfExecution {
    private final Execution execution;
    private List<TestCase> testCases;
}
