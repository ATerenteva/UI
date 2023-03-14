package pobeda.ui;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FindTicketBlock {

    private SelenideElement whereFromField = $(By.id("mantine-R2qualmqm-target"));

    private SelenideElement whereField = $(By.id("mantine-R3qualmqm-target"));

    private SelenideElement dateThereField = $(By.id(":Rbcualmqm:"));

    private SelenideElement dateBackField = $(By.id(":Rrcualmqm:"));

    private SelenideElement findButton = $(By.xpath("//button[contains(@class, \"dp-n39zqv\")]"));


    public SelenideElement getWhereFromField() {
        return whereFromField;
    }

    public SelenideElement getWhereField() {
        return whereField;
    }

    public SelenideElement getDateThereField() {
        return dateThereField;
    }

    public SelenideElement getDateBackField() {
        return dateBackField;
    }

    public void clickWhereFromField(){ whereFromField.click(); }

    public void clickWhereField(){
        whereField.click();
    }

    public void clickFindButton(){
        findButton.click();
    }

}
