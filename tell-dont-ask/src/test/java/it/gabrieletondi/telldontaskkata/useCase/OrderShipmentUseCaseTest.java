package it.gabrieletondi.telldontaskkata.useCase;

import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.domain.OrderStatus;
import it.gabrieletondi.telldontaskkata.doubles.TestOrderRepository;
import it.gabrieletondi.telldontaskkata.doubles.TestShipmentService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderShipmentUseCaseTest {
    private final TestOrderRepository orderRepository = new TestOrderRepository();
    private final TestShipmentService shipmentService = new TestShipmentService();
    private final OrderShipmentUseCase useCase = new OrderShipmentUseCase(orderRepository, shipmentService);

    @Test
    public void shipApprovedOrder() {
        Order initialOrder = new Order();
        initialOrder.setId(1);
        initialOrder.setStatus(OrderStatus.APPROVED);
        orderRepository.addOrder(initialOrder);

        OrderShipmentRequest request = new OrderShipmentRequest();
        request.setOrderId(1);

        useCase.run(request);

        assertThat(orderRepository.getSavedOrder().getStatus()).isEqualTo(OrderStatus.SHIPPED);
        assertThat(shipmentService.getShippedOrder()).isEqualTo(initialOrder);
    }

    @Test
    public void createdOrdersCannotBeShipped() {
        assertThatThrownBy(() -> {
            Order initialOrder = new Order();
            initialOrder.setId(1);
            initialOrder.setStatus(OrderStatus.CREATED);
            orderRepository.addOrder(initialOrder);

            OrderShipmentRequest request = new OrderShipmentRequest();
            request.setOrderId(1);

            useCase.run(request);

            assertThat(orderRepository.getSavedOrder()).isNull();
            assertThat(shipmentService.getShippedOrder()).isNull();
        }).isInstanceOf(OrderCannotBeShippedException.class);
    }

    @Test
    public void rejectedOrdersCannotBeShipped() {
        assertThatThrownBy(() -> {
            Order initialOrder = new Order();
            initialOrder.setId(1);
            initialOrder.setStatus(OrderStatus.REJECTED);
            orderRepository.addOrder(initialOrder);

            OrderShipmentRequest request = new OrderShipmentRequest();
            request.setOrderId(1);

            useCase.run(request);

            assertThat(orderRepository.getSavedOrder()).isNull();
            assertThat(shipmentService.getShippedOrder()).isNull();
        }).isInstanceOf(OrderCannotBeShippedException.class);
    }

    @Test
    public void shippedOrdersCannotBeShippedAgain() {
        assertThatThrownBy(() -> {

            Order initialOrder = new Order();
            initialOrder.setId(1);
            initialOrder.setStatus(OrderStatus.SHIPPED);
            orderRepository.addOrder(initialOrder);

            OrderShipmentRequest request = new OrderShipmentRequest();
            request.setOrderId(1);

            useCase.run(request);

            assertThat(orderRepository.getSavedOrder()).isNull();
            assertThat(shipmentService.getShippedOrder()).isNull();
        }).isInstanceOf(OrderCannotBeShippedTwiceException.class);
    }
}
