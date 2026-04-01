package com.example.graded.exercise.two;
enum AccountsEnum{
        // Complete this enum based on the exercise instructions          
    JOHN_DOE("John Doe", "1015890118", 1000.00, "Savings", true),
    JANE_SMITH("Jane Smith", "2894890016", 2000.00, "Checking", false),
    ALICE_JOHNSON("Alice Johnson", "6490380021", 1500.00, "Savings", true),
    BOB_BROWN("Bob Brown", "7802844028", 2500.00, "Checking", false),
    CHARLIE_DAVIS("Charlie Davis", "9801894038", 3000.00, "Savings", true),
    EMILY_WILSON("Emily Wilson", "2098781638", 3500.00, "Checking", false),
    FRANK_MARTIN("Frank Martin", "9337022155", 4000.00, "Savings", true),
    GRACE_LEE("Grace Lee", "1103922779", 4500.00, "Checking", false),
    HENRY_CLARK("Henry Clark", "3302294167", 5000.00, "Savings", true),
    ISABELLA_TAYLOR("Isabella Taylor", "9948382095", 5500.00, "Checking", false),
    JACK_WILSON("Jack Wilson", "3901449302", 6000.00, "Savings", true),
    KAREN_MOORE("Karen Moore", "6579020388", 6500.00, "Checking", false),
    LARRY_JONES("Larry Jones", "2903814493", 7000.00, "Savings", true),
    MARY_SMITH("Mary Smith", "4920410448", 7500.00, "Checking", false),
    NANCY_BROWN("Nancy Brown", "7037921403", 8000.00, "Savings", true),
    OLIVER_DAVIS("Oliver Davis", "2309827046", 8500.00, "Checking", false),
    PETER_JOHNSON("Peter Johnson", "5617329400", 9000.00, "Savings", true),
    QUINN_WILSON("Quinn Wilson", "3972049382", 9500.00, "Checking", false),
    RACHEL_MARTIN("Rachel Martin", "9303857610", 10000.00, "Savings", true),
    STEVE_CLARK("Steve Clark", "3929033810", 10500.00, "Checking", false);

    private final String name;
    private final String accountNumber;
    private final double balance;
    private final String accountType;
    private final Boolean activeLoan;

    AccountsEnum(String name, String accountNumber, double balance, String accountType, Boolean activeLoan) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.activeLoan = activeLoan;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public Boolean getActiveLoan() {
        return activeLoan;
    }

    @Override
    public String toString() {
        return "Account Details:\n"
                + "Account Holder: " + name + "\n"
                + "Account Number: " + accountNumber + "\n"
                + "Account Balance: " + balance + "\n"
                + "Account Type: " + accountType + "\n"
                + "Has a Loan: " + activeLoan;
    }
}
