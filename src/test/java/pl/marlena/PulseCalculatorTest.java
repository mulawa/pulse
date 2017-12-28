package pl.marlena;


import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static pl.marlena.Condition.*;
import static pl.marlena.Main.DATE_FORMAT;
import static pl.marlena.Sex.F;
import static pl.marlena.Sex.M;


class PulseCalculatorTest {

    @Test
    public void shouldCalculateValidPulseFor3MonthOldBaby() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2016-03-31 00:00", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("2016-01-01 00:00", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, M, GOOD);
        assertEquals(16848000, calculate.intValue());

    }

    @Test
    public void shouldCalculateValidPulseForChild() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2017-04-20 12:00", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("2010-01-01 03:30", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, M, GOOD);
        assertEquals(399723000, calculate.intValue());

    }

    @Test
    public void shouldCalculateValidPulseForTeenager() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2016-03-31 00:00", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("2001-03-31 00:00", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, M, GOOD);
        assertEquals(788954400, calculate.intValue());
    }


    @Test
    public void shouldCalculateValidPulseFor22YearsOldMale() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2017-04-20 12:00", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("1995-01-01 05:35", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, M, BAD);
        assertEquals(1108521970, calculate.intValue());

    }

    @Test
    public void shouldCalculateValidPulseFor33YearsOldFemale() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2017-04-20 23:00", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("1984-10-09 03:30", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, F, BASIC);
        assertEquals(1511233560, calculate.intValue());

    }



    @Test
    public void shouldCalculateValidPulseForBoundaryBetweenBabyChild() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2017-04-20 12:01", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("2016-04-20 12:00", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, M, GOOD);
        assertEquals(68328100, calculate.intValue());
    }

    @Test
    public void shouldCalculateValidPulseForBoundaryBetweenPeriods() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2017-01-01 12:01", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("1992-01-01 12:00", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, M, EXTRA);
        assertEquals(1125684054, calculate.intValue());
    }

    @Test
    public void shouldCalculateValidPulseForLeapYear() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2017-02-01 12:00", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("2016-02-01 12:00", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, M, GOOD);
        assertEquals(68515200, calculate.intValue());
    }

    @Test
    public void shouldCalculateValidPulseForYear() {
        PulseCalculator pulseCalculator = new PulseCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime currentDate = LocalDateTime.parse("2017-05-15 21:16", formatter);
        LocalDateTime birthDate = LocalDateTime.parse("2014-02-10 11:22", formatter);
        Long calculate = pulseCalculator.calculate(currentDate, birthDate, M, GOOD);
        assertEquals(187187400, calculate.intValue());

    }
}