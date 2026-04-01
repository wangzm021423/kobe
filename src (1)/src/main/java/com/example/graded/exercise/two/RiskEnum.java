package com.example.graded.exercise.two;

enum RiskEnum {
    // Complete this enum based on the exercise instructions          
NO_RISK(0, "No Risk", "There's no risk detected. No action required"),
    NEGLIGIBLE_RISK(1, "Negligible Risk", "Very likely false positive. No action required"),
    LOW_RISK(2, "Low Risk", "Only traces of suspicious activity. Monitor the account on occasion"),
    MEDIUM_RISK(3, "Medium Risk", "Increasingly suspicious activity. Consider contacting the account holder for verification"),
    HIGH_RISK(4, "High Risk", "Suspicious activity at an alarming frequency. Contact the account holder for on-site verification and inform them of 'account freezing' possibility"),
    CRITICAL(5, "Critical", "Undeniable suspicious activity. High chances of illegal activity. FREEZE THE ACCOUNT IMMEDIATELY AND CONTACT THE BANK AUTHORITIES!");

    private final int riskLevel;
    private final String riskTitle;
    private final String actionToTake;

    RiskEnum(int riskLevel, String riskTitle, String actionToTake) {
        this.riskLevel = riskLevel;
        this.riskTitle = riskTitle;
        this.actionToTake = actionToTake;
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

    public String getRecommendedAction() {
        return actionToTake;
    }

    @Override
    public String toString() {
        return "Risk Details:\n"
                + "Risk Level: " + riskLevel + "\n"
                + "Risk: " + riskTitle + "\n"
                + "Recommended Action: " + actionToTake;
    }
}