package todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepo;
	
	
	@GetMapping
	public String getAllTodos(Model model) {
		List<Todo> todos = todoRepo.findAll();
		model.addAttribute("todos", todos);
		model.addAttribute("todo", new Todo());
		return "home";
	}
	
	@GetMapping("/delete")
	public String deleteTodo(@RequestParam(name="id") String id){
		Todo todo = todoRepo.findById(Long.valueOf(id)).get();
		todoRepo.delete(todo);
		return "redirect:/todo";
	}
	
	@PostMapping
	public String createNewTodo(@ModelAttribute Todo todo) {
		Todo createdTodo = todoRepo.save(todo);
		log.info("New TODO created: " + createdTodo);
		return "redirect:/todo";
	}
	

}
