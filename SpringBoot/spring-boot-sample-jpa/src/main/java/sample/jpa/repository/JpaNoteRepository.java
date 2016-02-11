package sample.jpa.repository;

import org.springframework.stereotype.Repository;
import sample.jpa.domain.Note;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaNoteRepository implements NoteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Note> findAll() {
        return this.entityManager.createQuery("SELECT n FROM Note n", Note.class)
                .getResultList();
    }
}
