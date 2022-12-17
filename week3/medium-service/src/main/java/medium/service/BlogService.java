package medium.service;


import medium.model.Blog;
import medium.model.User;
import medium.repository.BlogRepository;

import java.util.List;


public class BlogService {
    private BlogRepository blogRepository = new BlogRepository();

    public void createBlog(Blog blog) {
        blogRepository.saveBlog(blog);
        System.out.println("createBlog::" + blog.getTitle());
    }

    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    public void printAll(List<Blog> blogList) {
        blogList.forEach(blog -> System.out.println(blog));

//        getAll().forEach(blog -> System.out.println(blog));
    }

    public List<Blog> getAllByUser(User user) { //kullanıcının mailine göre blogları getirir
        return getAll().stream().filter(blog -> blog.getUser().getMail().equals(user.getMail()))
                .toList();
    }

    public void update(Blog blog,Long id) {
        blogRepository.update(blog,id);
    }

    public void delete(Long id) {
        blogRepository.delete(id);
    }
    public Blog getById(Long id) {
        return blogRepository.getById(id);
    }
}
