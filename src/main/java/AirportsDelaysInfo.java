import java.io.Serializable;

public class AirportsDelaysInfo implements Serializable {
    private String originAirportId;
    private String originAirportName;

    private String destAirportId;
    private String destAirportName;

    private DelaysInfo delays;

    public AirportsDelaysInfo(Tuple2<String, String>, DelaysInfo) {

    }
}
