package com.mystore.pageobject;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v123.network.model.SecurityIsolationStatus;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.ServerSocket;
import java.time.Duration;
import java.util.*;

public class BlocksPage {

    WebDriver ldriver;

    public BlocksPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // Element for transaction heading
    @FindBy(xpath = "//h3[contains(text(),'Transactions')]")
    WebElement transactionHeading;

    // All visible transaction elements (first 25)
    @FindBy(xpath = "//div[@class='transaction-box']")
    List<WebElement> transactionList;

    // Actions

    public boolean verifyTransactionHeaderText() {
        try {
            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(transactionHeading));
            return transactionHeading.getText().contains("25 of 2875 Transactions");
        } catch (Exception e) {
            System.out.println("Transaction heading not found: " + e.getMessage());
            return false;
        }
    }

    public List<String> getTransactionHashesWith1Input2Output() {
        List<String> matchingHashes = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
//        System.out.println("Processing " + transactionList.size() + " transactions...");
        try {
            for (WebElement tx : transactionList) {
                try {
                    // Wait for the hash element to be present
//                    System.out.println("Checking transaction: ");
                    wait.until(ExpectedConditions.visibilityOf(tx));
                    WebElement hashElem = tx.findElement(By.xpath(".//div[@class='txn font-p2']//a"));
                    String hash = hashElem.getText().trim();
//                    System.out.println("Processing transaction hash: " + hash);

                    int inputs = tx.findElements(By.xpath(".//div[@class='vin-header-container']//a")).size();
                    int outputs = tx.findElements(By.xpath(".//div[@class='vout-header']//a")).size();

                    if (inputs == 1 && outputs == 2) {
//                        System.out.println("Found matching transaction: " + hash + " with " + inputs + " input(s) and " + outputs + " output(s)");
                        matchingHashes.add(hash);
                    }
                } catch (Exception e) {
                    System.out.println("Skipping a transaction due to error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error while processing transactions: " + e.getMessage());
        }

        return matchingHashes;
    }
}
