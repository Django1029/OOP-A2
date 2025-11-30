// RideVisitorComparator.java
import java.util.Comparator;

public class RideVisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1 == null && v2 == null) return 0;
        if (v1 == null) return -1;
        if (v2 == null) return 1;

        int cmp = v1.getTicketType().compareToIgnoreCase(v2.getTicketType());
        if (cmp != 0) return cmp;
        // tie-breaker: age
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
