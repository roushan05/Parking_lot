import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] inputs = line.split(" ");
                if (line.contains("create")){
                    parkingLot.createSlotsForParking(Integer.parseInt(inputs[1]));
                }
                else if (line.contains("park")){
                    String slot = parkingLot.giveFirstEmptySlot();
                    if (slot.equals(null))
                        System.out.println("No Empty Slot");
                    else
                        parkingLot.park(inputs[1], inputs[2], Integer.parseInt(slot));
                }
                else if (inputs[0].contains("slot_number_for_registration_number")){
                    System.out.println((parkingLot.findCarsSlotsWithRegistrationForANumber(inputs[1])));
                }
                else if (line.contains("slot_numbers_for_cars_with_colour")){
                    ArrayList<String> slots = parkingLot.findSlotsNumberForCarWithColors(inputs[1]);
                    System.out.println(String.valueOf(slots));
                }
                else if (line.contains("registration_numbers_for_cars_with_colour")){
                    ArrayList<String> registrations = parkingLot.findCarsRegistrationForAColor(inputs[1]);
                    System.out.println(registrations);
                }
                else if (line.contains("leave")){
                    parkingLot.emptySlot(Integer.parseInt(inputs[1]));
                    System.out.println("Slot "+inputs[1]+ " is Empty");
                }
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
