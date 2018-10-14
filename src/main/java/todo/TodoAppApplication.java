package todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping
public class TodoAppApplication {
	
	@GetMapping("/")
	public String homeMessage(Model model) {
		model.addAttribute("message", "I am first spring-boot app");
		return "home";
	} 

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}
}
