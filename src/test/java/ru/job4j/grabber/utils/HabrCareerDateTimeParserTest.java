package ru.job4j.grabber.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;

class HabrCareerDateTimeParserTest {

    @Test
    void parseTest() {
        HabrCareerDateTimeParser parser = new HabrCareerDateTimeParser();
        String date = "2023-07-08T01:24:48+03:00";
        String expected = "2023-07-08T01:24:48";
        assertThat(parser.parse(date).toString()).isEqualTo(expected);
    }
}