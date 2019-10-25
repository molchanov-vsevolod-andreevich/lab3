import scala.Tuple2;

import java.io.Serializable;
import java.util.Map;

public class AirportsDelaysInfo implements Serializable {
    private String originAirportId;
    private String originAirportName;

    private String destAirportId;
    private String destAirportName;

    private DelaysInfo delays;

    public AirportsDelaysInfo(Tuple2<String, String> airportsPair, DelaysInfo delays, Map<String, String> airportsCodesToNames) {
        originAirportId = airportsPair._1();
        originAirportName = airportsCodesToNames.get(originAirportId);

        destAirportId = airportsPair._2();
        destAirportName = airportsCodesToNames.get(destAirportId);
    }
}
