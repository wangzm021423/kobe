import java.util.List;
import java.util.stream.Collectors;

public class BikeService {
    private BikeDatabase bikeDatabase;

      public BikeService(BikeDatabase bikeDatabase) {
        this.bikeDatabase = bikeDatabase;
    }

    public boolean validateLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            return false;
        }
        return bikeDatabase.getBikeList().stream()
                .anyMatch(bike -> bike.getLocation().equals(location));
    }

    public List<Bike> findAvailableBikes(String location) {
        if (!validateLocation(location)) {
            return List.of(); 
        }
        return bikeDatabase.getBikeList().stream()
                .filter(bike -> bike.getLocation().equals(location) && !bike.isRented())
                .collect(Collectors.toList());
    }

    public boolean reserveBike(String bikeId) {
        for (Bike bike : bikeDatabase.getBikeList()) {
            if (bike.getBikeId().equals(bikeId) && !bike.isRented()) {
                bike.setRented(true);
                return true;
            }
        }
        return false; 
    }

    public boolean releaseBike(String bikeId, String newLocation) {
        for (Bike bike : bikeDatabase.getBikeList()) {
            if (bike.getBikeId().equals(bikeId) && bike.isRented()) {
                bike.setRented(false);
                bike.setLocation(newLocation);
                return true; 
            }
        }
        return false;
    }
}
