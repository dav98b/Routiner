package network.thezone.routiner.core;

import org.testng.annotations.Test;

import java.time.LocalDate;

public class ActivityTest {

    @Test
    public void checkScheduling() {
        //anchored to a Monday, scheduled on Monday(1), Wednesday(3), Thursday(4)
        Activity activity = new Activity(new int[]{1, 3, 4}, LocalDate.parse("2021-01-18"));
        //test on Monday
        assert activity.isScheduled(LocalDate.parse("2021-01-25"));
    }
}
