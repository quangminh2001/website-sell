package com.devpro.karma.controller.administrator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.dto.SaleorderSearch;
import com.devpro.karma.entities.Contacts;
import com.devpro.karma.entities.Saleorder;
import com.devpro.karma.services.CustomService;
import com.devpro.karma.services.IContactService;
import com.devpro.karma.services.ISaleorderService;
import com.ibm.icu.text.DecimalFormat;

@Controller
@RequestMapping("/admin")
public class AdminDefaultController extends BaseController {
	@Autowired
	private IContactService icontact;

	@Autowired
	private ISaleorderService iSaleorderService;

	@Autowired
	private CustomService customservice;

	@ModelAttribute("numberPending")
	public Integer numberPending() {
		SaleorderSearch saleorderSearch = new SaleorderSearch();
		saleorderSearch.setCurrentPage(1);
		saleorderSearch.setStatus("Pending");
		return iSaleorderService.searchSaleorder(saleorderSearch, 100).getData().size();
	}

	@GetMapping("/index")
	public String defaultView(final Model model) {
		BigDecimal totalMonthly = BigDecimal.ZERO;
		List<BigDecimal> list2 = customservice.customerSaleorder();
		for (BigDecimal bigDecimal : list2) {
			totalMonthly = totalMonthly.add(bigDecimal);
		}
		model.addAttribute("listMonthly", list2);
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println(df.format(new BigDecimal(totalMonthly+"")));
		
		
		model.addAttribute("monthly", df.format(new BigDecimal( totalMonthly.divide(new BigDecimal(list2.size())) + "")) );
		int countFinish = 0, countDelete = 0, countPending = 0, countDelivering = 0;
		BigDecimal total = BigDecimal.ZERO;
		List<Saleorder> list = iSaleorderService.findAll();
		for (Saleorder saleorder : list) {
			if (saleorder.getStatusorder().equalsIgnoreCase("Pending")) {
				countPending++;
			} else if (saleorder.getStatusorder().equalsIgnoreCase("Finished")) {
				countFinish++;
				total = total.add(saleorder.getTotal());
			} else if (saleorder.getStatusorder().equalsIgnoreCase("Delivering")) {
				countDelivering++;
			} else {
				countDelete++;
			}
		}
		model.addAttribute("total", df.format(new BigDecimal(total+"")));
		int count = list.size();
		model.addAttribute("countFinish", Math.floor((1.0 * countFinish / count) * 100));
		model.addAttribute("countDelete", Math.floor(1.0 * countDelete / count * 100));
		model.addAttribute("countDelivering", Math.floor(1.0 * countDelivering / count * 100));
		model.addAttribute("countPending", Math.floor(1.0 * countPending / count * 100));
		return "/administrator/index";
	}

	@GetMapping("/topbar")
	public String topbarView(final Model model) {
		List<Contacts> listNoSee = icontact.findContactByStatusNoSee();
		// push to view all contact k see
		model.addAttribute("contactNoSee", listNoSee);
		// push amount message
		model.addAttribute("count", listNoSee.stream().count());
		return "/administrator/layout/topbar";
	}
}
