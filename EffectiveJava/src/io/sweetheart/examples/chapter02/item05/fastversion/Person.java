package io.sweetheart.examples.chapter02.item05.fastversion;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = new Date(birthDate.getTime());
    }

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = cal.getTime();
        cal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = cal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }
}
