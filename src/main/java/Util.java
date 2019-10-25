import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

import java.util.Map;

public abstract class Util {
    public static final JavaRDD<String> removeHeader(JavaRDD<String> csvFile) {
        String header = csvFile.first();
        return csvFile.filter(line -> !line.equals(header));
    }

    public static final Tuple2 getAirportsPair(String s) {

    }

    public static final Map<String, String> parseAirports(JavaRDD<String> airportsCSV) {
        JavaRDD<String> airportsWithoutHeader = Util.removeHeader(airportsCSV);
        
    }
}
