package com.devpro.karma.controller.administrator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.SaleorderSearch;
import com.devpro.karma.entities.Products;
import com.devpro.karma.entities.Saleorder;
import com.devpro.karma.services.ISaleorderService;
import com.devpro.karma.services.implement.PagerData;

@Controller
@RequestMapping(value = "/admin/saleorder")
public class AdminSaleorderController extends BaseController{
	@Autowired
	private ISaleorderService isaleorder;
	
	@GetMapping("/list")
	public String defaultViewSaleorder(final HttpServletRequest request, final Model model) {
		SaleorderSearch saleorderSearch = new SaleorderSearch();
		String keyword = request.getParameter("keyword");
		Integer page = getCurrentPage(request);
		Integer perPage = StringUtils.isEmpty(request.getParameter("numberPerPage")) ? 20 : Integer.parseInt(request.getParameter("numberPerPage"));
		saleorderSearch.setCurrentPage(page);
		saleorderSearch.setKeyword(keyword);
		PagerData<Saleorder> pagerData = isaleorder.searchSaleorder(saleorderSearch, perPage);
		model.addAttribute("pagerData",pagerData);
		model.addAttribute("searchModel",saleorderSearch);
		model.addAttribute("perPage",perPage);
		return "administrator/saleorderlist";
	}
	
	@PostMapping("/list/blockOrActive")
	public ResponseEntity<Map<String, Object>> blockOrActive(final Model model, final HttpServletRequest request,
			@RequestBody Saleorder saleorder) {
		Saleorder saleo = isaleorder.findById(saleorder.getId());
		Map<String, Object> json = new HashMap<String, Object>();
		saleo.setStatusorder(saleorder.getStatusorder());
		isaleorder.saveOrUpdate(saleo);
		json.put("status", saleo.getStatusorder());
		return ResponseEntity.ok(json);
	}
	
}
