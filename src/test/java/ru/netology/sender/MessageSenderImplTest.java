package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageSenderImplTest {

    @Test
    void testSendMessageRussia() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.123.12.19"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>() {{
            put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        }};
        String actual = messageSender.send(headers);

        assertEquals("Добро пожаловать", actual);
    }

    @Test
    void testSendMessageRussia2() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>() {{
            put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        }};
        String actual = messageSender.send(headers);

        assertEquals("Добро пожаловать", actual);
    }

    @Test
    void testSendMessageUsa() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>() {{
            put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        }};
        String actual = messageSender.send(headers);

        assertEquals("Welcome", actual);
    }

    @Test
    void testSendMessageUsa2() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.24.103.142"))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>() {{
            put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.24.103.142");
        }};
        String actual = messageSender.send(headers);

        assertEquals("Welcome", actual);
    }
}