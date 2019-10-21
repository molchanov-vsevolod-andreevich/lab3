import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class AirportApp {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flightsRDD = sc.textFile("664600583_T_ONTIME_sample.csv");
        JavaRDD<String> airportsRDD = sc.textFile("L_AIRPORT_ID.csv");

        JavaRDD<String> splittedAirportsRDD = airportsRDD.flatMap(s -> Arrays.stream(s.split(",")).iterator());
        
    }
}
