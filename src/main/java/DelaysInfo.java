import java.io.Serializable;

public class DelaysInfo implements Serializable {
    private float maxDelay;
    private float delayAndCancelPercentage;

    public float getMaxDelay() {
        return maxDelay;
    }

    public float getDelayAndCancelPercentage() {
        return delayAndCancelPercentage;
    }

    public DelaysInfo(Iterable<String> delaysInString) {
        
    }

    @Override
    public String toString() {
        return "maximal delay: " + maxDelay + "; percentage of delayed and canceled flights: " + delayAndCancelPercentage + "%";
    }
}
