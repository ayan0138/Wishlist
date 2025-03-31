package com.example.wishlistproject.model;

import java.time.LocalDateTime;

public class Reservation {
    private int reservationId;
    private LocalDateTime reservationDate;
    private String status;

    public Reservation(int reservationId, LocalDateTime reservationDate, String status) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.status = status;
    }

    public int getReservationId() {
        return reservationId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", reservationDate=" + reservationDate +
                ", status='" + status + '\'' +
                '}';
    }
}
