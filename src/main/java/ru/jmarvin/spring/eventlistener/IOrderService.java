package ru.jmarvin.spring.eventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

public interface IOrderService {

    void createOrder(boolean awesome);

    void handleCreateAwesomeOrderEvent(CreateOrderEvent event);
}
