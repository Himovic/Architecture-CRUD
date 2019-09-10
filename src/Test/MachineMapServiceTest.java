package Test;

import Models.Machine;
import Services.MachineService;
import ServicesMap.MachineMapService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineMapServiceTest {

    MachineService machineService = new MachineMapService();

    @Test
    void findAll() {

        assertEquals(null,machineService.findAll(new Machine()));
    }

    @Test
    void findByRef() {
        assertEquals(null,machineService.findByReference(""));
    }

    //@Test
    void save() {
        assertEquals(new Machine(),machineService.save(new Machine(),Machine.class));
    }

    @Test
    void delete() {
        assertEquals(false,machineService.delete(new Machine(),Machine.class));
    }

    @Test
    void update() {
        assertEquals(false,machineService.update(new Machine(),Machine.class));
    }

    //@Test
    void findByDesignation() {
    }

    //@Test
    void findByReference() {
    }

    //@Test
    void findByDate() {
    }
}