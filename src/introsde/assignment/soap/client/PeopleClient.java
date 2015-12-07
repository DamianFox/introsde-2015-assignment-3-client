package introsde.assignment.soap.client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import introsde.assignment.soap.ws.HealthMeasureHistory;
import introsde.assignment.soap.ws.HealthProfile;
import introsde.assignment.soap.ws.People;
import introsde.assignment.soap.ws.PeopleService;
import introsde.assignment.soap.ws.Person;

public class PeopleClient {
	String res;
	File file;
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("client.log");
		String res = "";
		String wsdl = "https://rocky-harbor-4297.herokuapp.com/ws/people?wsdl";
		
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		//bw.write("asdlol");
		
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();
		
		System.out.println("Server deployed at " + wsdl + "\n");
		res += "Server deployed at " + wsdl + "\n";
		System.out.println("--------------------------------- \n");
		res += "--------------------------------- \n";
		res += "\n";
		
		// METHOD #1
		System.out.println("METHOD #1: readPersonList() \n");
		res += "METHOD #1: readPersonList() \n";
		res += "\n";
		
		List<Person> pList = people.readPersonList();
		
		for(int i=0; i<pList.size(); i++){
			System.out.println(i+") "+pList.get(i).getFirstname() + "\n");
			res += i+") "+pList.get(i).getFirstname() + "\n";
			System.out.println(i+") "+pList.get(i).getLastname() + "\n");
			res += i+") "+pList.get(i).getLastname() + "\n";
			System.out.println(i+") "+pList.get(i).getBirthdate() + "\n");
			res += i+") "+pList.get(i).getBirthdate() + "\n";
			System.out.println("///////// \n");
			res += "///////// \n";
		}
		
		System.out.println("--------------------------------- \n");
		res += "--------------------------------- \n";
        
		// METHOD #2
		System.out.println("METHOD #2: readPerson(3) \n");
		res += "METHOD #2: readPerson(3) \n";
		
        Person p = people.readPerson(3);
        System.out.println("Id person: " + p.getIdPerson() + "\n");
        res += "Id person: " + p.getIdPerson() + "\n";
        System.out.println("Firstname: " + p.getFirstname() + "\n");
        res += "Firstname: " + p.getFirstname() + "\n";
        System.out.println("Lastname: " + p.getLastname() + "\n");
        res += "Lastname: " + p.getLastname() + "\n";
        System.out.println("Birthdate: " + p.getBirthdate() + "\n");
        res += "Birthdate: " + p.getBirthdate() + "\n";
        System.out.println("--------------------------------- \n");
		res += "--------------------------------- \n";
        
		// METHOD #3
		System.out.println("METHOD #3: updatePerson(3) \n");
		res += "METHOD #3: updatePerson(3) \n";
        p.setFirstname("John");
        p.setLastname("Doe");
        p.setBirthdate("1990-01-01");
        
        Person personUp = people.updatePerson(p);
        System.out.println("Printing the person just updated \n");
		res += "Printing the person just updated \n";
        System.out.println("Id person: " + personUp.getIdPerson() + "\n");
        res += "Id person: " + personUp.getIdPerson() + "\n";
        System.out.println("Firstname: " + personUp.getFirstname() + "\n");
        res += "Firstname: " + personUp.getFirstname() + "\n";
        System.out.println("Lastname: " + personUp.getLastname() + "\n");
        res += "Lastname: " + personUp.getLastname() + "\n";
        System.out.println("Birthdate: " + personUp.getBirthdate() + "\n");
        res += "Birthdate: " + personUp.getBirthdate() + "\n";
        System.out.println("--------------------------------- \n");
		res += "--------------------------------- \n";
        
		// METHOD #4
		System.out.println("METHOD #4: createPerson(Person p) \n");
		res += "METHOD #4: createPerson(Person p) \n";
        Person newPerson = new Person();
        newPerson.setFirstname("Maurizio");
        newPerson.setLastname("Marchese");
        newPerson.setBirthdate("1967-01-01");
        Person personCreated = people.createPerson(newPerson);
        System.out.println("Printing the person just updated \n");
		res += "Printing the person just updated \n";
        System.out.println("Id person: " + personCreated.getIdPerson() + "\n");
        res += "Id person: " + personCreated.getIdPerson() + "\n";
        System.out.println("Firstname: " + personCreated.getFirstname() + "\n");
        res += "Firstname: " + personCreated.getFirstname() + "\n";
        System.out.println("Lastname: " + personCreated.getLastname() + "\n");
        res += "Lastname: " + personCreated.getLastname() + "\n";
        System.out.println("Birthdate: " + personCreated.getBirthdate() + "\n");
        res += "Birthdate: " + personCreated.getBirthdate() + "\n";
        System.out.println("--------------------------------- \n");
		res += "--------------------------------- \n";
		
