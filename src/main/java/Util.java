import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

import java.util.Map;

public abstract class Util {
    public static final JavaRDD<String> removeHeader(JavaRDD<String> csvFile) {
        String header = csvFile.first();
        return csvFile.filter(line -> !line.equals(header));
    }

    public static final String[] parseCSVLineWithDelimiter(String line, String delimiter) {
        String[] records = line.split(delimiter);
        for (String record : records) {
            record = record.replaceAll("\"", "");
        }
        return records;
    }

    public static final Map<String, String> parseAirports(JavaRDD<String> airportsCSV) {
        JavaRDD<String> airportsWithoutHeader = Util.removeHeader(airportsCSV);
        JavaPairRDD<String, String> airportsPairs = airportsWithoutHeader.mapToPair(s -> {
            String[] records = Util.parseCSVLineWithDelimiter(s, Common.AIRPORTS_DELIMITER);
            return new Tuple2<>(records[Common.CSV_AIRPORT_ID_INDEX], records[Common.CSV_AIRPORT_NAME_INDEX]);
        });
        return airportsPairs.collectAsMap();
    }

    public static final JavaPairRDD<Tuple2<String, String>, String> parseFlights(JavaRDD<String> flightsCSV) {
        
    }
}
