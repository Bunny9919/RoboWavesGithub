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

public class Organazation extends BaseClass {
	ExcelUtility util = new ExcelUtility();  
	@Test
	public void createOrganization() throws EncryptedDocumentException,  IOException
	{
		homePom h = new homePom(driver);
		h.organizations();
		
		JavaUtil JavaUtil = new JavaUtil();
		int row=0;
		organaizationsPom org = new organaizationsPom(driver);
		org.plusIcon();
		String CompanyName = util.getData("org", row++, 1);
		org.organizationName(CompanyName+JavaUtil.generateRandomNumber());
		org.group();
		String SupportGroupName = util.getData("org", row++, 1);
		org.assignedto( SupportGroupName);
		org.saveBtn();
		
		assertTrue(!(org.getCreatedOrgText().getText()).contains(CompanyName));
	}


}
