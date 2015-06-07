package de.haw.ants.aip.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.haw.ants.aip.auftrag.entity.Auftrag;
import de.haw.ants.aip.auftrag.facade.interfaces.IAuftragService;
import de.haw.ants.aip.web.model.AuftragModel;
import de.haw.ants.aip.web.util.Mapper;

@RestController
public class MainController {


	
	// Java 8 convenience in case we need a different format or different object keys in our json
	private static final Mapper<AuftragModel> mapper = new Mapper<AuftragModel>()  
			.map("Bauteilnr", AuftragModel::getBauteilnr)
			.map("Kundennr", AuftragModel::getKundennr)
			.map("Preis", AuftragModel::getPreis);

	
	@Autowired IAuftragService auftragservice;
	
		
    @RequestMapping(value="/auftrag", 
            method=RequestMethod.POST, 
            produces=MediaType.APPLICATION_JSON_VALUE)
    public Map<String,? extends Object> getUsers(@RequestParam(required = true, value = "kundennr") String kundennr,
    											 @RequestParam(required = true, value = "bauteilnr") String bauteilnr,
    											 @RequestParam(required = true, value = "preis") String preis) {
        auftragservice.erstelleAuftrag(new AuftragModel(Long.parseLong(bauteilnr), Long.parseLong(kundennr), Double.parseDouble(preis)).toAuftrag());
    	return mapper.apply(new AuftragModel(Long.parseLong(bauteilnr), Long.parseLong(kundennr), Double.parseDouble(preis))); // our object have name, id, label
    }
    
	  @RequestMapping(value="/aufträge/{id}", 
	  method=RequestMethod.GET, 
	  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Auftrag> getUser(@PathVariable("id") Long id) {
		  
		  return auftragservice.getAuftragForKunde(id);// our object have name, id, label
	}
    
//    @RequestMapping(value="/auftrag", 
//            method=RequestMethod.GET, 
//            produces=MediaType.APPLICATION_JSON_VALUE)
//    public String getAuftrag(){
//    	return "YEAH";// our object have name, id, label
//    }
    

//    @RequestMapping(value="/users/{id}", 
//            method=RequestMethod.GET, 
//            produces=MediaType.APPLICATION_JSON_VALUE)
//    public User getUser(@PathVariable("id") Long id) {
//        return userService.getUserById(id); // our object have name, id, label
//    }
//    

}