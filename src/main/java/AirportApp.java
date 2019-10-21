import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
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

        JavaRDD<String> flightsRDD = sc.textFile("664600583_T_ONTIME_sample.csv");
        JavaRDD<String> airportsRDD = sc.textFile("L_AIRPORT_ID.csv");

//        JavaRDD<String> splittedAirportsRDD = airportsRDD.flatMap(s -> Arrays.stream(s.substring(s.indexOf('\n')+1).replace("\"", "").replace(",", ";").split("\n")).iterator());
        JavaRDD<String> splittedAirportsRDD = airportsRDD.flatMap(s -> Arrays.stream(CSVParser.parse(s, CSVFormat.RFC4180).getRecords().toArray()).iterator());
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
