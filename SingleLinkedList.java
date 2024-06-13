public class SingleLinkedList {
    private Node head;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertFirst(TransaksiRental data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
        }
    }

    public void sortListByNoTNKB() {
        if (size <= 1) {
            return; // No need to sort if there's 0 or 1 element
        }

        Node current = head;
        Node index = null;
        TransaksiRental temp;

        while (current != null) {
            index = current.getNext();

            while (index != null) {
                // Swap nodes if the current node's TNKB is greater than index's TNKB
                if (current.getData().getNoTNKB().compareTo(index.getData().getNoTNKB()) > 0) {
                    temp = current.getData();
                    current.setData(index.getData());
                    index.setData(temp);
                }

                index = index.getNext();
            }

            current = current.getNext();
        }
    }
}
