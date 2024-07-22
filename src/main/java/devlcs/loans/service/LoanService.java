package devlcs.loans.service;

import devlcs.loans.controller.dto.CustomerLoanRequest;
import devlcs.loans.controller.dto.CustomerLoanResponse;
import devlcs.loans.controller.dto.LoanResponse;
import devlcs.loans.domain.Loan;
import devlcs.loans.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse chaeckLoanAvailability(CustomerLoanRequest loanRequest){

        var customer = loanRequest.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if(loan.isPersonalLoanAvailable()){
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }
        if(loan.isConsignmentAvailable()){
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }
        if(loan.isGuaranteedAvailable()){
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CustomerLoanResponse(loanRequest.name(), loans);
    }

}
