package medium.repository;



import medium.model.Blog;
import medium.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BlogRepository {
    private static List<Blog> blogList = new ArrayList<>();

    public void saveBlog(Blog blog){
        blogList.add(blog);
    }
    public List<Blog> findAll(){
        return blogList;
    }

    public void update(Blog blog, Long id) {
        var item = getById(blog.getId());
        blog.setTitle(blog.getTitle());
        blog.setContent(blog.getContent());
        blog.setStatus(blog.getStatus());
        blog.setUser(blog.getUser());
    }
    public void delete(Long id) {
        blogList.removeIf(blog -> blog.getId() == id);
    }

    public Blog getById(Long id) {
        for (Blog blog : blogList) {
            if (blog.getId() == id) {
                return blog;
            }
        }
        return null;
    }
}
