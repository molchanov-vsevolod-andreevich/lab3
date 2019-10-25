import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
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
//        JavaPairRDD<Tuple2<String, String>, String> res = airportsPairsDelaysInfo.reduceByKey((a, b) -> a + " " + b);
        JavaPairRDD<Tuple2<String, String>, Iterable<String>> res = airportsPairsDelaysInfo.groupByKey().sortByKey(new TupleComparator(), true);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        JavaPairRDD<String, String> airportsPairsDelaysInfo = Util.parseFlights(flightsCSV);
//        Map<String, String> m = airportsPairsDelaysInfo.collectAsMap();
//        airportsPairsDelaysInfo.foreach(v -> System.out.println(v._1() + " : " + v._2()));
//        Map<Tuple2<String, String>, Iterable<String>> m = res.collectAsMap();
//        m.forEach((k, v) -> System.out.println(k + " => " + v));
        res.foreach(rdd -> {
            System.out.println(rdd);
        });
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    static class TupleComparator implements Comparator<Tuple2<String, String>>, Serializable {
        @Override
        public int compare(Tuple2<String, String> o1, Tuple2<String, String> o2) {
            int res = o1._1().compareTo(o2._1());
            if (res == 0) {
                res = o1._2().compareTo(o2._2());
            }
            System.out.println("COMPARE: " + o1 + " : " + o2 + " => " + res);
            return res;
        }
    }
}
