package ru.netology.geo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @AfterAll
    static void afterAll() {
        System.out.println("Все тесты выполнены успешно!");
    }

    @Test
    void byRussiaIp() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.33.01"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Location actual = geoService.byIp("172.0.33.01");
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        assertEquals(expected, actual);
    }

    @Test
    void byRussiaIp2() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.33.01"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Location actual = geoService.byIp("172.0.33.01");
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        assertEquals(expected, actual);
    }

    @Test
    void byUsaIp() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
        .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Location actual = geoService.byIp("96.44.183.149");
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        assertEquals(expected, actual);
    }

    @Test
    void byUsaIp2() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.45.182.149"))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Location actual = geoService.byIp("96.45.182.149");
        Location expected = new Location("New York", Country.USA, null, 0);
        assertEquals(expected, actual);
    }

    @Test
    void byNullCountryInIp() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("127.0.0.1"))
        .thenReturn(new Location(null, null, null, 0));
        Location actual = geoService.byIp("127.0.0.1");
        Location expected = new Location(null, null, null, 0);
        assertEquals(expected, actual);
    }

    @Test
    void byNullIp() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(null))
                .thenReturn(null);
            Location actual = geoService.byIp(null);
            assertNull(actual);
    }

    @Test
    void byNullLocationIp() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("137.0.1.1"))
        .thenReturn(null);
            Location actual = geoService.byIp("137.0.1.1");
            assertNull(actual);
    }
}