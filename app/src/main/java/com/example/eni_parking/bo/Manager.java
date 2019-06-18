package com.example.eni_parking.bo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "manager")
public class Manager {

    @PrimaryKey
    private int id;

    @ColumnInfo(name="firstname")
    private String firstname;

    @ColumnInfo(name="lastname")
    private String lastname;

    @ColumnInfo(name="phone")
    private String phone;

    @ForeignKey(
            entity = Agency.class,
            parentColumns = "id",
            childColumns = "agencyID"
    )
    private int agencyID;

    public Manager() {
    }

    public Manager(int id, String firstname, String lastname, String phone, int agencyID) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.agencyID = agencyID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String tel) {
        this.phone = tel;
    }

    public int getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(int agencyID) {
        this.agencyID = agencyID;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", agencyID=" + agencyID +
                '}';
    }
}
