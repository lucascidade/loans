package devlcs.loans.controller;

import devlcs.loans.controller.dto.CustomerLoanRequest;
import devlcs.loans.controller.dto.CustomerLoanResponse;
import devlcs.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    private final LoanService loanService;
    public LoansController(final LoanService loanService) {
        this.loanService = loanService;
    }
    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@Valid @RequestBody CustomerLoanRequest loanRequest){

        var loanResponse = loanService.chaeckLoanAvailability(loanRequest);
        return ResponseEntity.ok(loanResponse);

    }
}
