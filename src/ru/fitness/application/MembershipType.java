package ru.fitness.application;

import static java.time.LocalDateTime.now;
import static ru.fitness.application.Zone.*;

import java.time.LocalTime;

public enum MembershipType {
    ONETIME ("Разовое посещение", new Zone[]{GYM, POOL}, LocalTime.of(8, 0), LocalTime.of(22, 0)),
    DAYTIME("Дневной абонемент", new Zone[]{GYM, GROUP}, LocalTime.of(8, 0), LocalTime.of(16, 0)),
    FULLPASS ("Полный абонемент", new Zone[]{GYM, POOL, GROUP}, LocalTime.of(8, 0), LocalTime.of(22, 0));


    private final String name;
    private final Zone[] allowedZones;
    private final LocalTime zonesOpenedFrom;
    private final LocalTime zonesOpenedTo;

    MembershipType(String name, Zone[] allowedZones, LocalTime zonesOpenedFrom, LocalTime zonesOpenedTo) {
        this.name = name;
        this.allowedZones = allowedZones;
        this.zonesOpenedFrom = zonesOpenedFrom;
        this.zonesOpenedTo = zonesOpenedTo;
    }

    public String getName() {
        return name;
    }

    public Zone[] getAllowedZones() {
        return allowedZones;
    }

    public LocalTime getZonesOpenedFrom() {
        return zonesOpenedFrom;
    }

    public LocalTime getZonesOpenedTo() {
        return zonesOpenedTo;
    }
}
