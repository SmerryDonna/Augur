package com.augur.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/messaggi") // This means URL's start with /demo (after Application path)
public class MessageController {
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private MessageRepository messageRepository;

	public MessageController() {

	}

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewMessage(
			@RequestParam(value = "indirizzoPortafoglio", required = true) String indirizzoPortafoglio,
			@RequestParam(value = "previsione", required = true) String previsione,
			@RequestParam(value = "valuta", required = true) String valuta,
			@RequestParam(value = "scommessa", required = true) String scommessa) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Message n = new Message(indirizzoPortafoglio, previsione, valuta, scommessa);
		System.out.println(n);
		messageRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Message> getAllMessages() {
		// This returns a JSON or XML with the users
		return messageRepository.findAll();
	}
}
