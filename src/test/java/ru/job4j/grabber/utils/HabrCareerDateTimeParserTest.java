package ru.job4j.grabber.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;

class HabrCareerDateTimeParserTest {

    @Test
    void whenDateHasDayOfMonthEight() {
        HabrCareerDateTimeParser parser = new HabrCareerDateTimeParser();
        String date = "2023-07-08T01:24:48";
        assertThat(parser.parse(date)).hasDayOfMonth(8);
    }

    @Test
    void whenParseDateIsInstanceOfLocalDateTimeClass() {
        HabrCareerDateTimeParser parser = new HabrCareerDateTimeParser();
        String date = "2023-07-08T01:24:48";
        assertThat(parser.parse(date)).isInstanceOf(LocalDateTime.class);
    }

    @Test
    void whenDateMinusThreeMonthThanFour() {
        HabrCareerDateTimeParser parser = new HabrCareerDateTimeParser();
        String date = "2023-07-08T01:24:48";
        LocalDateTime dateResult = parser.parse(date).minusMonths(3);
        assertThat(dateResult).isEqualTo(LocalDateTime.parse("2023-04-08T01:24:48", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}