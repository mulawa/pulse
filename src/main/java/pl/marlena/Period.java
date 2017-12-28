package pl.marlena;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum Period {
    FROM_0_TO_1(0, 1),
    FROM_1_TO_13(1, 13),
    FROM_13_TO_18(13, 18),
    FROM_18_TO_25(18, 25),
    FROM_25_TO_35(25, 35),
    FROM_35_TO_45(35, 45),
    FROM_45_TO_55(45, 55),
    FROM_55_TO_65(55, 65),
    FROM_65(65, Integer.MAX_VALUE);

    private int from;
    private int to;

    Period(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public static Period getCurrentPeriod(int age) {
        return Arrays.stream(values()).filter(getPeriodPredicate(age))
                .findFirst().get();
    }

    private static Predicate<Period> getPeriodPredicate(int age) {
        return period -> age >= period.from() && age < period.to();
    }

    public static List<Period> getFullyPassedPeriods(Period currentPeriod) {
        return Arrays.stream(values()).filter(period -> period.ordinal() < currentPeriod.ordinal()).collect(Collectors.toList());
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }
}