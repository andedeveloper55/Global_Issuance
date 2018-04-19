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

@RestController
public class CardsController {

	 	private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping(value = "/cards" , method = RequestMethod.GET)
	    public Greeting getCardDetails(@RequestParam(value="name", defaultValue="World") String name) {
	        System.out.println("In Get Request");
	    	return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
	    
	    @RequestMapping(value = "/cards" , method = RequestMethod.POST)
	    public Greeting addCardDetails(@RequestParam(value="name", defaultValue="World") String name) {
	    	System.out.println("In Post Request");
	    	return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
	    
	    @RequestMapping(value = "/cards" , method = RequestMethod.DELETE)
	    public Greeting deleteCard(@RequestParam(value="name", defaultValue="World") String name) {
	    	System.out.println("In Delete Request");
	    	return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
}
