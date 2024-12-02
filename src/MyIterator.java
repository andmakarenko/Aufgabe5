import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {
    private MyList.Node<E> current;    // Der aktuelle Knoten
    private MyList.Node<E> previous;  // Der vorherige Knoten
    private MyList.Node<E> lastReturned; // Der zuletzt zurückgegebene Knoten
    private final MyList<E> list;     // Referenz auf die Liste, um Änderungen vorzunehmen

    public MyIterator(MyList<E> list) {
        this.current = list.getHead(); // Start bei Kopf der Liste
        this.previous = null;
        this.lastReturned = null;
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        if (current == null) {
            throw new IllegalStateException("No more elements to iterate over");
        }

        lastReturned = current; // Speichere den Knoten, der zurückgegeben wird
        previous = current;     // Aktualisiere den vorherigen Knoten
        current = current.next; // Gehe zum nächsten Knoten
        return lastReturned.data;
    }

    @Override
    public void remove() {
        if (lastReturned == null) {
            throw new IllegalStateException("remove() called before next() or after already removed");
        }

        if (lastReturned == list.getHead()) {
            // Entferne den Kopf der Liste
            list.removeHead();
        } else {
            // Entferne den aktuellen Knoten
            if (previous != null) {
                previous.next = current;
            }
        }

        // Markiere den Knoten als entfernt
        lastReturned = null;
        list.decrementSize(); // Aktualisiere die Größe der Liste
    }
}
