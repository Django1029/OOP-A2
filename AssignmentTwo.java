// AssignmentTwo.java
import java.util.*;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo a2 = new AssignmentTwo();
        System.out.println("=== PART 3: Waiting Line Demo ===");
        a2.partThree();
        System.out.println("\n=== PART 4A: Ride History Demo ===");
        a2.partFourA();
        System.out.println("\n=== PART 4B: Sorting Demo ===");
        a2.partFourB();
        System.out.println("\n=== PART 5: Run One Cycle Demo ===");
        a2.partFive();
        System.out.println("\n=== PART 6: Export Demo ===");
        a2.partSix();
        System.out.println("\n=== PART 7: Import Demo ===");
        a2.partSeven();
        System.out.println("\n=== Demo complete ===");
    }

    // helper to create sample visitors with simple ids
    private Visitor makeVisitor(int idx) {
        return new Visitor("V" + idx, "Visitor" + idx, 10 + idx, (idx % 3 == 0 ? "VIP" : idx % 3 == 1 ? "Adult" : "Child"), 120 + idx);
    }

    public void partThree() {
        Ride ride = new Ride("Superman Escape", null, 4);
        // add minimum 5 visitors to queue
        for (int i = 1; i <= 5; i++) {
            Visitor v = makeVisitor(i);
            ride.addVisitorToQueue(v);
        }
        // remove a visitor
        ride.removeVisitorFromQueue();
        // print queue
        ride.printQueue();
    }

    public void partFourA() {
        Ride ride = new Ride("Superman Escape", null, 4);
        // add minimum 5 visitors to history (LinkedList)
        for (int i = 1; i <= 5; i++) {
            Visitor v = makeVisitor(i);
            ride.addVisitorToHistory(v);
        }
        // check if a visitor is in the collection
        Visitor check = makeVisitor(3); // note: different object but same field values -> contains uses equals of object (no override)
        // Because we didn't override equals(), contains will be false. To demonstrate both ways:
        System.out.println("Note: equals() not overridden, so contains() checks reference equality.");
        ride.checkVisitorFromHistory(check); // likely false

        // To check by ID manually:
        boolean foundById = false;
        for (Visitor v : new LinkedList<>(Arrays.asList(
                makeVisitor(1), makeVisitor(2), makeVisitor(3), makeVisitor(4), makeVisitor(5)
        ))) {
            if (v.getId().equals("V3")) foundById = true;
        }
        System.out.println("Manual check by id (example): foundById = " + foundById);

        // print number of visitors
        System.out.println("Number of visitors in history: " + ride.numberOfVisitors());
        // print all visitors (use iterator inside)
        ride.printRideHistory();
    }

    public void partFourB() {
        Ride ride = new Ride("Superman Escape", null, 4);
        // add minimum 5 visitors
        ride.addVisitorToHistory(new Visitor("V5", "Alice", 30, "Adult", 165));
        ride.addVisitorToHistory(new Visitor("V2", "Bob", 12, "Child", 140));
        ride.addVisitorToHistory(new Visitor("V4", "Cara", 25, "VIP", 170));
        ride.addVisitorToHistory(new Visitor("V1", "David", 40, "Adult", 180));
        ride.addVisitorToHistory(new Visitor("V3", "Eve", 18, "Adult", 160));

        System.out.println("Before sorting:");
        ride.printRideHistory();

        // sort using comparator (ticketType then age)
        ride.sortHistory(new RideVisitorComparator());

        System.out.println("After sorting:");
        ride.printRideHistory();
    }

    public void partFive() {
        Employee op = new Employee("E1", "Sam Operator", 28, "EMP001", "Operator");
        Ride ride = new Ride("Superman Escape", op, 4);
        // add minimum 10 visitors to queue
        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(makeVisitor(i));
        }
        System.out.println("-- Queue before running one cycle --");
        ride.printQueue();

        // run one cycle
        ride.runOneCycle();

        System.out.println("-- Queue after running one cycle --");
        ride.printQueue();

        System.out.println("-- Ride history after one cycle --");
        ride.printRideHistory();
    }

    public void partSix() {
        Ride ride = new Ride("Superman Escape", null, 4);
        // add minimum 5 visitors to history
        for (int i = 1; i <= 5; i++) {
            ride.addVisitorToHistory(makeVisitor(i));
        }
        String filename = "ride_history_export.csv";
        ride.exportRideHistory(filename);
        System.out.println("Exported to file: " + filename + " (in working directory)");
    }

    public void partSeven() {
        Ride ride = new Ride("Superman Escape", null, 4);
        String filename = "ride_history_export.csv";
        ride.importRideHistory(filename);
        System.out.println("Number imported: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
}
