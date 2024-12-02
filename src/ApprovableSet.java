public interface ApprovableSet<X extends Approvable<P, T>, P, T> extends Iterable<X> {
    void add(X x);
    void addCriterion(P p);
    MyIterator<X> iteratorAll();
    MyIterator<X> iterator(P p);
    MyIterator<X> iteratorNot(P p);
    MyIterator<P> criterions();
}
