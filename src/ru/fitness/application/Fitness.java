package ru.fitness.application;

import java.time.LocalDateTime;
import java.util.Arrays;
import static java.time.LocalDateTime.now;
import static ru.fitness.application.Zone.*;

public class Fitness {
    private final Membership[] registeredInGym = new Membership[GYM.getMaxCapacity()];
    private final Membership[] registeredInPool = new Membership[POOL.getMaxCapacity()];
    private final Membership[] registeredInGroup = new Membership[GROUP.getMaxCapacity()];

    private Membership[] pickZone(Zone zone) {
        return switch (zone) {
            case GYM -> registeredInGym;
            case POOL -> registeredInPool;
            case GROUP -> registeredInGroup;
        };
    }

    public void resetToDefault(Zone zone){
        Membership[] resetedZone = pickZone(zone);
        Arrays.fill(resetedZone, null);
    }

    public boolean isZoneOpened(Membership membership) {
        LocalDateTime currentDateTime = now();
        return ((currentDateTime.toLocalTime().isAfter(membership.getMembershipType().getZonesOpenedFrom()))
                && currentDateTime.toLocalTime().isBefore(membership.getMembershipType().getZonesOpenedTo()));
    }

    public void addToZone(Zone zone, Membership membership){
        Membership[] visitedZone = pickZone(zone);
        LocalDateTime currentDateTime = now();
        if (isZoneOpened(membership)){
            if (membership.isAllowedZone(zone)) {
                for (int i = 0; i < visitedZone.length; i++) {
                    if (i == visitedZone.length - 1 && visitedZone[visitedZone.length - 1] != null) {
                        System.out.println("Нет свободных мест");
                        break;
                    }
                    if (visitedZone[i] != null) continue;
                    if (visitedZone[i] == null) {
                        if (membership.isMembershipActive()) {
                            if (membership.isRegisteredInAnotherZone()) {
                                System.out.println("Абонемент зарегистрирован в другой зоне.");
                                break;
                            } else {
                                membership.setBeginVisitingTime(currentDateTime);
                                visitedZone[i] = membership;
                                System.out.println(membership.getClient().getLastName() + " "
                                        + membership.getClient().getFirstName()
                                        + " зарегистрирован(а) в зоне " + zone.getName().toLowerCase() + ", "
                                        + membership.getBeginVisitingTime());
                                break;
                            }
                        } else {
                            System.out.println("Срок действия абонемента истёк " + membership.getActualTo() + ".");
                            break;
                        }
                    }
                }
            } else {
                System.out.println("По Вашему типу абонемента " + zone.getName().toLowerCase() + " не доступен(-ны).");
            }
        } else {
            System.out.println("Зона " + zone.getName().toLowerCase() + " закрыта.");
        }
    }

    public void showClientsInZone(Zone zone){
        Membership[] visitedZone = pickZone(zone);
        Client[] clientsInZone = new Client[zone.getMaxCapacity()];
        for (int i = 0; i < visitedZone.length; i++) {
            if (visitedZone[i] != null) {
                clientsInZone[i] = visitedZone[i].getClient();
            }
        }
        System.out.println(Arrays.toString(clientsInZone));
    }
}
