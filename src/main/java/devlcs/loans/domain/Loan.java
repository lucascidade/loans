package devlcs.loans.domain;

public class Loan {
    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        return basicLoanAvailable();
    }

    public boolean isConsignmentAvailable() {
        return customer.isIncomeEqualsOrGreaterThan(5000.0);
    }

    public boolean isGuaranteedAvailable(){
        return basicLoanAvailable();

    }

    public double getPersonalLoanInterestRate(){
        if(isPersonalLoanAvailable()){
            return 4.0;
        }
        throw new LoanNotAvailableException();
    }


    public double getConsignmentLoanInterestRate(){
        if(isConsignmentAvailable()){
            return 2.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getGuaranteedLoanInterestRate(){
        if(isGuaranteedAvailable()){
            return 3.0;
        }
        throw new LoanNotAvailableException();
    }


    private boolean basicLoanAvailable() {
        if(customer.isIncomeEqualsOrLowerThan(3000.0)) {
            return true;
        }
        return customer.isIncomeBetween(3000.0, 5000.00)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }


}
