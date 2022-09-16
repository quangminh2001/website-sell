package com.devpro.karma.controller.customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.entities.Contacts;
import com.devpro.karma.repository.ContactReponsitory;
import com.devpro.karma.services.IContactService;
import com.devpro.karma.services.implement.ContactImpl;

@Controller
@RequestMapping("/contact")
public class ContactController extends BaseController {
	@Autowired
	private IContactService icontact;

	@GetMapping()
	public String viewContactDefault(
			final Model model, 
			final HttpServletRequest request, 
			final HttpServletResponse response)
			throws IOException {
		return "customer/contact";
	}
	@PostMapping("/ajax")
	public ResponseEntity<Map<String, Object>> defaultView(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody Contacts subcriber) {
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("message", "We will send the notice to you '" + subcriber.getEmail() + "' as soon as possible");
		return ResponseEntity.ok(jsonResult);
	}

	@PostMapping("/save")
	public ResponseEntity<Map<String, Object>> saveContact(final Model model, 
												final HttpServletRequest request,
												final @RequestBody Contacts contact) {
		icontact.saveOrUpdate(contact);
		Map<String, Object> messageReponse = new HashMap<String, Object>();
		messageReponse.put("status", 200);
		messageReponse.put("message","Mr/Mrs."+ contact.getLastName()+ " send message successfully. We will reponse as soon as possible");
		return ResponseEntity.ok(messageReponse);
	}

}
