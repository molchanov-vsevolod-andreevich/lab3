import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

import java.util.Map;

public abstract class Util {
    public static final JavaRDD<String> removeCSVHeader(JavaRDD<String> csvFile) {
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
        JavaRDD<String> airportsWithoutHeader = Util.removeCSVHeader(airportsCSV);
        JavaPairRDD<String, String> airportsPairs = airportsWithoutHeader.mapToPair(line -> {
            String[] records = Util.parseCSVLineWithDelimiter(line, Common.AIRPORTS_DELIMITER);
            return new Tuple2<>(records[Common.CSV_AIRPORT_ID_INDEX], records[Common.CSV_AIRPORT_NAME_INDEX]);
        });
        return airportsPairs.collectAsMap();
    }

    public static final JavaPairRDD<Tuple2<String, String>, String> parseFlights(JavaRDD<String> flightsCSV) {
        JavaRDD<String> flightsWithoutHeader = Util.removeCSVHeader(flightsCSV);
        JavaPairRDD<Tuple2<String, String>, String> airportsPairsDelayInfo = flightsWithoutHeader.mapToPair(line -> {
            String[] records = Util.parseCSVLineWithDelimiter(line, Common.FLIGHTS_DELIMITER);
            return new Tuple2<>(new Tuple2<>(records[Common.CSV_ORIGIN_AIRPORT_ID_INDEX], records[Common.CSV_DEST_AIRPORT_ID_INDEX]), records[Common.CSV_DELAY_INDEX]);
        });
    }
}
