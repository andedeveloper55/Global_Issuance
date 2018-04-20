package global_issuance.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import global_issuance.domain.Greeting;
import global_issuance.domain.Name;

@RestController
public class CardsController {

	 	private static final String template = "Hello, This API is under construction and not in MVP for demo.";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping(value = "/cards" , method = RequestMethod.GET)
	    public Greeting getCardDetails(@RequestParam(value="name", defaultValue="World") String name) {
	        System.out.println("In Get Request");
	    	return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
	    
	    @RequestMapping(value = "/cards" , method = RequestMethod.POST)
	    public Greeting addCardDetails(	    	
	    		@RequestParam(value="firstName") String firstName,
	    		@RequestParam(value="secondName") String secondName,
	    		@RequestParam(value="CardType") String cardType,
	    		@RequestParam(value="Income") String income,
	    		@RequestParam(value="employeeName") String employeeName
	    		) {
	    	Name name = new Name(firstName,secondName);
	    	System.out.println("In Post Request");
	    	return new Greeting(counter.incrementAndGet(),
	                            String.format(name.getFirstName() + ":" + name.getSecondName() +":" + cardType
	                            		+ ":" + income + ":"  + employeeName));
	    }
	    
	    @RequestMapping(value = "/cards" , method = RequestMethod.DELETE)
	    public Greeting deleteCard(@RequestParam(value="name", defaultValue="World") String name) {
	    	System.out.println("In Delete Request");
	    	return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
}
