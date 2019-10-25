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
            if (nextDelay.isEmpty() || nextDelay.equals("0.00")) {
                numOfDelaysAndCancels++;
            } else {
                float delay = Float.parseFloat(nextDelay);
                if (delay > max) {
                    max = delay;
                }
            }
            
        }
    }

    @Override
    public String toString() {
        return "maximal delay: " + maxDelay + "; percentage of delayed and canceled flights: " + delayAndCancelPercentage + "%";
    }
}
