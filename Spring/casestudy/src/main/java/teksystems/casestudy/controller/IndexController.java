package teksystems.casestudy.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        // Checks in the application properties for settings.
        // Need to "rebuild" application
        log.debug("Lombok - debug");
        log.info("Lombok - info");
        log.warn("Lombok - warn");

        /* don't need all this
        List<User> users = userDao.findByFirstNameIgnoreCaseContaining("A");
        for( User user : users ) {
            log.info("FN: " + user.toString());
        }

        User userByEmail = userDao.findByEmail("sn@gmail.com");
        log.info("Email: " + userByEmail.toString());

        List<User> usersByFullName = userDao.findByFirstNameAndLastName("Sujata", "Naik");
        for( User user : usersByFullName ) {
            log.info("Full: " + user.toString());
        }
        */

        // figure out how to add this to the model
        // add JSTL imports to your pom
        // figure out how to do a c:forEach in the JSP page

        //    This will get username/email in this controller class.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User loggedInUser = userDao.findByEmail(currentPrincipalName);


        if (loggedInUser == null) {
            log.debug("Not logged in");
        }
        else {
            log.debug("User logged in: " + loggedInUser);
        }
        response.setViewName("index");
        //response.addObject("users", users);
        return response;
    }

}