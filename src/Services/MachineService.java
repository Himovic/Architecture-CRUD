package Services;

import Models.Machine;

import java.util.Date;

public interface MachineService extends CrudService<Machine,String> {

    Machine findByDesignation(String designation);
    Machine findByReference(String reference);
    Machine findByDate(Date date);
}
