package Prcatice;


	import org.testng.Assert;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

	import com.crm.Generic_Utility.BaseClass;
	import com.crm.Generic_Utility.Excel_utility;
	import com.crm.Generic_Utility.File_utility;
	import com.crm.Generic_Utility.Java_Utility;
	import com.crm.Generic_Utility.WebDriverUtility;
	import com.crm.objectRepsitory.HomePage;

	import com.crm.objectRepsitory.Product;
	import com.crm.objectRepsitory.ProductValidation;
	@Listeners(com.crm.Generic_Utility.Listener.class)
	public class ProductDemo  extends BaseClass {
		@Test (retryAnalyzer=com.crm.Generic_Utility.ReTryImpClass.class)
			public void createProduct() throws Throwable {
				
				WebDriverUtility wlib=new WebDriverUtility();
				File_utility flib=new File_utility();
				Java_Utility jlib=new Java_Utility();
				Excel_utility elib=new Excel_utility();
				HomePage home=new HomePage(driver);
				home.product();
				Assert.assertEquals(true, false);
				int count = jlib.getRandom();
				String name = elib.getValueFromExcel("Sheet1", 1, 0)+count;
				Product prod=new Product(driver);
				prod.PlusProduct();
				prod.productName(name);
				
				
				prod.saveProduct();
				ProductValidation pv=new ProductValidation(driver);
				String ActualProductData =pv.actualProductName();
				Assert.assertEquals(ActualProductData.contains(name), true);
				home.signOut();
				
			
				
			
		}

	}

