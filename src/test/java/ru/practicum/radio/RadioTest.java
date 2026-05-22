package ru.practicum.radio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void testInitialState() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }
//парам пам пам
    @Test
    void testNextStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());

        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testPrevStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());

        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testSetStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());

        radio.setCurrentStation(-1);
        assertEquals(9, radio.getCurrentStation());

        radio.setCurrentStation(10);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testVolumeIncrease() {
        Radio radio = new Radio();

        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        for (int i = 1; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());

        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testVolumeDecrease() {
        Radio radio = new Radio();

        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());

        for (int i = 0; i < 50; i++) radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }
}