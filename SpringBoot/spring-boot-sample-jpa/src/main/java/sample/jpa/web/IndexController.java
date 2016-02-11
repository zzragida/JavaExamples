package sample.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sample.jpa.domain.Note;
import sample.jpa.repository.NoteRepository;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping("/")
    @Transactional(readOnly = true)
    public ModelAndView index() {
        List<Note> notes = this.noteRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

}
