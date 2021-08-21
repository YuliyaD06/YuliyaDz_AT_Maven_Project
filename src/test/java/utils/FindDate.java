package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FindDate {
    public String addMonth(int month){
        LocalDate today = LocalDate.now();
        System.out.println(today);
        today = today.plusMonths(month);
        System.out.println(today);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String addedMonth = formatter.format(today);
        System.out.println(addedMonth);
        return addedMonth;
    }
}
