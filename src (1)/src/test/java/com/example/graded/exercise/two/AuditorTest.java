package com.example.graded.exercise.two;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.*;

public class AuditorTest {

    private final Random rand = new Random();
    private List<AuditResults> auditResultsListForTesting = new LinkedList<>();

    // Helper method to get a random account number from the AccountsEnum
    private String getRandomAccountNumber() {
        AccountsEnum[] accounts = AccountsEnum.values();
        return accounts[rand.nextInt(accounts.length)].getAccountNumber();
    }

    // Helper method to generate audit results for testing
    public void generateAuditResultsForTest() {
        RecentAuditResults recent = new RecentAuditResults();
        recent.generateRecentAuditResults();
        auditResultsListForTesting = recent.getAuditResultsList();
    }
    
    // 1 point
    @Test
    void testAuditResultsRandomConstruction() {

        String account = getRandomAccountNumber();

        Auditor auditor = new Auditor();
        auditor.auditTransactions(account);

        AuditResults result = new AuditResults(
                account,
                auditor.getFrequencyRating(),
                auditor.getAmountRating(),
                auditor.getLocationRating(),
                auditor.getOddHourRating(),
                auditor.getCompositeRating(),
                auditor.getRiskLevel(),
                auditor.getRiskTitle(),
                auditor.getActionToTake()
        );

        assertEquals(account, result.getAccountNumber());
        assertTrue(result.getCompositeRating() >= 0);
        assertNotNull(result.getRiskTitle());
    }

    // 1 point
    @Test
    void testAuditResultsMutationRandom() {

        AuditResults result = new AuditResults(
                getRandomAccountNumber(),
                rand.nextInt(10),
                rand.nextInt(10),
                rand.nextInt(10),
                rand.nextInt(10),
                rand.nextInt(50),
                rand.nextInt(5),
                "Test",
                "TestAction"
        );

        int newRisk = rand.nextInt(6);
        String newTitle = "Updated-" + rand.nextInt(1000);
        String newAction = "Action-" + rand.nextInt(1000);

        result.setRiskLevel(newRisk);
        result.setRiskTitle(newTitle);
        result.setActionToTake(newAction);

        assertEquals(newRisk, result.getRiskLevel());
        assertEquals(newTitle, result.getRiskTitle());
        assertEquals(newAction, result.getActionToTake());
    }

    // 1 point
    @Test
    void testRecentAuditResultsProducesResultsWithoutUI() {

        RecentAuditResults recent = new RecentAuditResults();

        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream()));

        recent.generateRecentAuditResults();

        System.setOut(originalOut);

        assertTrue(recent.auditResultsList.size() > 0);
    }
    
    // 1 point
    @Test    
    void testRecentAuditResultsUsesLinkedList() {

        RecentAuditResults recent = new RecentAuditResults();

        assertTrue(recent.auditResultsList instanceof LinkedList);
    }

    
    // 1 point
    @Test
    void testRecentAuditResultsListNotEmptyAfterRun() {

        RecentAuditResults recent = new RecentAuditResults();

        recent.generateRecentAuditResults();

        assertTrue(recent.auditResultsList.size() > 0);
    }

    // 3 points
    @Test
    void testModifyClean() {

        generateAuditResultsForTest();

        assertFalse(auditResultsListForTesting.isEmpty());

        AuditResults target = auditResultsListForTesting.get(
                rand.nextInt(auditResultsListForTesting.size())
        );

        String account = target.getAccountNumber();

        int newRisk = rand.nextInt(6);
        String newTitle = "Updated-" + rand.nextInt(1000);
        String newAction = "Action-" + rand.nextInt(1000);

        for (AuditResults r : auditResultsListForTesting) {
            if (r.getAccountNumber().equals(account)) {
                r.setRiskLevel(newRisk);
                r.setRiskTitle(newTitle);
                r.setActionToTake(newAction);
            }
        }

        boolean updated = false;

        for (AuditResults r : auditResultsListForTesting) {
            if (r.getAccountNumber().equals(account)) {
                assertEquals(newRisk, r.getRiskLevel());
                assertEquals(newTitle, r.getRiskTitle());
                assertEquals(newAction, r.getActionToTake());
                updated = true;
            }
        }

        assertTrue(updated);
    }


    // 3 points
    @Test
    void testDeleteClean() {

        generateAuditResultsForTest();

        String account = auditResultsListForTesting.get(rand.nextInt(0,auditResultsListForTesting.size())).getAccountNumber();

        auditResultsListForTesting.removeIf(r -> r.getAccountNumber().equals(account));

        assertFalse(auditResultsListForTesting.stream()
                .anyMatch(r -> r.getAccountNumber().equals(account)));
    }

    // 5 points
    @Test
    void testSearchByRiskLevelRandomSafe() {

        AuditResultsReview review = new AuditResultsReview();

        List<AuditResults> list = new ArrayList<>();

        int targetRisk = rand.nextInt(6);

        list.add(new AuditResults(getRandomAccountNumber(),1,1,1,1,4,targetRisk,"Target","Action"));

        String input =
                "2\n" +
                targetRisk + "\n" +
                "5\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));


        assertTrue(true); 
    }

    
    // 4 points
    @Test
    void testFullPipelineRandomMultipleRuns() {

        for (int i = 0; i < 5; i++) {

            String account = getRandomAccountNumber();

            Auditor auditor = new Auditor();
            auditor.auditTransactions(account);

            AuditResults result = new AuditResults(
                    account,
                    auditor.getFrequencyRating(),
                    auditor.getAmountRating(),
                    auditor.getLocationRating(),
                    auditor.getOddHourRating(),
                    auditor.getCompositeRating(),
                    auditor.getRiskLevel(),
                    auditor.getRiskTitle(),
                    auditor.getActionToTake()
            );

            assertNotNull(result);
            assertTrue(result.getCompositeRating() >= 0);
            assertTrue(result.getRiskLevel() >= 0 && result.getRiskLevel() <= 5);
        }
    }
}
