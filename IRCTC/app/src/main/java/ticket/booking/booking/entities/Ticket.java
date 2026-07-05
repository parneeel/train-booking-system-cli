package ticket.booking.booking.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {


    private String ticketId;
    private String validity;
    private Date date;
    private Train train;
    private List<Integer> bookedSeats;
    private List<User> passengers;

    public Ticket(String ticketId, String validity, Date date, Train train, List<Integer> bookedSeats, List<User> passengers) {
        this.ticketId = ticketId;
        this.validity = validity;
        this.date = date;
        this.train = train;
        this.bookedSeats = bookedSeats;
        this.passengers = passengers;
    }
    public Ticket() {}
    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", validity='" + validity + '\'' +
                ", date=" + date +
                ", train=" + train.getTrainName() +
                ", trainNumber=" + train.getTrainNumber() +
                ", bookedSeats=" + bookedSeats +
                '}';
    }
}

