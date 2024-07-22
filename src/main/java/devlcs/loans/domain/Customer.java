package devlcs.loans.domain;

public class Customer {
    public Customer(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public boolean isIncomeEqualsOrLowerThan(double v) {
        return income <= v;
    }

    public boolean isIncomeEqualsOrGreaterThan(double value){
        return income >= value;
    }

    public boolean isIncomeBetween(double minValue, double maxValue) {
        return income >= minValue && income <= maxValue;
    }

    public boolean isAgeLowerThan(int age) {
        return this.age <= age;
    }

    public boolean isFromLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }
}
