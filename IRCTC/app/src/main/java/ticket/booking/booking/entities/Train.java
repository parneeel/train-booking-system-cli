package ticket.booking.booking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)


public class Train {

    @JsonProperty("train_no")
    private String trainNumber;

    @JsonProperty("station_times")
    private Map<String, String> stationTime;

    @JsonProperty("stations")
    private List<String> stations;

    @JsonProperty("seats")
    private List<List<Integer>> seats;
    @JsonProperty("train_name")
    private String trainName;

    public Train() {
    }

    public Train(String trainName, String trainNumber, List<String> stations, List<List<Integer>> seats, Map<String, String> stationTime) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.stations = stations;
        this.seats = seats;
        this.stationTime = stationTime;
    }
    public String getTrainName() { return trainName; }
    public String getTrainNumber() { return trainNumber; }
    public List<String> getStations() { return stations; }
    public List<List<Integer>> getSeats() { return seats; }
    public Map<String, String> getStationTime() { return stationTime; }


}