package ticket.booking.Services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.booking.entities.Ticket;
import ticket.booking.booking.entities.Train;
import ticket.booking.booking.entities.User;
import ticket.booking.util.UserServiceUtil;
import java.util.stream.Collectors;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TrainService {

    private List<Train> trainList;

    private static final String TRAIN_PATH = "app/src/main/java/ticket/booking/localdb/trains.json";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public void saveTrains() throws IOException {
        OBJECT_MAPPER.writeValue(new File(TRAIN_PATH), trainList);
    }
    public void updateTrain(Train updatedTrain) throws IOException {

        for (int i = 0; i < trainList.size(); i++) {

            if (trainList.get(i).getTrainNumber().equals(updatedTrain.getTrainNumber())) {
                trainList.set(i, updatedTrain);
                break;
            }
        }

        saveTrains();
    }

    public TrainService()throws IOException{
        loadTrains();
    }
    public List<Train> loadTrains() throws IOException{
        File trains = new File(TRAIN_PATH);
        trainList = OBJECT_MAPPER.readValue(trains, new TypeReference<List<Train>>() {
        });
        return trainList;
    }
    public List<Train> searchTrains(String source, String destination){
        return trainList.stream().filter(t->t.getStations().contains(source)&& t.getStations().contains(destination) && t.getStations().indexOf(source)<t.getStations().indexOf(destination)).collect(Collectors.toList());

    }

}























