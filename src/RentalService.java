public class RentalService {
    private ActiveRental activeRental;
    private BikeService bikeService;

    public RentalService(ActiveRental activeRental, BikeService bikeService) {
        this.activeRental = activeRental;
        this.bikeService = bikeService;
    }

    public boolean startRental(String userId, String bikeId) {
        if (activeRental.isUserRenting(userId)) {
            return false; 
        }
        if (bikeService.reserveBike(bikeId)) {
            activeRental.addRental(userId, bikeId);
            return true;
        }
        return false;
    }

    public boolean endRental(String userId, String newLocation) {
        if (!activeRental.isUserRenting(userId)) {
            return false; 
        }
        String bikeId = activeRental.getRentalMap().get(userId);
        if (bikeService.releaseBike(bikeId, newLocation)) {
            activeRental.removeRental(userId);
            return true;
        }
        return false;
    }

    public boolean cancelRental(String userId) {
        if (!activeRental.isUserRenting(userId)) {
            return false;
        }
        String bikeId = activeRental.getRentalMap().get(userId);
        bikeService.releaseBike(bikeId, bikeService.findAvailableBikes("").get(0).getLocation());
        activeRental.removeRental(userId);
        return true;
    }

    public String trackRental(String userId) {
        if (activeRental.isUserRenting(userId)) {
            return "User " + userId + " is renting bike: " + activeRental.getRentalMap().get(userId);
        } else {
            return "User " + userId + " has no active rental.";
        }
    }
}
