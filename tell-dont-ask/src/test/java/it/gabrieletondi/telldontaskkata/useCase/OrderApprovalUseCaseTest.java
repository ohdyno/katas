package it.gabrieletondi.telldontaskkata.useCase;

import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.domain.OrderStatus;
import it.gabrieletondi.telldontaskkata.doubles.TestOrderRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderApprovalUseCaseTest {
    private final TestOrderRepository orderRepository = new TestOrderRepository();
    private final OrderApprovalUseCase useCase = new OrderApprovalUseCase(orderRepository);

    @Test
    public void approvedExistingOrder() {
        Order initialOrder = new Order();
        initialOrder.setStatus(OrderStatus.CREATED);
        initialOrder.setId(1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setOrderId(1);
        request.setApproved(true);

        useCase.run(request);

        final Order savedOrder = orderRepository.getSavedOrder();
        assertThat(savedOrder.getStatus()).isEqualTo(OrderStatus.APPROVED);
    }

    @Test
    public void rejectedExistingOrder() {
        Order initialOrder = new Order();
        initialOrder.setStatus(OrderStatus.CREATED);
        initialOrder.setId(1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest();
        request.setOrderId(1);
        request.setApproved(false);

        useCase.run(request);

        final Order savedOrder = orderRepository.getSavedOrder();
        assertThat(savedOrder.getStatus()).isEqualTo(OrderStatus.REJECTED);
    }

    @Test
    public void cannotApproveRejectedOrder() {
        assertThatThrownBy(() -> {
            Order initialOrder = new Order();
            initialOrder.setStatus(OrderStatus.REJECTED);
            initialOrder.setId(1);
            orderRepository.addOrder(initialOrder);

            OrderApprovalRequest request = new OrderApprovalRequest();
            request.setOrderId(1);
            request.setApproved(true);

            useCase.run(request);

            assertThat(orderRepository.getSavedOrder()).isNull();
        }).isInstanceOf(RejectedOrderCannotBeApprovedException.class);
    }

    @Test
    public void cannotRejectApprovedOrder() {
        assertThatThrownBy(() -> {

            Order initialOrder = new Order();
            initialOrder.setStatus(OrderStatus.APPROVED);
            initialOrder.setId(1);
            orderRepository.addOrder(initialOrder);

            OrderApprovalRequest request = new OrderApprovalRequest();
            request.setOrderId(1);
            request.setApproved(false);

            useCase.run(request);

            assertThat(orderRepository.getSavedOrder()).isNull();
        }).isInstanceOf(ApprovedOrderCannotBeRejectedException.class);
    }

    @Test
    public void shippedOrdersCannotBeApproved() {
        assertThatThrownBy(() -> {
            Order initialOrder = new Order();
            initialOrder.setStatus(OrderStatus.SHIPPED);
            initialOrder.setId(1);
            orderRepository.addOrder(initialOrder);

            OrderApprovalRequest request = new OrderApprovalRequest();
            request.setOrderId(1);
            request.setApproved(true);

            useCase.run(request);

            assertThat(orderRepository.getSavedOrder()).isNull();
        }).isInstanceOf(ShippedOrdersCannotBeChangedException.class);
    }

    @Test
    public void shippedOrdersCannotBeRejected() {
        assertThatThrownBy(() -> {

            Order initialOrder = new Order();
            initialOrder.setStatus(OrderStatus.SHIPPED);
            initialOrder.setId(1);
            orderRepository.addOrder(initialOrder);

            OrderApprovalRequest request = new OrderApprovalRequest();
            request.setOrderId(1);
            request.setApproved(false);

            useCase.run(request);

            assertThat(orderRepository.getSavedOrder()).isNull();
        }).isInstanceOf(ShippedOrdersCannotBeChangedException.class);
    }
}
