package devlcs.loans.controller.dto;

import devlcs.loans.domain.LoanType;

public record LoanResponse(LoanType type,
                           Double interestRate) {
}
