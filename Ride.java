// Ride.java
import java.util.*;
import java.io.*;

public class Ride implements RideInterface {
    private String name;
    private Employee operator;         // ride operator (Employee)
    private int maxRider;              // how many visitors per cycle
    private int numOfCycles;           // how many times run
    private Queue<Visitor> waitingQueue;   // FIFO queue
    private LinkedList<Visitor> rideHistory; // history list

    public Ride() {
        this("Unnamed Ride", null, 4);
    }

    public Ride(String name, Employee operator, int maxRider) {
        this.name = name;
        this.operator = operator;
        this.maxRider = Math.max(1, maxRider);
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = Math.max(1, maxRider); }

    public int getNumOfCycles() { return numOfCycles; }

    // Queue operations
    @Override
    public void addVisitorToQueue(Visitor v) {
        if (v == null) {
            System.out.println("Cannot add null visitor.");
            return;
        }
        waitingQueue.offer(v);
        System.out.println("Added to queue: " + v);
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor v = waitingQueue.poll();
        if (v == null) {
            System.out.println("Queue is empty. No visitor removed.");
        } else {
            System.out.println("Removed from queue: " + v);
        }
        return v;
    }

    @Override
    public void printQueue() {
        System.out.println("Current waiting queue for '" + name + "':");
        if (waitingQueue.isEmpty()) {
            System.out.println("  (empty)");
            return;
        }
        int i = 1;
        for (Visitor v : waitingQueue) {
            System.out.println(String.format("  %d) %s", i++, v));
        }
    }

    // History operations (LinkedList)
    @Override
    public void addVisitorToHistory(Visitor v) {
        if (v == null) {
            System.out.println("Cannot add null to history.");
            return;
        }
        rideHistory.add(v);
        System.out.println("Added to history: " + v);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        boolean found = rideHistory.contains(v);
        System.out.println("Visitor " + (found ? "is" : "is NOT") + " in history: " + v);
        return found;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history for '" + name + "':");
        if (rideHistory.isEmpty()) {
            System.out.println("  (no history)");
            return;
        }
        Iterator<Visitor> it = rideHistory.iterator(); // must use Iterator per spec
        int i = 1;
        while (it.hasNext()) {
            Visitor v = it.next();
            System.out.println(String.format("  %d) %s", i++, v));
        }
    }

    // sorting using provided comparator
    public void sortHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted.");
    }

    // run one cycle
    @Override
    public void runOneCycle() {
        System.out.println("Attempting to run one cycle for '" + name + "'...");
        if (operator == null) {
            System.out.println("Cannot run ride: no operator assigned.");
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println("Cannot run ride: no visitors waiting.");
            return;
        }
        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        System.out.println("Operator: " + operator.getName() + " | Taking " + ridersThisCycle + " visitors this cycle.");
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor v = waitingQueue.poll();
            if (v != null) {
                rideHistory.add(v);
                System.out.println("  Rider: " + v.getName() + " took the ride.");
            }
        }
        numOfCycles++;
        System.out.println("Cycle completed. Total cycles run: " + numOfCycles);
    }

    // File export (CSV)
    public void exportRideHistory(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Visitor v : rideHistory) {
                // CSV: id,name,age,ticketType,height
                pw.printf("%s,%s,%d,%s,%.1f%n",
                        escapeCsv(v.getId()),
                        escapeCsv(v.getName()),
                        v.getAge(),
                        escapeCsv(v.getTicketType()),
                        v.getHeight());
            }
            System.out.println("Exported ride history to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    // File import (CSV)
    public void importRideHistory(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                // naive CSV split (no quoted commas handling)
                String[] parts = line.split(",", -1);
                if (parts.length >= 5) {
                    String id = unescapeCsv(parts[0]);
                    String name = unescapeCsv(parts[1]);
                    int age = Integer.parseInt(parts[2]);
                    String ticket = unescapeCsv(parts[3]);
                    double height = Double.parseDouble(parts[4]);
                    Visitor v = new Visitor(id, name, age, ticket, height);
                    rideHistory.add(v);
                    count++;
                }
            }
            System.out.println("Imported " + count + " visitors from file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Import file not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Data format error while importing: " + e.getMessage());
        }
    }

    // helpers to escape simple CSV (avoid commas in names)
    private String escapeCsv(String s) {
        if (s == null) return "";
        return s.replace(",", ""); // simple approach: remove commas
    }
    private String unescapeCsv(String s) {
        return s == null ? "" : s;
    }
}
