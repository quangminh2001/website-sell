package com.devpro.karma.controller.customer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.karma.controller.BaseController;
import com.devpro.karma.entities.Comments;
import com.devpro.karma.entities.Products;
import com.devpro.karma.entities.Users;
import com.devpro.karma.services.ICommentService;
import com.devpro.karma.services.IProductService;

@Controller
//@RequestMapping("/product/detail")
public class CommentController extends BaseController {

	@Autowired
	private ICommentService icomment;

	@Autowired
	IProductService iproduct;

	@PostMapping("/comment")
	public String postComment(final HttpServletRequest request) {

		Products product = iproduct.findById(Integer.parseInt(request.getParameter("productID")));
		String content = request.getParameter("content");
		Comments comments = new Comments();
		comments.setContent(content);
		String parentID = request.getParameter("parentID");
		if (!StringUtils.isEmpty(parentID)) {
			Comments comment = icomment.findById(Integer.parseInt(parentID));
			comments.setParent(comment);
		}
		comments.setCreatedDate(new Date());
		Users user = new Users();
		Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (userLogined != null && userLogined instanceof Users) {
			user = (Users) userLogined;
			comments.setCustomerName(user.getUsername());
		}else {
			comments.setCustomerName("Anonymous");
		}
		product.addComment(comments);
		iproduct.save(product);
		return "redirect:/product/detail/" + product.getSeo();
	}
}
