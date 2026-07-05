package ticket.booking.Services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.booking.entities.Ticket;
import ticket.booking.booking.entities.Train;
import ticket.booking.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class UserBookingService {

    private User user;

    private List<User> userList;

    private static final String USER_PATH = "app/src/main/java/ticket/booking/localdb/users.json";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        loadUsers();
    }
    public UserBookingService()throws IOException{
        loadUsers();
    }
    public List<User> loadUsers() throws IOException{
        File users = new File(USER_PATH);
        userList=  OBJECT_MAPPER.readValue(users, new TypeReference<List<User>>() {}) ;
    return userList;
    }



    public Boolean loginUser() {
        Optional<User> foundUser = userList.stream()
                .filter(user1 ->
                        user1.getName().equals(user.getName()) &&
                                UserServiceUtil.checkPassword(
                                        user.getHashedpassword(),
                                        user1.getHashedpassword()))
                .findFirst();

        if (foundUser.isPresent()) {
            user = foundUser.get();   // ⭐ Actual JSON user assign
            return true;
        }

        return false;
    }

    public Boolean signUp(User user1) throws IOException{
        userList.add(user1);
        OBJECT_MAPPER.writeValue(new File(USER_PATH), userList);
        return Boolean.TRUE;
    }

    public void fetchBooking(){
        user.printTickets();
    }

    public Boolean cancelTicket(String ticketId) throws IOException {
        Optional<Ticket> foundTicket = user.getTicketsBooked().stream().filter(Ticket -> Ticket.getTicketId().equals(ticketId)).findFirst();
        if (foundTicket.isPresent()) {
            user.getTicketsBooked().remove(foundTicket.get());
            OBJECT_MAPPER.writeValue(new File(USER_PATH), userList);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public Boolean bookTrainSeat(Train train, int row, int col) throws IOException {

        int seatAvailable = train.getSeats().get(row).get(col);

        if (seatAvailable != 0) {
            return false;
        }

        // Book seat
        train.getSeats().get(row).set(col, 1);
        TrainService trainService = new TrainService();
        trainService.updateTrain(train);

        // Save booked seat
        List<Integer> bookedSeats = new ArrayList<>();
        bookedSeats.add(row);
        bookedSeats.add(col);

        Ticket ticket = new Ticket(
                UUID.randomUUID().toString(),
                "Valid",
                new Date(),
                train,
                bookedSeats,
                new ArrayList<>()
        );

        user.getTicketsBooked().add(ticket);

        OBJECT_MAPPER.writeValue(new File(USER_PATH), userList);

        return true;
    }

}






















