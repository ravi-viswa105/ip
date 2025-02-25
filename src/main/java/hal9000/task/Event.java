package hal9000.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected String from;
    protected String to;
    protected LocalDateTime eventFromDateTime;
    protected LocalDate eventFromDate;
    protected LocalDateTime eventToDateTime;
    protected LocalDate eventToDate;


    /**
     * Constructs an event task
     * @param taskName Name of event task
     * @param from From date of event task
     * @param to To date of event task
     */
    public Event(String taskName, String from, String to) {
        super(taskName);
        this.from = from;
        this.to = to;
        this.eventFromDateTime = parseDateTime(from);
        this.eventFromDate = parseDate(from);
        this.eventToDateTime = parseDateTime(to);
        this.eventToDate = parseDate(to);
        setTaskTypeChar('E');
    }

    /**
     * Converts event task to string
     * @return event task in string
     */
    @Override
    public String toString() {
        String formattedFrom;
        String formattedTo;
        if (eventFromDateTime != null) {
            formattedFrom = eventFromDateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy, h:mma"));
        } else if (eventFromDate != null) {
            formattedFrom = eventFromDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        } else {
            formattedFrom = from;
        }
        if (eventToDateTime != null) {
            formattedTo = eventToDateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy, h:mma"));
        } else if (eventToDate != null) {
            formattedTo = eventToDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        } else {
            formattedTo = to;
        }
        return super.toString() + " (from: " + formattedFrom + " to: " + formattedTo + ")";
    }
}
