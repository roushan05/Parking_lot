import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ParkingLotTest {
    @Test
    public void shouldCreateAParkingLot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createSlotsForParking(6);
        assertEquals(6, parkingLot.getSlotsNumbers().length);

    }

    @Test
    public void ShouldParkACarInParkingLot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createSlotsForParking(4);
        parkingLot.park("KA-01-HH-1234", "White" , 1);
        parkingLot.park("KA-01-HH-9999", "White", 2);
        int actialSizeOfLots = parkingLot.getParkingLotsWithSlots().size();
        assertEquals(2, actialSizeOfLots);
    }


    @Test
    public void shouldNotParkOnlyWhenSlotIsNotAvailable() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createSlotsForParking(3);
        parkingLot.park("KA-01-HH-1234", "White", 1);
        parkingLot.park("KA-01-HH-9999", "White", 1);
        int actialSizeOfLots = parkingLot.getParkingLotsWithSlots().size();
        assertEquals(1, actialSizeOfLots);
    }
    @Test
    public void shouldGiveSlotForARegistrationNumberOfCar() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createSlotsForParking(6);
        parkingLot.park("KA-01-HH-1234", "White", 1);
        parkingLot.park("KA-01-HH-9999", "White", 2);
        parkingLot.park("KA-01-HH-9994", "White", 3);
        assertEquals("3", parkingLot.findCarsSlotsWithRegistrationForANumber("KA-01-HH-9994"));
    }

    @Test
    public void shouldGiveSlotForACarColor() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createSlotsForParking(6);
        parkingLot.park("KA-01-HH-1234", "White", 1);
        parkingLot.park("KA-01-HH-9999", "White", 2);
        parkingLot.park("KA-01-HH-9994", "White", 3);
        ArrayList expected = new ArrayList();
        expected.add("3");
        expected.add("2");
        expected.add("1");
        assertEquals(expected, parkingLot.findSlotsNumberForCarWithColors("White"));
    }

    @Test
    public void shouldGiveRegistrationNumberForAGivenColor() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createSlotsForParking(6);
        parkingLot.park("KA-01-HH-1234", "White", 1);
        parkingLot.park("KA-01-HH-9999", "White", 2);
        parkingLot.park("KA-01-HH-9994", "White", 3);
        ArrayList expected = new ArrayList();
        expected.add("KA-01-HH-9994");
        expected.add("KA-01-HH-9999");
        expected.add("KA-01-HH-1234");
        assertEquals(expected, parkingLot.findCarsRegistrationForAColor("White"));
    }

    @Test
    public void shouldGiveTheFirstEmptySlot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createSlotsForParking(6);
        parkingLot.park("KA-01-HH-1234", "White", 1);
        parkingLot.park("KA-01-HH-9999", "White", 2);
        parkingLot.park("KA-01-HH-9994", "White", 3);
        assertEquals("4", parkingLot.giveFirstEmptySlot());
    }

    @Test
    public void shouldLeaveASlotForASlotNumber() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createSlotsForParking(6);
        parkingLot.park("KA-01-HH-1234", "White", 1);
        parkingLot.park("KA-01-HH-9999", "White", 2);
        parkingLot.park("KA-01-HH-9994", "White", 3);
        parkingLot.emptySlot(3);
        assertNull(parkingLot.findCarsSlotsWithRegistrationForANumber("KA-01-HH-9994"));
    }
}
