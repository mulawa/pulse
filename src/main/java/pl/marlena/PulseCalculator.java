package pl.marlena;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.ToLongFunction;

public class PulseCalculator {

    PulseRepository pulseRepository;

    PulseCalculator() {
        pulseRepository = new PulseRepository();
    }


    public Long calculate(LocalDateTime currentDate, LocalDateTime birthDate, Sex sex, Condition condition) {
        Long yearsOfAge = ChronoUnit.YEARS.between(birthDate, currentDate);
        Period currentPeriod = Period.getCurrentPeriod(yearsOfAge.intValue());
        List<Period> fullyPassedPeriods = Period.getFullyPassedPeriods(currentPeriod);
        long heartBeatsOfFullyPassedPeriods = fullyPassedPeriods
                .stream()
                .mapToLong(calculateForPeriod(sex, condition, birthDate))
                .sum();


        long heartBeatsOfCurrentPeriod = pulseRepository.getPulseForPeriodSexAndCondition(currentPeriod, sex, condition)
                * minutesOfCurrentPeriod(currentPeriod, birthDate, currentDate);
        System.out.println("Number of heart beats from birth: " + (heartBeatsOfFullyPassedPeriods+heartBeatsOfCurrentPeriod));

        return heartBeatsOfFullyPassedPeriods + heartBeatsOfCurrentPeriod;

    }

     private ToLongFunction<Period> calculateForPeriod(Sex sex, Condition condition, LocalDateTime birthDate) {
        return period -> pulseRepository.getPulseForPeriodSexAndCondition(period, sex, condition) * minutesOfPeriod(period, birthDate);

    }

    private Long minutesOfPeriod(Period period, LocalDateTime birthDate) {
        long minutes = ChronoUnit.MINUTES.between(birthDate.plusYears(period.from()), birthDate.plusYears(period.to()));

        return minutes;
    }

    private Long minutesOfCurrentPeriod(Period period, LocalDateTime birthDate, LocalDateTime currentDate) {
        long minutes = ChronoUnit.MINUTES.between(birthDate.plusYears(period.from()), currentDate);

        return minutes ;
    }


}
