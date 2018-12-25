package CodeWars;

public class HumanReadableTime {

    public static void main (String[] args) {
        System.out.println(makeReadable1(359999));
        System.out.println(makeReadable2(359999));
    }

    public static String makeReadable1(int seconds) {
        if (seconds < 60) {     // a minute
            return String.format(
                    "00:00:%02d",
                    seconds);
        }
        if (seconds < 3600) {    // an hour
            int minutes = seconds / 60;
            seconds = seconds % 60;
            return String.format(
                    "00:%02d:%02d",
                    minutes, seconds);
        } else {
            int hours = seconds / 3600;
            int minutes = (seconds / 60 ) % 60;
            seconds = seconds % 60;
            return String.format(
                    "%02d:%02d:%02d",
                    hours, minutes, seconds);
        }
    }

    public static String makeReadable2(int seconds) {
        return String.format(
                "%02d:%02d:%02d",
                seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }
}