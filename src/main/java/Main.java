import java.util.HashMap;
import java.util.Map;

import ru.netology.geo.*;
import ru.netology.i18n.*;
import ru.netology.sender.*;

public class Main {

    public static void main(String[] args) {
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>(){{
            put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        }};

        messageSender.send(headers);
    }
}