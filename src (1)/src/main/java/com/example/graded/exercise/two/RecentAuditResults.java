package com.example.graded.exercise.two;

import java.util.ArrayList;
import java.util.LinkedList;

/* COMPLETE AS PER THE INSTRUCTIONS */
public class RecentAuditResults {
   ArrayList<String> accountNumbersList = new ArrayList<>();
   LinkedList<AuditResults> auditResultsList = new LinkedList<>();

   public void generateRecentAuditResults() {
      accountNumbersList.clear();
      auditResultsList.clear();

      for (TransactionsEnum transaction : TransactionsEnum.values()) {
         String accountNumber = transaction.getAccountNumber();
         if (!accountNumbersList.contains(accountNumber)) {
            accountNumbersList.add(accountNumber);
         }
      }

      for (String accountNumber : accountNumbersList) {
         Auditor auditor = new Auditor();
         auditor.auditTransactions(accountNumber);

         AuditResults auditResults = new AuditResults(
               accountNumber,
               auditor.getFrequencyRating(),
               auditor.getAmountRating(),
               auditor.getLocationRating(),
               auditor.getOddHourRating(),
               auditor.getCompositeRating(),
               auditor.getRiskLevel(),
               auditor.getRiskTitle(),
               auditor.getActionToTake()
         );

         auditResultsList.add(auditResults);
      }
   }

   public LinkedList<AuditResults> getAuditResultsList() {
      return auditResultsList;
   }

   public void addAuditResults(AuditResults auditResults) {
      auditResultsList.add(auditResults);
   }
}
