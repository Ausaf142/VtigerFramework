
	package Prcatice;

	import org.testng.annotations.Test;


	 class Sample2{
		
		@Test (priority=1)
		public void createContact() {
			
			System.out.println("contact created");
			
		}

		@Test (invocationCount=2)
		public void modifyContact() {
			System.out.println("modified contact");
		}
		
		@Test (priority=3)
		public void deleteContact() {
			System.out.println("contact deleted");
		}
		
		@Test (priority=-1)
		public void restore() {
			System.out.println("Restored");
		}
			
		

	

}
