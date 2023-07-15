package org.indigo.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

class Hero {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String power;
    private String weakness;
    private Squad squad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public long getAge() {
        LocalDate today = LocalDate.now();
        long dateDifferenceYears = ChronoUnit.YEARS.between(
                this.dateOfBirth.toInstant(), today);
        return dateDifferenceYears;
    }
}