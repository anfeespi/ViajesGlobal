package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class SeatTypeDTO {
    private Integer idSeatType;

    private String seatType;

    public SeatTypeDTO() {
    }

    public SeatTypeDTO(Integer idSeatType, String seatType) {
        this.idSeatType = idSeatType;
        this.seatType = seatType;
    }

    public Integer getIdSeatType() {
        return idSeatType;
    }

    public void setIdSeatType(Integer idSeatType) {
        this.idSeatType = idSeatType;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}
