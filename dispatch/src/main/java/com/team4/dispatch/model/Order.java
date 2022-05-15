package com.team4.dispatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
@JsonDeserialize(builder = User.Builder.class)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "robot_id")
    private Robot robotID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User guest;

    private int weight;

    private int length;

    private int width;

    private int height;

    @JsonProperty("total_price")
    private int totalPrice;

    @JsonProperty("pick_up_address")
    private String pickUpAddress;

    @JsonProperty("delivery_address")
    private String deliveryAddress;


    @JsonProperty("pick_up_time")
    private LocalDateTime pickUpTime;

    @JsonProperty("delivery_time")
    private LocalDateTime deliveryTime;

    @JsonProperty("order_status")
    private int orderStatus; // 0, 1, 2 represent different status

    public Order() {}

    public Order(Builder builder) {
        this.orderID = builder.orderID;
        this.robotID = builder.robotID;
        this.guest = builder.guest;
        this.weight = builder.weight;
        this.length = builder.length;
        this.width = builder.width;
        this.height = builder.height;
        this.totalPrice = builder.totalPrice;
        this.pickUpAddress = builder.pickUpAddress;
        this.deliveryAddress = builder.deliveryAddress;
        this.pickUpTime = builder.pickUpTime;
        this.deliveryTime = builder.deliveryTime;
        this.orderStatus = builder.orderStatus;
    }

    public Long getOrderID() {
        return orderID;
    }

    public Robot getRobotID() {
        return robotID;
    }

    public User getGuest() {
        return guest;
    }

    public int getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public static class Builder {

        @JsonProperty("order_ID")
        private Long orderID;

        private Robot robotID;

        private User guest;

        private int weight;

        private int length;

        private int width;

        private int height;

        @JsonProperty("total_price")
        private int totalPrice;

        @JsonProperty("pick_up_address")
        private String pickUpAddress;

        @JsonProperty("delivery_address")
        private String deliveryAddress;


        @JsonProperty("pick_up_time")
        private LocalDateTime pickUpTime;

        @JsonProperty("delivery_time")
        private LocalDateTime deliveryTime;

        @JsonProperty("order_status")
        private int orderStatus; // 0, 1, 2 represent different status

        public Builder setOrderID(Long orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setRobotID(Robot robotID) {
            this.robotID = robotID;
            return this;
        }

        public Builder setUsername(User guest) {
            this.guest = guest;
            return this;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder setLength(int length) {
            this.length = length;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setPickUpAddress(String pickUpAddress) {
            this.pickUpAddress = pickUpAddress;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setPickUpTime(LocalDateTime pickUpTime) {
            this.pickUpTime = pickUpTime;
            return this;
        }

        public Builder setDeliveryTime(LocalDateTime deliveryTime) {
            this.deliveryTime = deliveryTime;
            return this;
        }

        public Builder setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
