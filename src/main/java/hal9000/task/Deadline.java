package hal9000.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected String by;
    protected LocalDateTime deadlineByDateTime;
    protected LocalDate deadlineByDate;

    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
        this.deadlineByDateTime = parseDateTime(by);
        this.deadlineByDate = parseDate(by);
        setTaskTypeChar('D');
    }

    @Override
    public String toString() {
        if (deadlineByDateTime != null) {
            return super.toString() + " (by: " + deadlineByDateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy, h:mma")) + ")";
        }
        else {
            if (deadlineByDate != null) {
                return super.toString() + " (by: " + deadlineByDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
            }
            return super.toString() + " (by: " + by + ")";
        }

    }
}
