package test.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import test.request.PersonRequest;
import test.response.PersonResponse;
import test.service.PersonService;

@Controller
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping(value=PersonController.BASE_MAPPING)
public class PersonController {
	
	public static final String BASE_MAPPING="backend-test";
	
	@Autowired
	private PersonService personService;
	
	private Log log;
	private Gson gson = new GsonBuilder().create();
	
	public PersonController(){
		log = LogFactory.getLog(PersonController.class);
	}

	@CrossOrigin
	@RequestMapping(value="/addPerson", method=RequestMethod.POST)
	public @ResponseBody String add(@RequestBody String request){
		PersonRequest personRequest;
		PersonResponse personResponse;
		String response=null;
		
		try{
			log.info(request);
			personRequest = gson.fromJson(request, PersonRequest.class);
			personResponse = personService.handleRequest(personRequest);
			response = gson.toJson(personResponse);
		}catch(Exception e){
			log.error(request, e);
		}
		return response;
	}

	@CrossOrigin
	@RequestMapping(value="/getPerson", method=RequestMethod.GET)
	public @ResponseBody String get(){
		PersonResponse personResponse;
		String response=null;
		
		try{
			personResponse = personService.handleRequest();
			response = gson.toJson(personResponse);
		}catch(Exception e){
			log.error("No Request", e);
		}
		return response;
	}
}
