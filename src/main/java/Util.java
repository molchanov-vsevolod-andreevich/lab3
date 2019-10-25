import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

public abstract class Util {
    public static final JavaRDD<String> removeCSVHeader(JavaRDD<String> csvFile) {
        String header = csvFile.first();
        return csvFile.filter(line -> !line.equals(header));
    }

    public static final String[] parseCSVLineWithDelimiter(String line, String delimiter) {
        String[] records = line.split(delimiter);
        for (int i = 0; i < records.length; i++) {
            records[i] = records[i].replaceAll("\"", "");
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

    public static final JavaPairRDD<Tuple2<String, String>, DelaysInfo> parseFlights(JavaRDD<String> flightsCSV) {
        JavaRDD<String> flightsWithoutHeader = Util.removeCSVHeader(flightsCSV);

        JavaPairRDD<Tuple2<String, String>, Iterable<String>> airportsPairsDelaysInfo = flightsWithoutHeader.mapToPair(line -> {
            String[] records = Util.parseCSVLineWithDelimiter(line, Common.FLIGHTS_DELIMITER);
            return new Tuple2<>(new Tuple2<>(records[Common.CSV_ORIGIN_AIRPORT_ID_INDEX], records[Common.CSV_DEST_AIRPORT_ID_INDEX]), records[Common.CSV_DELAY_INDEX]);
        }).groupByKey().sortByKey(new TupleComparator());

        return airportsPairsDelaysInfo.mapValues(delays -> new DelaysInfo(delays));
    }

    static class TupleComparator implements Comparator<Tuple2<String, String>>, Serializable {
        @Override
        public int compare(Tuple2<String, String> o1, Tuple2<String, String> o2) {
            int res = o1._1().compareTo(o2._1());
            if (res == 0) {
                res = o1._2().compareTo(o2._2());
            }
            return res;
        }
    }
}
