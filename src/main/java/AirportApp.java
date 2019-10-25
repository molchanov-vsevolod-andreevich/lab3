import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AirportApp {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flightsCSV = sc.textFile("664600583_T_ONTIME_sample.csv");
        JavaRDD<String> airportsCSV = sc.textFile("L_AIRPORT_ID.csv");

        Map<String, String> airportsCodesToNames = Util.parseAirports(airportsCSV);
        JavaPairRDD<Tuple2<String, String>, String> airportsPairsDelaysInfo = Util.parseFlights(flightsCSV);
        JavaPairRDD<Tuple2<String, String>, String> res = airportsPairsDelaysInfo.reduceByKey((a, b) -> {
            return a + b;
        });


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
