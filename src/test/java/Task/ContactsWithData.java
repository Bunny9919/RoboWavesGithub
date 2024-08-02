package Task;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.FileUtility.ExcelUtility;
import com.crm.JavaUtility.JavaUtil;
import com.crm.Pom.ContactsPom;
import com.crm.Pom.homePom;

@Listeners(com.crm.Listners.listnersVtiger.class)
public class ContactsWithData extends BaseClass{
	
	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void createContact() throws EncryptedDocumentException, IOException
	{
		homePom h = new homePom(driver);
		h.contacts();
		
		int row = 0;
		ContactsPom c = new ContactsPom(driver);
		c.plus();
		c.firstName(eUtil.getData("contacts", row++, 0));
		String lName = eUtil.getData("contacts", row++, 0);
		c.lastName(lName+JavaUtil.generateRandomNumber());
		c.group();
		c.startDate(JavaUtil.getCurrentdate());
		c.endDate(JavaUtil.getDesireddate());
		c.saveBtn();
		
		
		assertTrue((c.getCreatedContactText().getText()).contains(lName));
		assertTrue((c.getStartDateFromCreated().getText()).equals(JavaUtil.getCurrentdate()));
		
		
	}


}
