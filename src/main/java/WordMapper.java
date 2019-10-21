import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.commons.lang3.StringUtils;

public class WordMapper extends Mapper<LongWritable, CsvWritable, Text, CsvWritable> {

    @Override
    protected void map(LongWritable key, CsvWritable value, Context context) throws IOException, InterruptedException {
//        CSVParser parser = CSVParser.parse(value.toString(), CSVFormat.RFC4180);
//        for (CSVRecord csvRecord : parser) {
//            String del = csvRecord.get(18);
//            if (!del.equals("")) {
////                System.out.println(csvRecord.get(14) + " : " + del);
//                context.write(new Text(csvRecord.get(14)), new Text(del));
//            }
//        }
        String[] records = value.toString().split(",");
        if (!records[18].equals("")) {
            System.out.println(records[14] + " : " + records[18]);
            context.write(new Text(records[14]), new CsvWritable(records[18]));
        }
    }
}
