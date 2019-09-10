package ServicesMap;

import Models.Machine;
import Services.MachineService;

import java.util.Date;
import java.util.List;

public class MachineMapService extends AbstractMapService<Machine,String> implements MachineService {

    @Override
    public List<Machine> findAll(Machine t) {
        return super.findAll(t);
    }

    @Override
    public Machine findByRef(String ref, Class<Machine> tClass) {
        return super.findByRef(ref, tClass);
    }

    @Override
    public Machine save(Machine object, Class<Machine> tClass) {
        return super.save(object,tClass);
    }

    @Override
    public boolean delete(Machine object, Class<Machine> tClass) {
        return super.delete(object,tClass);
    }

    @Override
    public boolean update(Machine newObject, Class<Machine> tClass) {
        return super.update(newObject,tClass);
    }

    @Override
    public Machine findByDesignation(String designation) {
        return null;
    }

    @Override
    public Machine findByReference(String reference) {
        return null;
    }

    @Override
    public Machine findByDate(Date date) {
        return null;
    }
}
