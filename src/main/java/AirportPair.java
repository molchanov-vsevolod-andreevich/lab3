import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportPair implements WritableComparable {
    Text AIRPORT_ID;
    IntWritable INPUT_ID;

    public AirportPair(Text airportID, IntWritable inputID) {
        AIRPORT_ID = airportID;
        INPUT_ID = inputID;
    }

    public AirportPair(Text airportID, int inputID) {
        AIRPORT_ID = airportID;
        INPUT_ID = new IntWritable(inputID);
    }

    public AirportPair(String airportID, IntWritable inputID) {
        AIRPORT_ID = new Text(airportID);
        INPUT_ID = inputID;
    }

    public AirportPair(String airportID, int inputID) {
        AIRPORT_ID = new Text(airportID);
        INPUT_ID = new IntWritable(inputID);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        AIRPORT_ID.write(out);
        INPUT_ID.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        AIRPORT_ID.readFields(in);
        INPUT_ID.readFields(in);
    }

    @Override
    public int compareTo(Object o) {
//        int thisValue = this.value;
//        int thatValue = o.value;
//        return (thisValue < thatValue ? -1 : (thisValue==thatValue ? 0 : 1));
        return 0;
    }

    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + counter;
//        result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
//        return result;
        return super.hashCode();
    }
}

