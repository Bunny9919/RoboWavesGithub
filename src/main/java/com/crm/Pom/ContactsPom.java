package com.crm.Pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPom {

	public ContactsPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(css = "img[alt=\"Create Contact...\"]")
	WebElement plusIcon;
	
	public WebElement getPlucIcon()
	{
		return plusIcon;
	}
	public void plus()
	{
		plusIcon.click();
	}
	
	private @FindBy(name = "firstname")
	WebElement fName;
	
	public WebElement getFirstName()
	{
		return fName;
	}
	public void firstName(String first_Name)
	{
		fName.sendKeys(first_Name);
	}
	
	private @FindBy(name = "lastname")
	WebElement lName;
	
	public WebElement getLastName()
	{
		return lName;
	}
	public void lastName(String last_Name)
	{
		lName.sendKeys(last_Name);
	}
	
	private @FindBy(xpath = "(//input[@name='assigntype'])[2]")
	WebElement grp;
	
	public WebElement getGroup()
	{
		return grp;
	}
	public void group()
	{
		grp.click();
	}
	
	private @FindBy(name = "assigned_group_id")
	WebElement assignedTo;
	
	public WebElement getAssignedTo()
	{
		return assignedTo;
	}
	public void assignedto(String assigned)
	{ 
		Select s = new Select(assignedTo);
		s.selectByVisibleText(assigned);
	}
	
	private @FindBy(name = "support_start_date")
	WebElement sDate;
	
	public WebElement getStartDate()
	{
		return assignedTo;
	}
	public void startDate(String start_Date)
	{ 
		sDate.clear();
		sDate.sendKeys(start_Date);
	}
	
	private @FindBy(name = "support_end_date")
	WebElement eDate;
	
	public WebElement getEndDate()
	{
		return assignedTo;
	}
	public void endDate(String end_Date)
	{ 
		eDate.clear();
		eDate.sendKeys(end_Date);
	}
	
	private @FindBy(xpath = "(//input[contains(@value,'Save')])[2]")
	WebElement save;
	
	public WebElement getSave()
	{
		return save;
	}
	public void saveBtn()
	{
		save.click();
	}
	
	private @FindBy(className = "dvHeaderText")
	WebElement createdContactText;
	
	public WebElement getCreatedContactText()
	{
		return createdContactText;
	}   
	
	private @FindBy(xpath = "(//td[text()='Support Start Date']/..//td[@class=\"dvtCellInfo\"])[2]/span")
	WebElement sDateFromCreated;
	
	public WebElement getStartDateFromCreated()
	{
		return sDateFromCreated;
	}


}
