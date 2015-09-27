import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private HashMap<String, String> parkingLots;
    private HashMap<String, String> parkingSlots;
    private String[] slotsNumbers;
    public ParkingLot() {
        parkingLots = new HashMap<>();
        parkingSlots = new HashMap<>();
    }

    public String[] getSlotsNumbers() {
        return slotsNumbers;
    }

    public HashMap<String, String> getParkingLotsWithSlots() {
        return parkingSlots;
    }

    public void park(String carNumber, String color, int slot) {
        if (parkingSlots.get(slot) == null && slotsNumbers[slot - 1].equals("empty")) {
            parkingLots.put(carNumber, color);
            parkingSlots.put(String.valueOf(slot), carNumber);
            slotsNumbers[slot - 1] = "booked";
        }
    }

    public void createSlotsForParking(int parkingSize) {
        slotsNumbers = new String[parkingSize];
        for (int i = 0; i < parkingSize; i++) {
            slotsNumbers[i] = "empty";
        }
    }

    public String findCarsSlotsWithRegistrationForANumber(String number){
        for (Map.Entry<String, String> entry : parkingSlots.entrySet()) {
                if (entry.getValue().equals(number)) {
                    return entry.getKey();
                }
        }
        return null;
    }

    public ArrayList<String> findCarsRegistrationForAColor(String color){
        ArrayList<String> registrationNumberForColors = new ArrayList<>();
        for (Map.Entry<String, String> entry : parkingSlots.entrySet()) {
            String carNumber = entry.getValue();
            if (color.equals(parkingLots.get(carNumber))){
                registrationNumberForColors.add(entry.getValue());
            }
        }
        return registrationNumberForColors;
    }

    public ArrayList<String> findSlotsNumberForCarWithColors(String color){
        ArrayList<String> slotsForColors = new ArrayList<>();
        for (Map.Entry<String, String> entry : parkingSlots.entrySet()) {
                String carNumber = entry.getValue();
                if (color.equals(parkingLots.get(carNumber))){
                    slotsForColors.add(entry.getKey());
                }
        }
        return (slotsForColors);
    }

    public String giveFirstEmptySlot() {
        for (int i = 0; i < slotsNumbers.length; i++) {
            if (slotsNumbers[i].equals("empty"))
                return String.valueOf(i+1);
        }
        return null;
    }

    public void emptySlot(int slot) {
        if (slotsNumbers[slot - 1].equals("booked")) {
            String carNumber = parkingSlots.get(String.valueOf(slot));
            parkingSlots.remove(String.valueOf(slot));
            parkingLots.remove(carNumber);
            slotsNumbers[slot - 1] = "empty";
        }
    }
}
