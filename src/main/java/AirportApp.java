import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AirportApp {
    SparkConf conf = new SparkConf().setAppName("lab3");
    JavaSparkContext sc = new JavaSparkContext(conf);

    JavaRDD<String> distFile = sc.textFile("");
}
