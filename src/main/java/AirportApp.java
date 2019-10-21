import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AirportApp {
    SparkConf conf = new SparkConf().setAppName("lab3");
    JavaSparkContext sc = new JavaSparkContext(conf);

    JavaRDD<String> flightsInfo = sc.textFile("664600583_T_ONTIME_sample.csv");

    private static final void

    public static void main(String[] args) {
        initializeSpark();
    }
}
