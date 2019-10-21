import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class WordReducer extends Reducer<Text, CsvWritable, Text, FloatWritable> {
    @Override
    protected void reduce(Text key, Iterable<CsvWritable> values, Context context) throws
            IOException, InterruptedException {
        float time = 0f;
        float count = 0f;
        for (CsvWritable t : values) {
            count++;
            time += Float.parseFloat(t.toString());
        }
        float res = time / count;
        context.write(key, new FloatWritable(res));
    }
}
