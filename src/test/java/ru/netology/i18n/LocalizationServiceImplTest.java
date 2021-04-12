package ru.netology.i18n;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @AfterAll
    static void afterAll() {
        System.out.println("Все тесты выполнены успешно!");
    }

    @Test
    void localeRussia() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        String actual = localizationService.locale((Country.RUSSIA));
        assertEquals("Добро пожаловать", actual);
    }

    @Test
    void localeUsa() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        String actual = localizationService.locale((Country.USA));
        assertEquals("Welcome", actual);
    }

    @Test
    void localeGermany() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.GERMANY)).thenReturn("Добро пожаловать");
        String actual = localizationService.locale((Country.GERMANY));
        assertEquals("Welcome", actual);
    }

    @Test
    void localeBrazil() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.BRAZIL)).thenReturn("Добро пожаловать");
        String actual = localizationService.locale((Country.BRAZIL));
        assertEquals("Welcome", actual);
    }

}