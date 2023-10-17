package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TariffPage;
import utilities.ApplicationFlow;

public class TariffsSteps {
    TariffPage tariffPage = new TariffPage();
    @When("navigate to the tariffs page")
    public void navigate_to_the_tariffs_page() {
        ApplicationFlow.pause(2000);
        tariffPage.tariffs.click();
    }
    @When("click on create tariff")
    public void click_on_create_tariff() {
        tariffPage.createTariffButton.click();
    }
    @When("fill out all tariffs fields")
    public void fill_out_all_tariffs_fields() {
        tariffPage.chooseBranch.click();

        tariffPage.branch.click();

        tariffPage.fieldNameTariff.click();
        tariffPage.fieldNameTariff.sendKeys("Specific tariff");

        tariffPage.fieldDeliveryTime.click();
        tariffPage.fieldDeliveryTime.sendKeys("12 PM");

        tariffPage.typeDelivery.click();
        tariffPage.cityExpress.click();

        tariffPage.deliveryCost.click();
        tariffPage.deliveryCost.sendKeys("15");

        tariffPage.coordinates.click();
        tariffPage.coordinates.sendKeys("25.7617");

        tariffPage.additionalInformation.click();
        tariffPage.additionalInformation.sendKeys("Give personally");
    }
    @When("click on button create")
    public void click_on_button_create() {
        ApplicationFlow.pause(3000);
        tariffPage.createButton.click();
    }
    @Then("verify user create new tariff")
    public void verify_user_create_new_tariff() {
        String expectedText = "Tariff created successfully";
        if (tariffPage.popUpMessage.isDisplayed() && tariffPage.popUpMessage.getText().contains(expectedText)) {
            System.out.println("PopUp message with visible text found and verified.");
        } else {
            System.out.println("Element with visible text not found or verification failed.");
        }
    }
}
