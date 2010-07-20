package com.demotape.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserDao userDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		model.addAttribute("userList", userDAO.getAllUsers());
		return "users/list";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable long id, Model model) {
		model.addAttribute("user", userDAO.loadUser(id));
		model.addAttribute("PathVariable", id);
		return "users/show";
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newUserForm(Model model) {		
		model.addAttribute("user", new Users());
		return "users/new";		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String add(Model model, @ModelAttribute("user") @Valid Users user, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("user", user);
			return "users/new";
		}
		//Setting role
		user.setAuthority("ROLE_USER");
		
		userDAO.saveUser(user);
		
		model.addAttribute("successMessage", "User saved successfully.");
		return "redirect:/users";
	}
	
	@RequestMapping(value="/{id}/edit", method = RequestMethod.GET)
	public String editUserForm(@PathVariable long id, Model model) {		
		model.addAttribute("user", userDAO.loadUser(id));
		return "users/edit";
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String update(Model model, @ModelAttribute("user") @Valid Users user, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("user", user);
			return "users/edit";
		}
		userDAO.updateUser(user);
		model.addAttribute("successMessage", "User updated successfully.");
		return "redirect:/users";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable long id){
		userDAO.deleteUser(id);
		return "redirect:/users";
	}
}
