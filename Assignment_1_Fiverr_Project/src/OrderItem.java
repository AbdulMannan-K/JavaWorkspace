public class OrderItem<T extends Product> {
    public final T item;
    public final int id;

    public OrderItem(int id, T item) {
        this.id = id;
        this.item = item;
    }
}
