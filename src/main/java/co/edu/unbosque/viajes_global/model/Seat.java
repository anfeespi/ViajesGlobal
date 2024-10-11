package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asiento")
public class Seat {

    @Id
    @Column(name = "id_asiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeat;

    @Column(name = "numero_asiento", nullable = false)
    private Integer seatNumber;

    @Column(name = "fila_Asiento", nullable = false)
    private Integer seatRow;

    @Column(name = "columna_asiento", nullable = false)
    private Integer seatColumn;

    @ManyToOne
    @JoinColumn(name = "id_tipo_asiento", referencedColumnName = "id_tipo_asiento")
    private SeatType seatType;

    public Seat() {
    }

    public Seat(Integer seatRow, Integer seatColumn, SeatType seatType) {
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.seatType = seatType;
    }

    public Integer getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(Integer idSeat) {
        this.idSeat = idSeat;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(Integer seatColumn) {
        this.seatColumn = seatColumn;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
