package com.team4.dispatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "station")
@JsonDeserialize(builder = Station.Builder.class)
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @JsonProperty("station_ID")
    private int stationID;

    private int longitude;

    private int latitude;

    public Station() {}

    public Station(Builder builder) {
        this.stationID = builder.stationID;
        this.longitude = builder.longitude;
        this.latitude = builder.latitude;
    }

    public int getStationID() {
        return stationID;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }



    public static class Builder {
        @JsonProperty("station_ID")
        private int stationID;

        @JsonProperty("longitude")
        private int longitude;

        @JsonProperty("latitude")
        private int latitude;

        public Builder setStationID(int stationID) {
            this.stationID = stationID;
            return this;
        }

        public Builder setLongitude(int longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder setLatitude(int latitude) {
            this.latitude = latitude;
            return this;
        }

        public Station build() {
            return new Station(this);
        }


    }
}
