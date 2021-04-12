package ru.netology.i18n;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import ru.netology.entity.Country;

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
        Assertions.assertEquals("Добро пожаловать", actual);
    }

    @Test
    void localeUsa() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        String actual = localizationService.locale((Country.USA));
        Assertions.assertEquals("Welcome", actual);
    }

    @Test
    void localeGermany() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.GERMANY)).thenReturn("Welcome");
        String actual = localizationService.locale((Country.GERMANY));
        Assertions.assertEquals("Welcome", actual);
    }

    @Test
    void localeBrazil() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.BRAZIL)).thenReturn("Welcome");
        String actual = localizationService.locale((Country.BRAZIL));
        Assertions.assertEquals("Welcome", actual);
    }
}