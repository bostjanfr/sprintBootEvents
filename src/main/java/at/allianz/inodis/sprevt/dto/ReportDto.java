package at.allianz.inodis.sprevt.dto;

import at.allianz.inodis.sprevt.db.Execution;
import at.allianz.inodis.sprevt.db.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ReportDto {
    private final String externalId;
    private final List<Tc> testCases;

    public ReportDto() {
        externalId ="";
        testCases = new ArrayList<>();
    }

    public ReportDto(final Execution exec, final List<TestCase> list) {
        externalId = exec.getExternalId();
         testCases = list.stream().map(Tc::build).collect(Collectors.toList());
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tc{

        private String name;
        private String result;

        public static Tc build(final TestCase tc){
            return new Tc(tc.getName(), tc.getResult());
        }
    }
}
