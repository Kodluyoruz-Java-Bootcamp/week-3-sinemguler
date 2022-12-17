package medium.repository;


import medium.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagRepository {
    private static List<Tag> tagList= new ArrayList<>();

    public void saveTag(Tag tag){
        tagList.add(tag);
    }
    public List<Tag> findAll(){
        return tagList;
    }

}
