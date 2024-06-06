package time;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * Time class to handle time operations and display current times in different zones.
 */
public class Time {
    private int hours;   // Hours
    private int minutes; // Minutes
    private int seconds; // Seconds

    // Constructor to initialize the Time object
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Getters and setters for the Time object
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    // Method to display the time
    public void displayTime() {
        System.out.println("Time: " + hours + ":" + minutes + ":" + seconds);
    }

    // Method to add another Time object to the current Time object
    public Time addTime(Time otherTime) {
        int totalSeconds = seconds + otherTime.getSeconds();
        int additionalMinutes = totalSeconds / 60;
        int remainingSeconds = totalSeconds % 60;

        int totalMinutes = minutes + otherTime.getMinutes() + additionalMinutes;
        int additionalHours = totalMinutes / 60;
        int remainingMinutes = totalMinutes % 60;

        int totalHours = hours + otherTime.getHours() + additionalHours;

        return new Time(totalHours, remainingMinutes, remainingSeconds);
    }

    // Main method to test the Time class
    public static void main(String[] args) {
        // Create a map of time zones for different regions
        Map<String, String> timeZones = new HashMap<>();
        timeZones.put("African Time", "Africa/Johannesburg");
        timeZones.put("American Time", "America/New_York");
        timeZones.put("European Time", "Europe/London");
        timeZones.put("Asian Time", "Asia/Tokyo");
        timeZones.put("Australian Time", "Australia/Sydney");

        // Display the current time in different regions
        for (Map.Entry<String, String> entry : timeZones.entrySet()) {
            ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of(entry.getValue()));
            System.out.println(entry.getKey() + ": " + currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }

        // Example of using the Time class
        Time t1 = new Time(10, 30, 45);
        Time t2 = new Time(2, 15, 20);

        // Display the initial times
        t1.displayTime();
        t2.displayTime();

        // Add t2 to t1
        Time sum = t1.addTime(t2);

        // Display the sum of the times
        sum.displayTime();
    }
}
