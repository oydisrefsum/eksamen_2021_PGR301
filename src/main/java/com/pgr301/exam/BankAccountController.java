package com.pgr301.exam;

import com.pgr301.exam.model.Account;
import com.pgr301.exam.model.Transaction;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static java.util.Optional.ofNullable;

@RestController
public class BankAccountController implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private MeterRegistry meterRegistry;

    @Autowired
    private BankingCoreSystmeService bankService;

    @Autowired
    public BankAccountController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostMapping(path = "/account/{fromAccount}/transfer/{toAccount}", consumes = "application/json", produces = "application/json")
    @Timed(value = "account.transfer", longTask = true)
    public void transfer(@RequestBody Transaction tx, @PathVariable String fromAccount, @PathVariable String toAccount) {
        meterRegistry.counter("transfer", "amount", String.valueOf(tx.getAmount()) ).increment();
        bankService.transfer(tx, fromAccount, toAccount);
    }

    @PostMapping(path = "/account", consumes = "application/json", produces = "application/json")
    @Timed(value = "account.up", longTask = true)
    public ResponseEntity<Account> updateAccount(@RequestBody Account a) {
        meterRegistry.counter("update_account").increment();
        bankService.updateAccount(a);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping(path = "/account/{accountId}", consumes = "application/json", produces = "application/json")
    @Timed(value = "account.id", longTask = true)
    public ResponseEntity<Account> balance(@PathVariable String accountId) {
        meterRegistry.counter("balance").increment();
        Account account = ofNullable(bankService.getAccount(accountId)).orElseThrow(AccountNotFoundException::new);
        System.out.println(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "video not found")
    public static class AccountNotFoundException extends RuntimeException {
    }
}

