package ru.jmarvin.spring.eventlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private AuditService auditService;

    @Override
    @Transactional
    public void createOrder(boolean awesome) {
        publisher.publishEvent(new CreateOrderEvent(awesome));
    }

    @EventListener(condition = "#event.awesome")
    @Override
    public void handleCreateAwesomeOrderEvent(CreateOrderEvent event) {
        auditService.auditCreateAwesomeOrderEvent(event);
    }
}
