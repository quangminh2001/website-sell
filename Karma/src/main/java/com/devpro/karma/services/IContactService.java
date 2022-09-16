package com.devpro.karma.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.devpro.karma.dto.ContactSearchModel;
import com.devpro.karma.entities.Contacts;
import com.devpro.karma.services.implement.PagerData;

@Service
public interface IContactService {
	void saveOrUpdate(Contacts contact);
	List<Contacts> findAll();
	Long countContactNoSee();
	List<Contacts> findContactByStatusNoSee();
	Optional<Contacts> findByIDContact(Integer id);
	List<Contacts> dividePage(int page);
	Integer countPage();
	ContactSearchModel findContactModel(HttpServletRequest request);
	PagerData<Contacts> searchContact(ContactSearchModel searchModel);
	void deleteById(Integer id);
}
