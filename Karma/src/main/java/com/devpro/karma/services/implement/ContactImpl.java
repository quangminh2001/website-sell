package com.devpro.karma.services.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.devpro.karma.dto.ContactSearchModel;
import com.devpro.karma.entities.Contacts;
import com.devpro.karma.entities.Products;
import com.devpro.karma.repository.ContactReponsitory;
import com.devpro.karma.repository.ProductReponsitory;
import com.devpro.karma.services.IContactService;

@Component
public class ContactImpl implements IContactService {
	@Autowired
	private ContactReponsitory contactReponsitory;

	@PersistenceContext
	private EntityManager entityManager;

	public void saveOrUpdate(Contacts contact) {
		if (contact.getId() == null || contact.getId() < 0) {
			contact.setCreatedDate(new Date());
		} else {
			contact.setUpdatedDate(new Date());
		}
		contactReponsitory.save(contact);
	}

	public void deleteById(Integer id) {
		contactReponsitory.deleteById(id);
	}

	public List<Contacts> findAll() {
		return contactReponsitory.findAll();
	}

	public Long countContactNoSee() {
		return contactReponsitory.countContactNoSee();
	}

	public List<Contacts> findContactByStatusNoSee() {
		return contactReponsitory.findContactByStatusNoSee();
	}

	public Optional<Contacts> findByIDContact(Integer id) {
		return contactReponsitory.findContactByID(id);
	}

	public List<Contacts> dividePage(int page) {
		if (page < 0)
			page = 0;
		return entityManager.createQuery("SELECT p FROM Contacts p order by p.status asc", Contacts.class)
				.setFirstResult(page * 10).setMaxResults(page * 10 + 10).getResultList();
	}

	public Integer countPage() {
		return (int) Math.ceil(Double.parseDouble(contactReponsitory.countContact() + "") / 10);
	}

	public ContactSearchModel findContactModel(HttpServletRequest request) {
		int page = request.getParameter("page") == null?1:Integer.parseInt(request.getParameter("page"));
		ContactSearchModel search = new ContactSearchModel();
		search.setKeyword(request.getParameter("keyword"));
		search.setPage(page);
		search.setStatus(request.getParameter("status"));
		return search;
	}

	public PagerData<Contacts> searchContact(ContactSearchModel searchModel) {
		String query = "Select c from Contacts c where 1 = 1";
		PagerData<Contacts> pager = new PagerData<Contacts>();
		if (searchModel != null) {
			if (!StringUtils.isEmpty(searchModel.keyword))
				query += " and (c.lastName  like '%" + searchModel.keyword + "%' or c.firstName like '%"
						+ searchModel.keyword + "%' or c.email like '%" + searchModel.keyword + "%') ";
			if (!StringUtils.isEmpty(searchModel.status)&& !searchModel.status.equals("-1"))
				query += " and c.status = " + searchModel.status;
			query += "order by c.createdDate desc";
			
			Query sql = entityManager.createQuery(query);
			int page = searchModel.getPage();
			pager.setCurrentPage(page);
			pager.setTotalItems(sql.getResultList().size());
			@SuppressWarnings("unchecked")
			List<Contacts> listContacts = sql.setFirstResult((page - 1) * 10)
					.setMaxResults((page - 1) * 10 + 10).getResultList();
			pager.setData(listContacts);
			
			
		}
		return pager;
	}
}
