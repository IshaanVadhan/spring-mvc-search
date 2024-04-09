package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	@RequestMapping("/home")
	public String home() {
//		NullPointerException created
//		String str = null;
//		System.out.println(str.length());

//		NumberFormatException created
//		String str = "abc";
//		Integer.parseInt(str);

		return "home";
	}

	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		RedirectView redirectView = new RedirectView();
		String baseUrl = "https://www.google.com/search?q=";
		redirectView.setUrl(baseUrl + query);
		return redirectView;
	}

//	@ExceptionHandler({ NullPointerException.class, NumberFormatException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String exceptionHandlerNull(Model m) {
		m.addAttribute("msg", "Null Pointer Exception has occurred!");
		return "null_page";
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NumberFormatException.class)
	public String exceptionNumberFormat(Model m) {
		m.addAttribute("msg", "Number Format Exception has occurred!");
		return "null_page";
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String exceptionGeneric(Model m) {
		m.addAttribute("msg", "Exception has occurred!");
		return "null_page";
	}
}