		// METHOD #5
		System.out.println("METHOD #5: deletePerson(" + personCreated.getIdPerson() + ") \n");
		res += "METHOD #5: deletePerson(" + personCreated.getIdPerson() + ") \n";
        boolean isDeleted = people.deletePerson(personCreated.getIdPerson());
        System.out.println("Deleted: " + isDeleted);
        res += "Deleted: " + isDeleted + "\n";
        System.out.println("---------------------------------\n");
		res += "---------------------------------\n";
        
    	// METHOD #6
 		System.out.println("METHOD #6: readPersonHistory(3, \"height\") \n");
 		res += "METHOD #6: readPersonHistory(3, \"height\") \n";
 		List<HealthMeasureHistory> hList = people.readPersonHistory(3, "height");
 		for(int i=0; i<hList.size(); i++){
			System.out.println(i+") "+hList.get(i).getIdMeasureHistory() + "\n");
			res += i+") "+hList.get(i).getIdMeasureHistory() + "\n";
			System.out.println(i+") "+hList.get(i).getValue() + "\n");
			res += i+") "+hList.get(i).getValue() + "\n";
			System.out.println(i+") "+hList.get(i).getCreated() + "\n");
			res += i+") "+hList.get(i).getCreated() + "\n";
			System.out.println("///////// \n");
			res += "///////// \n";
		}
 		System.out.println("---------------------------------\n");
		res += "---------------------------------\n";
 		
 		// METHOD #7
 		System.out.println("METHOD #7: readMeasureTypes() \n");
 		res += "METHOD #7: readMeasureTypes() \n";
 		List<String> measures = people.readMeasureTypes();
 		for(int i=0; i<measures.size(); i++){
 			System.out.println(i+") "+ measures.get(i) + "\n");
			res += i+") " + measures.get(i) + "\n";
			System.out.println("///////// \n");
			res += "///////// \n";
 		}
 		System.out.println("---------------------------------\n");
		res += "---------------------------------\n";
		
		// METHOD #8
 		System.out.println("METHOD #8: readPersonMeasure(3, \"height\", 4) \n");
 		res += "METHOD #8: readPersonMeasure(3, \"height\", 4) \n";
        List<HealthMeasureHistory> hmList = people.readPersonMeasure(3, "height", 4);
        for(int i=0; i<hmList.size(); i++){
        	System.out.println(i+") "+hmList.get(i).getIdMeasureHistory() + "\n");
			res += i+") "+hList.get(i).getIdMeasureHistory() + "\n";
			System.out.println(i+") "+hmList.get(i).getValue() + "\n");
			res += i+") "+hList.get(i).getValue() + "\n";
			System.out.println(i+") "+hmList.get(i).getCreated() + "\n");
			res += i+") "+hList.get(i).getCreated() + "\n";
			System.out.println("///////// \n");
			res += "///////// \n";
        }
        System.out.println("---------------------------------\n");
		res += "---------------------------------\n";
        
        // METHOD #9
  		System.out.println("METHOD #9: savePersonMeasure(6, HealthProfile hp) \n");
  		res += "METHOD #9: savePersonMeasure(6, HealthProfile hp) \n";
        
        HealthProfile hp = new HealthProfile();
        hp.setMeasure("weight");
        hp.setValue("75");
        HealthProfile hpCreated = people.savePersonMeasure(6, hp);
        System.out.println("Printing the health profile just created \n");
		res += "Printing the health profile just created \n";
        System.out.println("Id measure: " + hpCreated.getIdMeasure() + "\n");
        res += "Id measure: " + hpCreated.getIdMeasure() + "\n";
        System.out.println("Measure: " + hpCreated.getMeasure() + "\n");
        res += "Measure: " + hpCreated.getMeasure() + "\n";
        System.out.println("Value: " + hpCreated.getValue() + "\n");
        res += "Value: " + hpCreated.getValue() + "\n";
        System.out.println("---------------------------------\n");
		res += "---------------------------------\n";
        
		// METHOD #10
  		System.out.println("METHOD #10: updatePersonMeasure(3, Measure m) \n");
  		res += "METHOD #10: updatePersonMeasure(3, Measure m) \n";
  		HealthMeasureHistory hmi = hmList.get(0);
        hmi.setValue("60");
        HealthMeasureHistory hmiUpdated = people.updatePersonMeasure(3, hmi);
        System.out.println("Printing the measure just created \n");
		res += "Printing the measure just created \n";
		System.out.println("Id measure: " + hmiUpdated.getIdMeasureHistory() + "\n");
        res += "Id measure: " + hmiUpdated.getIdMeasureHistory() + "\n";
        System.out.println("Measure: " + hmiUpdated.getValue() + "\n");
        res += "Measure: " + hmiUpdated.getValue() + "\n";
        System.out.println("Timestamp: " + hmiUpdated.getCreated() + "\n");
        res += "Timestamp: " + hmiUpdated.getCreated() + "\n";
        
        System.out.println("---------------------------------\n");
		res += "---------------------------------\n";
        
        bw.write(res);
        bw.close();
	}
}
