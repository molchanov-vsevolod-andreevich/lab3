import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

public abstract class Util {
    public static final JavaRDD<String> parseCSVWithHeader(JavaRDD<String> csvFile) {
        String header = csvFile.first();
        return csvFile.filter(line -> !line.equals(header));
    }

    public static final Tuple2 getAirportsPair(String s) {
        
    }
}
