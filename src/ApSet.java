public class ApSet<X extends Approvable<P, T>, P, T> implements ApprovableSet<X, P, T> {
    private final MyList<X> entries = new MyList<>();
    private final MyList<P> criteria = new MyList<>();

    @Override
    public void add(X x) {
        entries.add(x);
    }

    @Override
    public void addCriterion(P p) {
        criteria.add(p);
    }

    @Override
    public MyIterator<X> iteratorAll() {
        return entries.iterator();
    }

    @Override
    public MyIterator<X> iterator(P p) {
        MyList<X> filtered = new MyList<>();
        MyIterator<X> it = entries.iterator();
        while (it.hasNext()) {
            X x = it.next();
            if (x.approved(p) != null) {
                filtered.add(x);
            }
        }
        return filtered.iterator();
    }

    @Override
    public MyIterator<X> iteratorNot(P p) {
        MyList<X> filtered = new MyList<>();
        MyIterator<X> it = entries.iterator();
        while (it.hasNext()) {
            X x = it.next();
            if (x.approved(p) == null) {
                filtered.add(x);
            }
        }
        return filtered.iterator();
    }

    @Override
    public MyIterator<P> criterions() {
        return criteria.iterator();
    }

    @Override
    public MyIterator<X> iterator() {
        MyList<X> filtered = new MyList<>();
        MyIterator<X> it = entries.iterator();
        while (it.hasNext()) {
            X x = it.next();
            boolean allApproved = true;
            MyIterator<P> critIt = criteria.iterator();
            while (critIt.hasNext()) {
                if (x.approved(critIt.next()) == null) {
                    allApproved = false;
                    break;
                }
            }
            if (allApproved) {
                filtered.add(x);
            }
        }
        return filtered.iterator();
    }
}
