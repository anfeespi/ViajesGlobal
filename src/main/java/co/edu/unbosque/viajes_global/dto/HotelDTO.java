package co.edu.unbosque.viajes_global.dto;

public class HotelDTO {
    private Integer idHotel;

    private Integer touristPlace;

    private String hotelName;

    private Integer guestsNumber;

    private Double totalValue;

    private String details;

    public HotelDTO() {
    }

    public HotelDTO(Integer touristPlace, String hotelName, Integer guestsNumber, Double totalValue, String details) {
        this.touristPlace = touristPlace;
        this.hotelName = hotelName;
        this.guestsNumber = guestsNumber;
        this.totalValue = totalValue;
        this.details = details;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public Integer getTouristPlace() {
        return touristPlace;
    }

    public void setTouristPlace(Integer touristPlace) {
        this.touristPlace = touristPlace;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getGuestsNumber() {
        return guestsNumber;
    }

    public void setGuestsNumber(Integer guestsNumber) {
        this.guestsNumber = guestsNumber;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
