package com.example.eni_parking.bo;

import java.util.Date;

public class Rental {

    private int id;
    private int customer_id;
    private int car_id;
    private Date dateBegin;
    private Date dateEnd;
    private String pictureBefore;
    private String pictureAfter;

    public Rental() {
    }

    public Rental(int customer_id, int car_id, Date dateBegin, String pictureBefore) {
        this.setCustomer_id(customer_id);
        this.setCar_id(car_id);
        this.setDateBegin(dateBegin);
        this.setPictureBefore(pictureBefore);
    }

    public Rental(int id, int customer_id, int car_id, Date dateBegin, Date dateEnd, String pictureBefore, String pictureAfter) {
        this.setId(id);
        this.setCustomer_id(customer_id);
        this.setCar_id(car_id);
        this.setDateBegin(dateBegin);
        this.setDateEnd(dateEnd);
        this.setPictureBefore(pictureBefore);
        this.setPictureAfter(pictureAfter);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getPictureBefore() {
        return pictureBefore;
    }

    public void setPictureBefore(String pictureBefore) {
        this.pictureBefore = pictureBefore;
    }

    public String getPictureAfter() {
        return pictureAfter;
    }

    public void setPictureAfter(String pictureAfter) {
        this.pictureAfter = pictureAfter;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", car_id=" + car_id +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", pictureBefore='" + pictureBefore + '\'' +
                ", pictureAfter='" + pictureAfter + '\'' +
                '}';
    }
}