public class Path<X> implements Admin<X, Path<X>>, Iterable<X> {
    private final MyList<X> elements;

    public Path() {
        elements = new MyList<>();
    }

    @Override
    public Path<X> add(X x) {
        if (!elements.contains(x)) {
            elements.add(x);
        }
        return this;
    }

    @Override
    public Path<X> remove(X x) {
        elements.remove(x);
        return this;
    }

    @Override
    public MyIterator<X> iterator() {
        return elements.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Path: ");
        MyIterator<X> it = elements.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(" -> ");
        }
        sb.append("null");
        return sb.toString();
    }
}
