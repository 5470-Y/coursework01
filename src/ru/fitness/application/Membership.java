package ru.fitness.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static java.time.LocalDateTime.now;

public class Membership {
    private final int membershipNumber;
    private MembershipType membershipType;
    private LocalDate actualFrom;
    private LocalDate actualTo;
    private LocalDateTime beginVisitingTime;
    private LocalDateTime endVisitingTime;
    private Client client;

    public Membership(int membershipNumber, MembershipType membershipType, LocalDate actualFrom, LocalDate actualTo, Client client) {
        this.membershipNumber = membershipNumber;
        this.membershipType = membershipType;
        this.actualFrom = actualFrom;
        this.actualTo = actualTo;
        this.client = client;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public LocalDate getActualFrom() {
        return actualFrom;
    }

    public LocalDate getActualTo() {
        return actualTo;
    }

    public LocalDateTime getBeginVisitingTime() {
        return beginVisitingTime;
    }

    public LocalDateTime getEndVisitingTime() {
        return endVisitingTime;
    }

    public Client getClient() {
        return client;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public void setActualFrom(LocalDate actualFrom) {
        this.actualFrom = actualFrom;
    }

    public void setActualTo(LocalDate actualTo) {
        this.actualTo = actualTo;
    }

    public void setBeginVisitingTime(LocalDateTime beginVisitingTime) {
        this.beginVisitingTime = beginVisitingTime;
    }

    public void setEndVisitingTime(LocalDateTime endVisitingTime) {
        this.endVisitingTime = endVisitingTime;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isMembershipActive() {
        LocalDateTime currentDateTime = now();
        return (currentDateTime.toLocalDate().isAfter(actualFrom)
                && (currentDateTime.toLocalDate().isBefore(actualTo)
                || (currentDateTime.toLocalDate().isEqual(actualTo))));
    }

    public boolean isRegisteredInAnotherZone() {
        return (getBeginVisitingTime() != null
        && (getEndVisitingTime() == null || getEndVisitingTime().isBefore(getBeginVisitingTime())));
    }

    public boolean isAllowedZone(Zone zone) {
        return Arrays.asList(getMembershipType().getAllowedZones()).contains(zone);
    }
}
