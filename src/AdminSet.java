public class AdminSet<X extends Approvable<P, T>, P, T> extends ApSet<X, P, T> {
    public void extend() {
        for (MyIterator<P> critIt = criterions(); critIt.hasNext(); ) {
            P p = critIt.next();
            for (MyIterator<X> entryIt = iterator(p); entryIt.hasNext(); ) {
                X x = entryIt.next();
                T approved = x.approved(p);
                if (approved instanceof Admin) {
                    @SuppressWarnings("unchecked")
                    Admin<X, T> admin = (Admin<X, T>) approved;
                    x.approve(p, admin.add(x));
                }
            }
        }
    }

    public void shorten() {
        for (MyIterator<P> critIt = criterions(); critIt.hasNext(); ) {
            P p = critIt.next();
            for (MyIterator<X> entryIt = iterator(p); entryIt.hasNext(); ) {
                X x = entryIt.next();
                T approved = x.approved(p);
                if (approved instanceof Admin) {
                    @SuppressWarnings("unchecked")
                    Admin<X, T> admin = (Admin<X, T>) approved;
                    x.approve(p, admin.remove(x));
                }
            }
        }
    }
}
