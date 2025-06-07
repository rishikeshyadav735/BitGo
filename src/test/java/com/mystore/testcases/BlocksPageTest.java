package com.mystore.testcases;

import com.mystore.pageobject.BlocksPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.util.List;

public class BlocksPageTest extends BaseClass {

    public BlocksPageTest() throws FileNotFoundException {
    }

//    BlocksPage blockPage = new BlocksPage(driver);

    @Test(priority = 1)
    public void validateTransactionHeading() {
        driver.get(url);
        logger.info("URL opened");
        BlocksPage blockPage = new BlocksPage(driver);
        Assert.assertTrue(blockPage.verifyTransactionHeaderText(), "Transaction heading is incorrect or missing.");
    }

    @Test(priority = 2)
    public void printTransactionsWith1Input2Output() {
        driver.get(url);
        logger.info("URL opened");
        BlocksPage blockPage = new BlocksPage(driver);
        List<String> result = blockPage.getTransactionHashesWith1Input2Output();

        System.out.println("Transactions with 1 input and 2 outputs:");
        for (String hash : result) {
            System.out.println(hash);
            logger.info("Transaction hash with 1 input and 2 outputs: " + hash);
        }
    }

}
