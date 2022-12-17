package medium.controller;

import medium.model.Blog;
import medium.model.User;
import medium.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/getall")
    public List<Blog> getAll(){
        return  blogService.getAll();
    }

    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody Blog blog){
        blogService.createBlog(blog);
        System.out.println("Create - userService :: " + blogService);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public void update(@RequestBody Blog blog, Long id) {
        blogService.update(blog, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        blogService.delete(id);
        return "deleted" + id;
    }
    @GetMapping("/{id}")
    public Blog getById(@PathVariable() Long id) {
        return blogService.getById(id);
    }
}
