public class Node {
    private TransaksiRental data;
    private Node next;

    public Node(TransaksiRental data) {
        this.data = data;
        this.next = null;
    }

    public TransaksiRental getData() {
        return data;
    }

    public void setData(TransaksiRental data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
