package co.edu.unbosque.viajes_global.dto;

import java.util.ArrayList;

public class PackageDetailBuilder {
    private Integer packageDetailId;
    private String user;
    private ArrayList<Integer> hotelDetail;
    private ArrayList<Integer> flightDetail;
    private ArrayList<Integer> excursionDetail;

    public PackageDetailBuilder() {
        hotelDetail = new ArrayList<>();
        flightDetail = new ArrayList<>();
        excursionDetail = new ArrayList<>();
    }

    public PackageDetailBuilder setPackageDetailId(Integer packageDetailId) {
        this.packageDetailId = packageDetailId;
        return this;
    }

    public PackageDetailBuilder setUser(String user) {
        this.user = user;
        return this;
    }

    public PackageDetailBuilder addHotel(Integer hotel) {
        this.hotelDetail.add(hotel);
        return this;
    }

    public PackageDetailBuilder addFlight(Integer flight) {
        this.flightDetail.add(flight);
        return this;
    }

    public PackageDetailBuilder addExcursion(Integer excursion) {
        this.excursionDetail.add(excursion);
        return this;
    }

    public PackageDetailDTO build() {
        return new PackageDetailDTO(packageDetailId, user, (Integer[]) hotelDetail.toArray(), (Integer[]) flightDetail.toArray(), (Integer[]) excursionDetail.toArray());
    }

}
