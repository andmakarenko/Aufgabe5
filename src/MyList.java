public class MyList<E> {
    static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private int size;

    public MyList() {
        this.head = null;
        this.size = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public void removeHead() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public boolean remove(E element) {
        if (head == null) {
            return false; // Liste ist leer
        }

        // Überprüfe, ob das zu entfernende Element am Kopf der Liste ist
        if (head.data.equals(element)) {
            head = head.next; // Kopf entfernen
            size--;
            return true;
        }

        // Durchlaufe die Liste und suche nach dem Element
        Node<E> current = head;
        while (current.next != null) {
            if (current.next.data.equals(element)) {
                // Überspringe den zu entfernenden Knoten
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false; // Element nicht gefunden
    }

    public void decrementSize() {
        size--;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean contains(E element) {
        Node<E> current = head; // Beginne beim Kopf der Liste
        while (current != null) {
            if (current.data.equals(element)) { // Vergleiche das aktuelle Element mit dem gesuchten
                return true; // Element gefunden
            }
            current = current.next; // Gehe zum nächsten Knoten
        }
        return false; // Element nicht gefunden
    }

    public int size() {
        return size;
    }

    public MyIterator<E> iterator() {
        return new MyIterator<>(this);
    }
}
