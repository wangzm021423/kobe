package com.example.graded.exercise.two;

enum TransactionsEnum {
    // Complete this enum based on the exercise instructions           
    TRANSACTION_1("John Doe", "1015890118", "Withdrawal", 500.00, "2024-01-01T17:44:06", "St. Augustine Avenue", "New York", "Domestic"),
    TRANSACTION_2("Charlie Davis", "9801894038", "Withdrawal", 300.00, "2024-01-05T22:45:00", "Via Roma", "Rome", "International"),
    TRANSACTION_3("Alice Johnson", "6490380021", "Withdrawal", 200.00, "2024-01-03T14:15:30", "Main Street", "Los Angeles", "Domestic"),
    TRANSACTION_4("Bob Brown", "7802844028", "Deposit", 1500.00, "2024-01-04T09:00:00", "Sunset Boulevard", "Los Angeles", "Domestic"),
    TRANSACTION_5("Charlie Davis", "9801894038", "Withdrawal", 200.00, "2024-01-06T03:15:00", "Via Matteotti", "Sanremo", "International"),
    TRANSACTION_6("Emily Wilson", "2098781638", "Deposit", 2500.00, "2024-01-06T11:20:00", "Collins Avenue", "Miami", "Domestic"),
    TRANSACTION_7("Frank Martin", "9337022155", "Withdrawal", 400.00, "2024-01-07T13:30:00", "Lombard Street", "San Francisco", "Domestic"),
    TRANSACTION_8("Charlie Davis", "9801894038", "Withdrawal", 150.00, "2024-01-06T05:30:10", "Via Vittorio", "Milano", "International"),
    TRANSACTION_9("Emily Wilson", "2098781638", "Withdrawal", 2500.00, "2024-01-06T11:23:00", "Panther Street", "Miami", "Domestic"),
    TRANSACTION_10("Isabella Taylor", "9948382095", "Deposit", 3500.00, "2024-01-10T14:30:00", "Pike Street", "Seattle", "Domestic"),
    TRANSACTION_11("Charlie Davis", "9801894038", "Withdrawal", 300.00, "2024-01-07T07:31:00", "Via Cavour", "Florence", "International"),
    TRANSACTION_12("Emily Wilson", "2098781638", "Deposit", 5000.00, "2024-01-07T23:27:03", "Chapel Road", "London", "International"),
    TRANSACTION_13("Larry Jones", "2903814493", "Withdrawal", 800.00, "2024-01-13T11:30:00", "Wilshire Boulevard", "Los Angeles", "Domestic"),
    TRANSACTION_14("Emily Wilson", "2098781638", "Withdrawal", 8000.00, "2024-01-10T21:15:50", "Collins Avenue", "Miami", "Domestic"),
    TRANSACTION_15("Charlie Davis", "9801894038", "Withdrawal", 220.00, "2024-01-07T23:05:08", "Cassaro", "Palermo", "International"),
    TRANSACTION_16("Oliver Davis", "2309827046", "Deposit", 5000.00, "2024-01-16T10:00:00", "Ocean Drive", "Miami", "Domestic"),
    TRANSACTION_17("Emily Wilson", "2098781638", "Deposit", 8000.00, "2024-01-10T21:18:32", "Sandhurst Street", "Edinburgh", "International"),
    TRANSACTION_18("Quinn Wilson", "3972049382", "Deposit", 5500.00, "2024-01-18T16:30:00", "Market Street", "San Francisco", "Domestic"),
    TRANSACTION_19("Emily Wilson", "2098781638", "Withdrawal", 3000.00, "2024-01-13T04:23:17", "Collins Avenue", "Miami", "Domestic"),
    TRANSACTION_20("Charlie Davis", "9801894038", "Withdrawal", 150.00, "2024-01-09T04:13:15", "Decumanus", "Naples", "International");

    private final String accountHolderName;
    private final String accountNumber;
    private final String transactionType;
    private final double amount;
    private final String timestamp;
    private final String location;
    private final String city;
    private final String transactionCategory;

    TransactionsEnum(String accountHolderName, String accountNumber, String transactionType, double amount, String timestamp, String location, String city, String transactionCategory) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
        this.location = location;
        this.city = city;
        this.transactionCategory = transactionCategory;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    @Override
    public String toString() {
        return "Transactions Details\n"
                + "Account Holder: " + accountHolderName + "\n"
                + "Account Number: " + accountNumber + "\n"
                + "Transaction Type: " + transactionType + "\n"
                + "Transaction Amount: " + amount + "\n"
                + "Time of Transaction: " + timestamp + "\n"
                + "Location of Transaction: " + location + "\n"
                + "City of Transaction: " + city + "\n"
                + "Category of Transaction: " + transactionCategory;
    }
}