package todo;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepo;
	
	
	@GetMapping
	public String getAllTodos(Model model) {
		List<Todo> todos = todoRepo.findAll();
		model.addAttribute("todos", todos);
		return "home";
	}
	
	@GetMapping("/delete")
	public String deleteTodo(@RequestParam(name="id") String id){
		Todo todo = todoRepo.findById(Long.valueOf(id)).get();
		todoRepo.delete(todo);
		return "redirect:/";
	}
	

}
