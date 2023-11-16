package ru.fitness.application;

import java.time.LocalDate;
import static ru.fitness.application.Zone.*;

public class Application {
    public static void main(String[] args) {
        Client client01 = new Client("Иванов", "Иван", 1990);
        Membership membership01 = new Membership(54165, MembershipType.ONETIME, LocalDate.of(2023, 10, 25), LocalDate.now(), client01);
        Fitness fitness = new Fitness();

        Client client02 = new Client("Иванова", "Ирина", 1990);
        Membership membership02 = new Membership(54, MembershipType.FULLPASS, LocalDate.of(2023, 10, 25), LocalDate.now(), client02);

        Client client03 = new Client("Летний", "Олег", 1973);
        Membership membership03 = new Membership(12, MembershipType.DAYTIME, LocalDate.of(2023, 10, 25), LocalDate.of(2023, 10, 25), client03);

        Client client04 = new Client("Петров", "Пётр", 1998);
        Membership membership04 = new Membership(6541, MembershipType.FULLPASS, LocalDate.of(2023, 11, 1), LocalDate.now(), client04);


        fitness.addToZone(GYM, membership01);
        fitness.addToZone(GROUP, membership02);
        System.out.println(membership02.isRegisteredInAnotherZone());
        fitness.addToZone(POOL, membership02);
        fitness.addToZone(GROUP, membership03);
        fitness.addToZone(GROUP, membership04);

        fitness.showClientsInZone(GYM);
        fitness.showClientsInZone(POOL);
        fitness.showClientsInZone(GROUP);

        fitness.resetToDefault(GROUP);
        fitness.showClientsInZone(GROUP);


    }
}
