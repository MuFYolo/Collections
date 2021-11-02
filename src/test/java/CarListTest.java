import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CarListTest {


        @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        CarList carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        CarList carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        CarList carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
        Car car = new Car("Toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        CarList carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        CarList carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
        carList.clear();
        assertEquals(0, carList.size());
    }


    @Test
    public void whenIndexOutOfBoundsThenThrownException() {
        CarList carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
         assertThrows(IndexOutOfBoundsException.class, () -> {carList.get(100);});
    }

    @Test
    public void methodGetReturnedRightValue() {
        CarList carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }
}