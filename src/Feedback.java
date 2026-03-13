public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void analyseFeedback(boolean isConcat, String s1, String s2, String s3, String s4, String s5) {
        
        if (isConcat == true) {
        
            completeFeedback = feedbackUsingConcatenation(s1, s2, s3, s4, s5);
        } else {
            StringBuilder sb = feedbackUsingStringBuilder(s1, s2, s3, s4, s5);
            completeFeedback = sb.toString();
        }
        checkFeedbackLength(completeFeedback);

        createReviewID(firstName, lastName, completeFeedback);
    }

    private String feedbackUsingConcatenation(String s1, String s2, String s3, String s4, String s5) {
        String all = s1 + s2 + s3 + s4 + s5;
        return all;
    }

    private StringBuilder feedbackUsingStringBuilder(String s1, String s2, String s3, String s4, String s5) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        sb.append(s3);
        sb.append(s4);
        sb.append(s5);
        return sb;
    }
    private boolean checkFeedbackLength(String feedback) {
        if (feedback.length() > 500) {
            longFeedback = true;
        } else {
            longFeedback = false;
        }
        return longFeedback;
    }

    private void createReviewID(String fn, String ln, String feed) {
        reviewID = fn + ln + feed.length();
    }

    public void printInfo() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Review ID: " + reviewID);
        System.out.println("Long Feedback (>500): " + longFeedback);
        System.out.println("Full Feedback: " + completeFeedback);
    }

    public static void main(String[] args) {
        
        String s1 = "I was very satisfied with the service.";
        String s2 = "The e-Bike is quite comfortable to ride.";
        String s3 = "The battery life of the e-Bike is impressive.";
        String s4 = "The customer support was helpful and responsive.";
        String s5 = "I would recommend this e-Bike to my friends and family.";

        Feedback fb = new Feedback("Tom", "Brown", "tom@test.com");
        fb.analyseFeedback(true, s1, s2, s3, s4, s5);
        fb.printInfo();
    }
}                                                        
