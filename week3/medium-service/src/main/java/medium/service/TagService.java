package medium.service;


import medium.model.Tag;
import medium.repository.TagRepository;

import java.util.List;

public class TagService {
    private TagRepository tagRepository = new TagRepository();

    public void createTag(Tag tag){
        tagRepository.saveTag(tag);
        System.out.println("createTag::" + tag.getTitle());
    }

    public List<Tag> getAll(){
        return tagRepository.findAll();
    }
    public  void printAllTag(){ //bütün userları getiren metod
        getAll().forEach(tag -> System.out.println(tag.getTitle()));
    }


}
