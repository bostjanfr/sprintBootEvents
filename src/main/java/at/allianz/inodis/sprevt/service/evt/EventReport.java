package at.allianz.inodis.sprevt.service.evt;


import at.allianz.inodis.sprevt.db.Execution;
import at.allianz.inodis.sprevt.dto.ReportDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EventReport {
    private final ReportDto reportDto;
}
