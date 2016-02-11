package sample.jpa.repository;

import org.springframework.stereotype.Repository;
import sample.jpa.domain.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaTagRepository implements TagRespository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tag> findAll() {
        return this.entityManager.createQuery("SELECT t FROM Tag t", Tag.class)
                .getResultList();
    }
}
