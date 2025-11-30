// Visitor.java
public class Visitor extends Person {
    private String ticketType; // e.g., "Adult", "Child", "VIP"
    private double height;     // in centimeters

    public Visitor() {
        super();
        this.ticketType = "Adult";
        this.height = 0.0;
    }

    public Visitor(String id, String name, int age, String ticketType, double height) {
        super(id, name, age);
        this.ticketType = ticketType;
        this.height = height;
    }

    // getters & setters
    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    @Override
    public String toString() {
        return String.format("%s, Ticket:%s, Height:%.1fcm", super.toString(), ticketType, height);
    }
}
