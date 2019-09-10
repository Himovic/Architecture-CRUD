package Main;

import Models.Machine;
import Services.MachineService;
import ServicesMap.MachineMapService;

import java.util.Date;
import java.util.List;

public class MainClass {
    public static void main(String[] args){

        MachineService machineService = new MachineMapService();
        /*
        * Save a machine
        * */
        Machine machine = machineService.save
                (new Machine("Reference","Designation",new Date(),140000.0,0),
                        Machine.class);

        if(machine != null){
            System.out.println("The machine object is inserted correctly");
        }else{
            System.out.println("Error !");
        }

        /*
        * FindAll the machines exist in the DB
        * */
        List<Machine> listMachine = machineService.findAll(new Machine());
        System.out.println("Machines exist in the DB are : "+listMachine.toString());

        /*
        * Get a machine by Reference
        * */
        Machine machineRef = machineService.findByRef("Reference",Machine.class);
        System.out.println("The details of the reference given to consult the machine are : "+machineRef.toString());

        /*
        * Delete a machine
        * */
        if(machineService.delete(new Machine("Reference","Designation",new Date(),140000.0,0),
                Machine.class)){
            System.out.println("The machine is deleted correctly");
        }else{
            System.out.println("Error !");
        }
    }
}
