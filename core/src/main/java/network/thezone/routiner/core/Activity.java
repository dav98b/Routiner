package network.thezone.routiner.core;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Activity implements Schedulable {

    /*
     * timeAnchorPoint is used to keep track of the actual day of the week
     * which is considered step 1 in pattern.
     * i.e if timeAnchorPoint is set to any Monday, then [1, 3, 5] as pattern
     * would mean Monday, Wednesday, Friday
     */
    private LocalDate timeAnchorPoint;

    private int cycleLength = Calendar.DAY_OF_WEEK;
    private Set<Integer> pattern = new HashSet<>();

    Activity(int[] pattern, LocalDate timeAnchorPoint) {
        this.timeAnchorPoint = timeAnchorPoint;
        for (int step : pattern)
            this.pattern.add(step);
    }

    private Activity(int cycleLength, int[] pattern, LocalDate timeAnchorPoint) {
        this(pattern, timeAnchorPoint);
        this.cycleLength = cycleLength;
    }

    //idea: using factory methods to return
    public static Activity weeklyCycle(int[] pattern, LocalDate timeAnchorPoint) {
        //return new Activity(pattern, timeAnchorPoint);
        return new Area(pattern, timeAnchorPoint);
    }

    public static Activity customCycle(int cycleLength, int[] pattern, LocalDate timeAnchorPoint) {
        return new Activity(cycleLength, pattern, timeAnchorPoint);
    }

    @Override
    public boolean isScheduled(LocalDate date) {
        long daysOffset = ChronoUnit.DAYS.between(timeAnchorPoint, date) + 1;
        int cycleIndex = (int) daysOffset % cycleLength;
        return pattern.contains(cycleIndex);
    }

}
