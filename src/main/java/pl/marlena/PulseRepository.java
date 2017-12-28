package pl.marlena;

import java.util.HashMap;
import java.util.Map;

import static pl.marlena.Condition.*;
import static pl.marlena.Condition.BAD;
import static pl.marlena.Condition.WEAK;
import static pl.marlena.Period.*;


public class PulseRepository {

    private Map<Period, Integer> childPulseMap = new HashMap();
    private Map<Sex, Map<Period, Map<Condition, Integer>>> adultPulseMap = new HashMap();


    PulseRepository() {
        childPulseMap();
        womanPulseMap();
        manPulseMap();
    }

    public Integer getPulseForPeriodSexAndCondition(Period period, Sex sex, Condition condition) {
        switch (period) {
            case FROM_0_TO_1:
            case FROM_1_TO_13:
            case FROM_13_TO_18:
                return childPulseMap.get(period);
            default:
                return adultPulseMap.get(sex).get(period).get(condition);
        }
    }

    private void childPulseMap() {
        childPulseMap.put(FROM_0_TO_1, 130);
        childPulseMap.put(FROM_1_TO_13, 100);
        childPulseMap.put(FROM_13_TO_18, 85);
    }

    private void womanPulseMap() {
        Map<Period, Map<Condition, Integer>>womanPulseMap = new HashMap<>();
        adultPulseMap.put(Sex.F, womanPulseMap);
        Map<Condition, Integer> womanFrom18To25 = new HashMap<>();
        womanFrom18To25.put(EXTRA, 60);
        womanFrom18To25.put(GREAT, 65);
        womanFrom18To25.put(GOOD, 69);
        womanFrom18To25.put(OVERUSUAL, 73);
        womanFrom18To25.put(BASIC, 78);
        womanFrom18To25.put(WEAK, 84);
        womanFrom18To25.put(BAD, 85);
        womanPulseMap.put(Period.FROM_18_TO_25, womanFrom18To25);
        Map<Condition, Integer> womanFrom25To35 = new HashMap<>();
        womanFrom25To35.put(EXTRA, 59);
        womanFrom25To35.put(GREAT, 64);
        womanFrom25To35.put(GOOD, 68);
        womanFrom25To35.put(OVERUSUAL, 72);
        womanFrom25To35.put(BASIC, 76);
        womanFrom25To35.put(WEAK, 82);
        womanFrom25To35.put(BAD, 83);
        womanPulseMap.put(FROM_25_TO_35, womanFrom25To35);
        Map<Condition, Integer> womanFrom35To45 = new HashMap<>();
        womanFrom35To45.put(EXTRA, 59);
        womanFrom35To45.put(GREAT, 64);
        womanFrom35To45.put(GOOD, 69);
        womanFrom35To45.put(OVERUSUAL, 73);
        womanFrom35To45.put(BASIC, 78);
        womanFrom35To45.put(WEAK, 84);
        womanFrom35To45.put(BAD, 85);
        womanPulseMap.put(FROM_35_TO_45, womanFrom35To45);
        Map<Condition, Integer> womanFrom45To55 = new HashMap<>();
        womanFrom45To55.put(EXTRA, 60);
        womanFrom45To55.put(GREAT, 65);
        womanFrom45To55.put(GOOD, 69);
        womanFrom45To55.put(OVERUSUAL, 73);
        womanFrom45To55.put(BASIC, 77);
        womanFrom45To55.put(WEAK, 83);
        womanFrom45To55.put(BAD, 84);
        womanPulseMap.put(FROM_45_TO_55, womanFrom45To55);
        Map<Condition, Integer> womanFrom55To65 = new HashMap<>();
        womanFrom55To65.put(EXTRA, 60);
        womanFrom55To65.put(GREAT, 65);
        womanFrom55To65.put(GOOD, 69);
        womanFrom55To65.put(OVERUSUAL, 73);
        womanFrom55To65.put(BASIC, 77);
        womanFrom55To65.put(WEAK, 83);
        womanFrom55To65.put(BAD, 84);
        womanPulseMap.put(FROM_55_TO_65, womanFrom55To65);
        Map<Condition, Integer> womanFrom65 = new HashMap<>();
        womanFrom65.put(EXTRA, 59);
        womanFrom65.put(GREAT, 64);
        womanFrom65.put(GOOD, 68);
        womanFrom65.put(OVERUSUAL, 72);
        womanFrom65.put(BASIC, 76);
        womanFrom65.put(WEAK, 84);
        womanFrom65.put(BAD, 84);
        womanPulseMap.put(FROM_65, womanFrom65);
    }

