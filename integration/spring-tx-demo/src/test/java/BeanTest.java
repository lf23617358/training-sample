
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iisigroup.domain.User;
import com.iisigroup.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class BeanTest {
	@Autowired
	@Qualifier("defaultUserService")
	private UserService defaultUserService;
	@Autowired
	@Qualifier("txDefaultUserService")
	private UserService txDefaultUserService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTxBySchema() {
		defaultUserService.insert(new User());
	}

	@Test
	public void testTxByAnnoation() {
		txDefaultUserService.insert(new User());
	}
}
