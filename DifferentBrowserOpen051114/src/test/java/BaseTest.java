import org.junit.After;
import org.junit.Before;


public class BaseTest extends BrowserOpen
{
	@Before
	public void open()
	{
		start();
	}
	@After
	public void finish()
	{
		end();
	}

}
