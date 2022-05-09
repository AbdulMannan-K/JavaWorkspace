package data.info;

import java.time.LocalDate;

public class SMDate extends Info {
    @Override
    protected boolean validate(CharSequence chars) {
        return true;
    }

    public final LocalDate getDate() {
        String[] date = get().split("/");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        return LocalDate.of(year, month, day);
    }
}