package ticket.booking.booking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class User {

    @JsonProperty("user_id")
    private String userid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("hashed_password")
    private String hashedpassword;

    @JsonProperty("tickets_booked")
    private List<Ticket> ticketsBooked;

    private String username;
    private int age;
    private String contact;
    private String aadharNumber;

    public User(String name, String hashedpassword, List<Ticket> ticketsBooked, String userid) {
        this.name = name;
        this.hashedpassword = hashedpassword;
        this.ticketsBooked = ticketsBooked;
        this.userid = userid;
    }

    public User() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getHashedpassword() { return hashedpassword; }
    public void setHashedpassword(String hashedpassword) { this.hashedpassword = hashedpassword; }
    public String getUserid() { return userid; }
    public void setUserid(String userid) { this.userid = userid; }
    public List<Ticket> getTicketsBooked() { return ticketsBooked; }
    public void setTicketsBooked(List<Ticket> ticketsBooked) { this.ticketsBooked = ticketsBooked; }

    public void printTickets() {
        ticketsBooked.forEach(ticket -> System.out.println(ticket));
    }
}