import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class AirportApp {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flights = sc.textFile("664600583_T_ONTIME_sample.csv");
        JavaRDD<String> airports = sc.textFile("L_AIRPORT_ID.csv");
        JavaRDD<String[]> parsedAirports = Util.parseCSVWithHeaderAndDelimiter(airports, Common.AIRPORTS_DELIMITER);
//        JavaRDD<String> splittedAirportsRDD = Util.parseCSVWithHeaderAndDelimiter(airports);
//        JavaPairRDD<String, String> airportsCodesToNames = airports.mapToPair(s -> Util.getAirportsPair(s));
//        JavaRDD<String> splittedAirportsRDD = airportsRDD.map(s -> s.substring(s.indexOf('n')+1));
//        JavaRDD<String> splittedAirportsRDD = airports.flatMap(s -> CSVParser.parse(s, CSVFormat.RFC4180).getHeaderNames().iterator());
//        JavaRDD<String> i = airportsRDD.flatMap(s -> s += "!").iterator();
//        JavaPairRDD<String, String>
//        System.out.println(splittedAirportsRDD.collect());
//        List<String> l = splittedAirportsRDD.collect();
//        for (String elem : l) {
//            System.out.println(elem);
//        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        List<String> l = splittedAirportsRDD.collect();
        for (String elem : l) {
            System.out.println(elem);
        }
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
