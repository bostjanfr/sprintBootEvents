package at.allianz.inodis.sprevt.service;

import at.allianz.inodis.sprevt.service.evt.EventExecution;
import at.allianz.inodis.sprevt.service.evt.EventGetTestCasesOfExecution;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class MailService {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleEventExecution(EventExecution event) {
        System.out.println("Send Email about execution  "+  event.getExecId() );
    }

    @EventListener
    public void handleGetTestCases(EventGetTestCasesOfExecution cse) {
        System.out.println("Get TestCases "+  cse.getExecution().getExternalId() );
    }
}
