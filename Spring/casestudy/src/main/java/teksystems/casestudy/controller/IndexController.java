package teksystems.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        List<User> users = userDao.findByFirstNameIgnoreCaseContaining("A");
        for( User user : users ) {
            log.info("FN: " + user.toString());
        }

        List<User> usersByEmail = userDao.findByEmail("sn@gmail.com");
        for( User user : usersByEmail ) {
            log.info("Email: " + user.toString());
        }

        List<User> usersByFullName = userDao.findByFirstNameAndLastName("Sujata", "Naik");
        for( User user : usersByFullName ) {
            log.info("Full: " + user.toString());
        }

        // figure out how to add this to the model
        // add JSTL imports to your pom
        // figure out how to do a c:forEach in the JSP page

        response.setViewName("index");
        response.addObject("users", users);
        return response;
    }
}