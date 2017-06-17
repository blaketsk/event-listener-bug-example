package ru.jmarvin.spring.eventlistener;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private IOrderService orderService;

	@MockBean
	private AuditService auditService;

	@Test
	public void createAwesomeOrderShouldBeAudited() {
		orderService.createOrder(true);
		verify(auditService).auditCreateAwesomeOrderEvent(any());
	}

	@Test
	public void createNotAwesomeOrderShoudntBeAudited() {
		orderService.createOrder(false);
		verify(auditService, never()).auditCreateAwesomeOrderEvent(any());
	}

}
