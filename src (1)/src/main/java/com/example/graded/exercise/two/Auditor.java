package com.example.graded.exercise.two;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Auditor {

    // Complete this class based on the exercise instructions          
    private int frequencyRating;
    private int amountRating;
    private int locationRating;
    private int oddHoursRating;
    private int compositeRating;
    private int riskLevel;
    private String riskTitle;
    private String actionToTake;

    public int getFrequencyRating() {
        return frequencyRating;
    }

    public int getAmountRating() {
        return amountRating;
    }

    public int getLocationRating() {
        return locationRating;
    }

    public int getOddHoursRating() {
        return oddHoursRating;
    }

    public int getOddHourRating() {
        return oddHoursRating;
    }

    public int getCompositeRating() {
        return compositeRating;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public String getActionToTake() {
        return actionToTake;
    }

    public void accountNumberInput() {
        for (AccountsEnum account : AccountsEnum.values()) {
            System.out.println(account);
        }

        String accountNumber = "";
        boolean found = false;

        try (Scanner scanner = new Scanner(System.in)) {
            while (!found) {
                System.out.print("Enter an account number to investigate for fraud risk: ");
                String input = scanner.nextLine().trim();

                for (AccountsEnum account : AccountsEnum.values()) {
                    if (account.getAccountNumber().equals(input)) {
                        found = true;
                        accountNumber = input;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Account number not found. Please enter a correct account number.");
                }
            }
        }

        auditTransactions(accountNumber);
    }

    public void auditTransactions(String accountNumber) {
        frequencyRating = 0;
        amountRating = 0;
        locationRating = 0;
        oddHoursRating = 0;
        compositeRating = 0;

        evaluateFrequency(accountNumber);
        evaluateAmount(accountNumber);
        evaluateLocation(accountNumber);
        evaluateOddHour(accountNumber);

        compositeRating = frequencyRating + amountRating + locationRating + oddHoursRating;

        evaluateRiskLevel(compositeRating);
    }

    private void evaluateFrequency(String accountNumber) {
        List<LocalDateTime> timestamps = new ArrayList<>();

        for (TransactionsEnum transaction : TransactionsEnum.values()) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                LocalDateTime timestamp = LocalDateTime.parse(transaction.getTimestamp());
                timestamps.add(timestamp);
            }
        }

        timestamps.sort(Comparator.naturalOrder());

        for (int i = 1; i < timestamps.size(); i++) {
            long minutes = ChronoUnit.MINUTES.between(timestamps.get(i - 1), timestamps.get(i));

            if (minutes <= 1440) {
                frequencyRating += 5;
            } else if (minutes > 1440 && minutes <= 2880) {
                frequencyRating += 2;
            }
        }
    }

    private void evaluateAmount(String accountNumber) {
        for (TransactionsEnum transaction : TransactionsEnum.values()) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                double amount = transaction.getAmount();

                if (amount > 5000) {
                    amountRating += 5;
                } else if (amount > 100 && amount < 500) {
                    amountRating += 1;
                }
            }
        }
    }

    private void evaluateLocation(String accountNumber) {
        for (TransactionsEnum transaction : TransactionsEnum.values()) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                if ("International".equalsIgnoreCase(transaction.getTransactionCategory())) {
                    locationRating += 5;
                }
            }
        }
    }

    private void evaluateOddHour(String accountNumber) {
        for (TransactionsEnum transaction : TransactionsEnum.values()) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                LocalDateTime timestamp = LocalDateTime.parse(transaction.getTimestamp());
                int hour = timestamp.getHour();

                if (hour < 6 || hour > 22) {
                    oddHoursRating += 5;
                }
            }
        }
    }

    private void evaluateRiskLevel(int compositeRating) {
        RiskEnum risk;

        if (compositeRating < 40) {
            risk = RiskEnum.NO_RISK;
        } else if (compositeRating < 50) {
            risk = RiskEnum.NEGLIGIBLE_RISK;
        } else if (compositeRating < 60) {
            risk = RiskEnum.LOW_RISK;
        } else if (compositeRating < 70) {
            risk = RiskEnum.MEDIUM_RISK;
        } else if (compositeRating < 85) {
            risk = RiskEnum.HIGH_RISK;
        } else {
            risk = RiskEnum.CRITICAL;
        }

        riskLevel = risk.getRiskLevel();
        riskTitle = risk.getRiskTitle();
        actionToTake = risk.getActionToTake();
    }

    @Override
    public String toString() {
        return "Risk Audit Result:\n"
                + "Transaction Frequency Risk: " + frequencyRating + "\n"
                + "Transaction Amount Risk: " + amountRating + "\n"
                + "Transaction Location Risk: " + locationRating + "\n"
                + "Transaction Timing Risk: " + oddHoursRating + "\n"
                + "Composite Risk: " + compositeRating + "\n"
                + "Estimated Risk Level: " + riskLevel + "\n\n"
                + "Overall Risk: " + riskTitle + "\n"
                + "Recommended Action: " + actionToTake + "\n"
                + "NOTE: Lower values are better.";
    }
}
