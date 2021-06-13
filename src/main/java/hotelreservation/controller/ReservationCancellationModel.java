package hotelreservation.controller;

public class ReservationCancellationModel {

    private int userId;
    private int reservationId;
    private String authToken;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public ReservationCancellationModel(int userId, int reservationId, String authToken) {
        this.userId = userId;
        this.reservationId = reservationId;
        this.authToken = authToken;
    }
}
