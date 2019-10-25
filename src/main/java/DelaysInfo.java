import java.io.Serializable;
import java.util.Iterator;

public class DelaysInfo implements Serializable {
    private float maxDelay;
    private float delayAndCancelPercentage;

    public float getMaxDelay() {
        return maxDelay;
    }

    public float getDelayAndCancelPercentage() {
        return delayAndCancelPercentage;
    }

    public DelaysInfo(Iterable<String> delays) {
        Iterator<String> it = delays.iterator();
        float max = Float.MIN_VALUE;
        float numOfFlights = 0f;
        float numOfDelaysAndCancels = 0f;
        while (it.hasNext()) {
            numOfFlights++;
            String nextDelay = it.next().toString();
            if (nextDelay.isEmpty() || nextDelay.equals(0.00))
            time += nextDelay;
            if (nextDelay != 0f) {
                if (nextDelay > max) {
                    max = nextDelay;
                }
                if (nextDelay < min) {
                    min = nextDelay;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "maximal delay: " + maxDelay + "; percentage of delayed and canceled flights: " + delayAndCancelPercentage + "%";
    }
}
