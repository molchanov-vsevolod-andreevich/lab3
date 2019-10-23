import org.apache.spark.api.java.JavaRDD;

public abstract class Util {
    public static final JavaRDD<String> parseCSVWithHeader(JavaRDD<String> csvFile) {
        String header = csvFile.first();
        return csvFile.filter()
    }
}
