package com.devpro.karma.controller.administrator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.ContactSearchModel;
import com.devpro.karma.entities.Contacts;
import com.devpro.karma.entities.Saleorder;
import com.devpro.karma.services.IContactService;

@Controller
@RequestMapping("/admin/contact")
public class AdminContactController extends BaseController{

	@Autowired
	private IContactService icontact;

	@SuppressWarnings("static-access")
	@GetMapping
	public String pageContact(final Model model, final HttpServletRequest request) {
		int page = getCurrentPage(request);
		String keyword = request.getParameter("keyword");
		String status = request.getParameter("status");
		ContactSearchModel search = new ContactSearchModel();
		search.setKeyword(request.getParameter("keyword"));
		search.setPage(page);
		search.setStatus(request.getParameter("status"));
		model.addAttribute("searchContact", icontact.searchContact(search));
		System.out.println(icontact.searchContact(search).getTotalItems());
		model.addAttribute("searchModel", search);
		return "administrator/contactlist";
	}

	@GetMapping("/{id}")
	public String detailContact(final Model model, @PathVariable("id") Integer id) {
		Contacts contact = icontact.findByIDContact(id).get();
		// push contact to view
		model.addAttribute("contact", contact);
		// set status to no see from see to no display in center measage
		contact.setStatus(true);
		// save it acording to id
		icontact.saveOrUpdate(contact);
		return "/administrator/contactdetail";
	}
	
	@PostMapping("/list/delete")
	public ResponseEntity<Map<String, Object>> blockOrActive(final Model model, final HttpServletRequest request,
			@RequestBody Contacts contacts) {
		System.out.println(contacts.getId());
		icontact.deleteById(contacts.getId());
		Map<String, Object> json = new HashMap<String, Object>();
		return ResponseEntity.ok(json);
	}
	
}
