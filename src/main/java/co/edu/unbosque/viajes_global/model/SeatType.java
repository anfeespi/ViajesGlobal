package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_asiento")
public class SeatType {

    @Id
    @Column(name = "tipo_asiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeatType;

    @Column(name = "tipo_asiento")
    private String seatType;

    public SeatType() {
    }

    public SeatType(String seatType) {
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
