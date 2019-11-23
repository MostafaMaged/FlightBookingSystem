package com.instafly.task.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    private int Id;
    private String userName;
    private int flightId;
    private ClassType classType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }
}
