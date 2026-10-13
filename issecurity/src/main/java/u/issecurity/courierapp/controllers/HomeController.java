package u.issecurity.courierapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courier")
public class HomeController {

	@GetMapping("/index")
	public String showHomePage() {

		return "index";
	}

	@GetMapping("/logout")
	public String showLogOut() {

		return "index logout";
	}

}
