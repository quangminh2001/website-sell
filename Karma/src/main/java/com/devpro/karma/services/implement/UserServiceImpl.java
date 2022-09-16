package com.devpro.karma.services.implement;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.karma.dto.SaleorderSearch;
import com.devpro.karma.dto.UserSearchModel;
import com.devpro.karma.entities.Roles;
import com.devpro.karma.entities.Saleorder;
import com.devpro.karma.entities.Users;
import com.devpro.karma.repository.RoleRepository;
import com.devpro.karma.repository.UserRepository;
import com.devpro.karma.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	public Users createUser(Users user) {
		Roles role = roleRepository.findByName("GUEST");
		user.addRoles(role);
		user.setCreatedDate(new Date());
		return userRepository.save(user);
	}
	public List<Users> findAll(){
		return userRepository.findAll();
	}
	
	public Users findById(Integer id) {
		return userRepository.findById(id).get();
	}
	public Users save(Users user) {
		return userRepository.save(user);
	}
	public PagerData<Users> searchSaleorder(UserSearchModel searchModel, Integer quanlityPerPage) {

		String sql = "SELECT u FROM tbl_users u join tbl_users_roles us on u.id = us.user_id\r\n"
				+ "join tbl_roles r on us.role_id = r.id where r.name = 'GUEST'";
		if (searchModel != null) {
			if (!StringUtils.isEmpty(searchModel.keyword)) {
				sql += " and (s.username like '%" + searchModel.keyword + "%' or s.address like '%"
						+ searchModel.keyword + "%' or s.email like '%" + searchModel.keyword + "%' )";
			}
		}
		PagerData<Users> pager = new PagerData<Users>();
		Integer page = searchModel.currentPage;
		@SuppressWarnings("unchecked")
		List<Users> listData = entityManager.createQuery(sql).setFirstResult((page - 1) * quanlityPerPage)
				.setMaxResults((page - 1) * quanlityPerPage + quanlityPerPage).getResultList();
		pager.setCurrentPage(page);
		pager.setData(listData);

		pager.setTotalItems(listData.size());
		return pager;
	}
}
