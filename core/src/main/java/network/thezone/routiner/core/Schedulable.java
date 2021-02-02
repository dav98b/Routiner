package network.thezone.routiner.core;

import java.time.LocalDate;

public interface Schedulable {

    boolean isScheduled(LocalDate date);
}
