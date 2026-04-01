package com.example.graded.exercise.two;

public class AuditResults {
    private String accountNumber;
    private int frequencyRating;
    private int amountRating;
    private int locationRating;
    private int oddHourRating;
    private int compositeRating;
    private int riskLevel;
    private String riskTitle;
    private String actionToTake;

    public AuditResults(String accountNumber, int frequencyRating, int amountRating, int locationRating, int oddHourRating, int compositeRating, int riskLevel, String riskTitle, String actionToTake) {
        this.accountNumber = accountNumber;
        this.frequencyRating = frequencyRating;
        this.amountRating = amountRating;
        this.locationRating = locationRating;
        this.oddHourRating = oddHourRating;
        this.compositeRating = compositeRating;
        this.riskLevel = riskLevel;
        this.riskTitle = riskTitle;
        this.actionToTake = actionToTake;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public int getFrequencyRating() {
        return frequencyRating;
    }
    public int getAmountRating() {
        return amountRating;
    }
    public int getLocationRating() {
        return locationRating;
    }
    public int getOddHourRating() {
        return oddHourRating;
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
    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }
    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }
    public void setActionToTake(String actionToTake) {
        this.actionToTake = actionToTake;
    }
    @Override
    public String toString() {
        return "Audit Results:\n"
                + "Account Number: " + accountNumber + "\n"
                + "Frequency Rating: " + frequencyRating + "\n"
                + "Amount Rating: " + amountRating + "\n"
                + "Location Rating: " + locationRating + "\n"
                + "Odd Hour Rating: " + oddHourRating + "\n"
                + "Composite Rating: " + compositeRating + "\n"
                + "Risk Level: " + riskLevel + "\n"
                + "Risk Title: " + riskTitle + "\n"
                + "Action To Take: " + actionToTake;
    }
}
