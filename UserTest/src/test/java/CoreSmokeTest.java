import org.testng.annotations.Test;


public class CoreSmokeTest extends Common
{
	//Common support = new Common();
	
	@Test
	public void buyTicketsAsNewCustomer()
	{
		buyTickets();
		unlock();
		selectQuantity();
		
	}
	

}
