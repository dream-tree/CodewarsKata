package cw;

public class SetAlarm {

    public static void main(String[] args) {
        System.out.println(setAlarm(true, false));
        System.out.println(setAlarm(true, true));
        System.out.println(setAlarm(false, true));
        System.out.println(setAlarm(false, false));
    }

    public static boolean setAlarm(boolean employed, boolean vacation) {
        return employed && !vacation;
    }

    public static boolean setAlarm2(boolean employed, boolean vacation) {
        if (employed) {
            if (!vacation) {
                return true;
            }
        }
        return false;
    }
}

