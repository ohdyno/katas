package given.when.then;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

/**
 * MyList can hold a collection of generic objects. The objects are ordered the same as the order they are added to the
 * list.
 */
public class MyList {
    /*
     * Implementing list functionality using LinkedList implementation
     */
    private Node head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Object item) {
        final Node node = new Node(item);
        node.next(head);
        head = node;
    }

    private <T> T reduce(BiFunction<Node, T, T> reducer, T initial) {
        Node node = head;
        T result = initial;
        while (node != null) {
            result = reducer.apply(node, result);
            node = node.next();
        }
        return result;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        AtomicInteger size = new AtomicInteger();
        reduce((node, _ignored) -> size.getAndIncrement(), null);
        return size.get();
    }

    private Optional<Node> find(Object item) {
        return reduce((node, found) -> {
            if (found.isEmpty()) {
                if (node.contains(item)) {
                    return Optional.of(node);
                }
            }
            return found;
        }, Optional.empty());
    }

    /**
     * Check if the list contains item.
     *
     * Relies on the .equals to identify if stored item is equal to item.
     *
     * @param item The item to look for within the list
     * @return if the list contains the item
     */
    public boolean contains(Object item) {
        return find(item).isPresent();
    }

    public void remove(Object item) {
        find(item).ifPresent(Node::delete);
    }

    private static class Node {
        private final Object item;
        private Node next;
        private Node previous;

        public Node(Object item) {
            this.item = item;
        }

        public void next(Node node) {
            next = node;
            if (node != null) {
                node.previous = this;
            }
        }

        public Node next() {
            return next;
        }

        public boolean contains(Object item) {
            return this.item.equals(item);
        }

        public void delete() {
            if (previous != null) {
                previous.next = next;
            }
            if (next != null) {
                next.previous = previous;
            }
        }
    }
}
