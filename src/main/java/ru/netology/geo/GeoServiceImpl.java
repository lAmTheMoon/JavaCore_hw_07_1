package ru.netology.geo;

import ru.netology.entity.*;

import java.util.HashMap;
import java.util.Map;

public class GeoServiceImpl implements GeoService {

    private final Map<String, Location> LOCATION_MAP = new HashMap<>() {{
        put("127.0.0.1", new Location(null, null, null, 0));
        put("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        put("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32));
    }};

    private final Map<String, Location> CITY_MAP = new HashMap<>() {{
        put("172.", new Location("Moscow", Country.RUSSIA, null, 0));
        put("96.", new Location("New York", Country.USA, null, 0));
    }};

    public Location byIp(String ip) {
        if (this.LOCATION_MAP.containsKey(ip)) {
            return LOCATION_MAP.get(ip);
        }
        return this.CITY_MAP.keySet().stream().filter(ip::startsWith)
                .map(CITY_MAP::get)
                .findAny()
                .orElse(null);
    }

    public Location byCoordinates(double latitude, double longitude) {
        throw new RuntimeException("Not implemented");
    }
}
