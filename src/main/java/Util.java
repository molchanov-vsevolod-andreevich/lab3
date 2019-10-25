import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

public abstract class Util {
    public static final JavaRDD<String[]> parseCSVWithHeaderAndDelimiter(JavaRDD<String> csvFile, String delimiter) {
        String header = csvFile.first();
        JavaRDD<String> csvWithoutHeader = csvFile.filter(line -> !line.equals(header));
        
    }

    public static final Tuple2 getAirportsPair(String s) {

    }
}
