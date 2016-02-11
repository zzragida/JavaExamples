package sample.jpa.repository;

import sample.jpa.domain.Tag;

import java.util.List;

public interface TagRespository {

    List<Tag> findAll();
}
