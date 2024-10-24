package co.edu.unbosque.viajes_global.dto;

public class SeatDTO {
    private Integer idSeat;

    private Integer seatNumber;

    private Integer seatRow;

    private Integer seatColumn;

    private Integer seatType;

    public SeatDTO() {
    }

    public SeatDTO(Integer idSeat, Integer seatNumber, Integer seatRow, Integer seatColumn, Integer seatType) {
        this.idSeat = idSeat;
        this.seatNumber = seatNumber;
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

    public Integer getSeatType() {
        return seatType;
    }

    public void setSeatType(Integer seatType) {
        this.seatType = seatType;
    }
}
