package springmvcsearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		RedirectView redirectView = new RedirectView();
		String baseUrl = "https://www.google.com/search?q=";
		redirectView.setUrl(baseUrl + query);
		return redirectView;
	}
}
