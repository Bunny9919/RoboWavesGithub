 package Task;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.FileUtility.ExcelUtility;
import com.crm.JavaUtility.JavaUtil;
import com.crm.Pom.homePom;
import com.crm.Pom.organaizationsPom;

public class OrganizationWithIndustry extends BaseClass{
	ExcelUtility util = new ExcelUtility();
	@Test
	public void createOrganizationWithIndustry() throws EncryptedDocumentException, IOException
	{	
		JavaUtil JavaUtil = new JavaUtil();
		
		homePom h = new homePom(driver);
		h.organizations();
		
		organaizationsPom org = new organaizationsPom(driver);
		org.plusIcon();
		int row=0;
		org.plusIcon();
		String CompanyName = util.getData("org", row++, 0);
		org.organizationName(CompanyName+JavaUtil.generateRandomNumber());
		String IndustryName = util.getData("org", row++, 0);
		org.selectIndustry(IndustryName);
		org.group();
		String aTo= util.getData("org", row++, 0);
		org.assignedto(aTo);
		org.saveBtn();
//		driver.switchTo().alert().accept();
		
		assertTrue((org.getCreatedOrgText().getText()).contains(CompanyName));
		assertTrue((org.getIndustryText().getText()).contains(IndustryName));
//		assertTrue((org.getAssignedTo().getText()).contains(aTo));
	}


}