    private void manPulseMap() {
        Map<Period, Map<Condition, Integer>> manPulseMap = new HashMap<>();
        adultPulseMap.put(Sex.M, manPulseMap);
        Map<Condition, Integer> manFrom18To25 = new HashMap<>();
        manFrom18To25.put(EXTRA, 55);
        manFrom18To25.put(GREAT, 61);
        manFrom18To25.put(GOOD, 65);
        manFrom18To25.put(OVERUSUAL, 69);
        manFrom18To25.put(BASIC, 73);
        manFrom18To25.put(WEAK, 81);
        manFrom18To25.put(BAD, 82);
        manPulseMap.put(Period.FROM_18_TO_25, manFrom18To25);
        Map<Condition, Integer> manFrom25To35 = new HashMap<>();
        manFrom25To35.put(EXTRA, 54);
        manFrom25To35.put(GREAT, 61);
        manFrom25To35.put(GOOD, 65);
        manFrom25To35.put(OVERUSUAL, 70);
        manFrom25To35.put(BASIC, 74);
        manFrom25To35.put(WEAK, 81);
        manFrom25To35.put(BAD, 82);
        manPulseMap.put(FROM_25_TO_35, manFrom25To35);
        Map<Condition, Integer> manFrom35To45 = new HashMap<>();
        manFrom35To45.put(EXTRA, 56);
        manFrom35To45.put(GREAT, 62);
        manFrom35To45.put(GOOD, 66);
        manFrom35To45.put(OVERUSUAL, 70);
        manFrom35To45.put(BASIC, 75);
        manFrom35To45.put(WEAK, 82);
        manFrom35To45.put(BAD, 83);
        manPulseMap.put(FROM_35_TO_45, manFrom35To45);
        Map<Condition, Integer> manFrom45To55 = new HashMap<>();
        manFrom45To55.put(EXTRA, 57);
        manFrom45To55.put(GREAT, 63);
        manFrom45To55.put(GOOD, 67);
        manFrom45To55.put(OVERUSUAL, 71);
        manFrom45To55.put(BASIC, 76);
        manFrom45To55.put(WEAK, 83);
        manFrom45To55.put(BAD, 84);
        manPulseMap.put(FROM_45_TO_55, manFrom45To55);
        Map<Condition, Integer> manFrom55To65 = new HashMap<>();
        manFrom55To65.put(EXTRA, 56);
        manFrom55To65.put(GREAT, 61);
        manFrom55To65.put(GOOD, 67);
        manFrom55To65.put(OVERUSUAL, 71);
        manFrom55To65.put(BASIC, 75);
        manFrom55To65.put(WEAK, 81);
        manFrom55To65.put(BAD, 82);
        manPulseMap.put(FROM_55_TO_65, manFrom55To65);
        Map<Condition, Integer> manFrom65 = new HashMap<>();
        manFrom65.put(EXTRA, 55);
        manFrom65.put(GREAT, 61);
        manFrom65.put(GOOD, 65);
        manFrom65.put(OVERUSUAL, 69);
        manFrom65.put(BASIC, 73);
        manFrom65.put(WEAK, 79);
        manFrom65.put(BAD, 80);
        manPulseMap.put(FROM_65, manFrom65);
    }
}
