import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CsvWritable implements Writable {
    private Text RECORDS;

    public CsvWritable(Text records) {
        RECORDS = records;
    }

    public CsvWritable(String records) {
        RECORDS = new Text(records);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        RECORDS.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        RECORDS.readFields(in);
    }

//    public static CsvWritable read(DataInput in) throws IOException {
//        CsvWritable w = new CsvWritable();
//        w.readFields(in);
//        return w;
//    }
    @Override
    public String toString() {
        return RECORDS.toString();
    }
}
