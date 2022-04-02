package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.formbean.RegisterFormBean;

import java.util.Date;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserDAO userDao;
    // Ignore the warning on @Autowired

    /*
     This is the controller method for the entry point of the user registration form.
     It does not do anything other than provide a route to register.jsp.
     */
    @RequestMapping (value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register"); /* This is the JSP we need. */
        return response;
    }
    @RequestMapping (value = "/user/registerSubmit", method = RequestMethod.POST) /* This is the URL part after localhost:8080. */
    //public ModelAndView registerSubmit(@RequestParam("email") String email) throws Exception {
    //public ModelAndView registerSubmit() throws Exception {
    public ModelAndView registerSubmit(RegisterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register"); /* This is the JSP we need. */

        User user = new User();

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPassword(form.getPassword());
        //user.setCreateDate(new Date());

        userDao.save(user);

        log.info(form.toString());
        return response;
    }
}
