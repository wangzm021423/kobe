package com.example.graded.exercise.two;

import java.util.LinkedList;
import java.util.Scanner;

/* COMPLETE AS PER THE INSTRUCTIONS */
public class AuditResultsReview {
   LinkedList<AuditResults> auditResultsListForReview = new LinkedList<>();
   private Scanner scanner;

   public void reviewAuditResults() {
      Scanner scanner = getScanner();
      int choice = 0;

      while (choice != 6) {
         System.out.println("Choose one of the following review activities:");
         System.out.println("1. Generate audit results for review");
         System.out.println("2. Display all the audit results");
         System.out.println("3. List accounts with a specific risk level");
         System.out.println("4. Modify an audit result");
         System.out.println("5. Delete an audit result");
         System.out.println("6. Exit");

         String input = scanner.nextLine().trim();
         try {
            choice = Integer.parseInt(input);
         } catch (NumberFormatException e) {
            choice = -1;
         }

         switch (choice) {
            case 1:
               generateAuditResults();
               break;
            case 2:
               displayAllAuditResults(auditResultsListForReview);
               break;
            case 3:
               searchByRiskLevel(auditResultsListForReview);
               break;
            case 4:
               modifyAuditResult(auditResultsListForReview);
               break;
            case 5:
               deleteAuditResult(auditResultsListForReview);
               break;
            case 6:
               System.out.println("Exiting review process");
               break;
            default:
               System.out.println("Invalid choice. Please try again");
               break;
         }
      }
   }

   private void generateAuditResults() {
      RecentAuditResults recentAuditResults = new RecentAuditResults();
      recentAuditResults.generateRecentAuditResults();

      auditResultsListForReview.clear();
      auditResultsListForReview.addAll(recentAuditResults.getAuditResultsList());
   }

   private void displayAllAuditResults(LinkedList<AuditResults> auditResultsList) {
      for (AuditResults result : auditResultsList) {
         System.out.println(result);
      }
   }

   private void searchByRiskLevel(LinkedList<AuditResults> auditResultsList) {
      Scanner scanner = getScanner();
      System.out.print("Enter the risk level (0 - 5) to search for: ");
      String input = scanner.nextLine().trim();

      int targetRisk;
      try {
         targetRisk = Integer.parseInt(input);
      } catch (NumberFormatException e) {
         return;
      }

      boolean found = false;
      for (AuditResults result : auditResultsList) {
         if (result.getRiskLevel() == targetRisk) {
            System.out.println("Account Number: " + result.getAccountNumber());
            System.out.println("Risk Title: " + result.getRiskTitle());
            System.out.println("Action To Take: " + result.getActionToTake());
            found = true;
         }
      }

      if (!found) {
         System.out.println("No audit results found with the specified risk level.");
      }
   }

   private void modifyAuditResult(LinkedList<AuditResults> auditResultsList) {
      System.out.println("Please note that you can modify only the risk level, risk title, and action to take for an audit result.");

      Scanner scanner = getScanner();
      System.out.print("Enter an account number whose detail must be modified: ");
      String accountNumber = scanner.nextLine().trim();

      AuditResults target = null;
      for (AuditResults result : auditResultsList) {
         if (result.getAccountNumber().equals(accountNumber)) {
            target = result;
            break;
         }
      }

      if (target == null) {
         System.out.println("Audit result with the account number " + accountNumber + " not found");
         return;
      }

      System.out.println("Current Risk Level: " + target.getRiskLevel());
      System.out.print("Enter the new risk level (Press ENTER to skip): ");
      String newRiskInput = scanner.nextLine().trim();
      if (!newRiskInput.isEmpty()) {
         if (newRiskInput.matches("-?\\d+")) {
            int newRiskLevel = Integer.parseInt(newRiskInput);
            target.setRiskLevel(newRiskLevel);
            System.out.println("Risk Level updated successfully");
         }
      }

      System.out.println("Current Risk Title: " + target.getRiskTitle());
      System.out.print("Enter the new risk title (Press ENTER to skip): ");
      String newRiskTitle = scanner.nextLine();
      if (!newRiskTitle.isEmpty()) {
         target.setRiskTitle(newRiskTitle);
         System.out.println("Risk Title updated successfully");
      }

      System.out.println("Current Action To Take: " + target.getActionToTake());
      System.out.print("Enter the new description of action to take (Press ENTER to skip): ");
      String newAction = scanner.nextLine();
      if (!newAction.isEmpty()) {
         target.setActionToTake(newAction);
         System.out.println("Action to Take updated successfully");
      }
   }

   private void deleteAuditResult(LinkedList<AuditResults> auditResultsList) {
      Scanner scanner = getScanner();
      System.out.print("Enter an account number whose audit result needs to be deleted: ");
      String accountNumber = scanner.nextLine().trim();

      boolean removed = auditResultsList.removeIf(result -> result.getAccountNumber().equals(accountNumber));
      if (removed) {
         System.out.println("Audit result for the account number " + accountNumber + " deleted successfully");
      } else {
         System.out.println("Audit result with the account number " + accountNumber + " not found");
      }
   }

   private Scanner getScanner() {
      if (scanner == null) {
         scanner = new Scanner(System.in);
      }
      return scanner;
   }
}
