package co.edu.unbosque.viajes_global.dto;

public record PackageDetailDTO(Integer packageDetailId, String user, Integer[] hotelDetail, Integer[] flightDetail,
                               Integer[] excursionDetail, Double price) {
}
