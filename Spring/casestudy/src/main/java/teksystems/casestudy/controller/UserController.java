package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

        // These two lines are seeding the model with an empty form bean, so that the JSP
        // substitutions will not error out.
        // Here, Spring is being nice enough not to throw errors.

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }

    /**
     *
     * @param form
     * @return
     * @throws Exception
     *
     * This method becomes a "create" and an "edit" based on if the "id" is populated in the RegisterFormBean.
     */
    //public ModelAndView registerSubmit(@RequestParam("email") String email) throws Exception {
    //public ModelAndView registerSubmit() throws Exception {
    @RequestMapping (value = "/user/registerSubmit", method = RequestMethod.POST) /* This is the URL part after localhost:8080. */
    public ModelAndView registerSubmit(RegisterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register"); /* This is the JSP we need. */

        // try to load the user from db using incoming id
        User user = userDao.findById(form.getId());

        // now check if the user is null, it means user isn't in the db. We then create a user.
        if (user == null) {
            user = new User();
        }

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPassword(form.getPassword());
        //user.setCreateDate(new Date());

        userDao.save(user);

        // form -> form bean -> database

        log.info(form.toString());

        // instead of showing the same register page, redirect the user to the edit page, where data is loaded from
        // the db
        // redirect: uses an actual URL, rather than a view name path
        response.setViewName("redirect:/user/edit/" + user.getId());

        return response;
    }

    // This method is for editing a user. There is a path parameter being used to pass the userid from the user to be edited.
    // UseGetMapping or @RequestMapping with GET
    //@GetMapping ("/user/edit")
    @RequestMapping (value = "/user/edit/{userId}", method = RequestMethod.GET) /* This is the URL part after localhost:8080. */
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
// This works too, but the url will be: /user/edit?userId=1.
//    @RequestMapping (value = "/user/edit", method = RequestMethod.GET) /* This is the URL part after localhost:8080. */
//    public ModelAndView editUser(@RequestParam("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register"); /* This is the JSP we need. */

        User user = userDao.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setPassword(user.getPassword());
        form.setCpassword(user.getPassword());

        response.addObject("form", form);

        // database -> form bean -> form

        return response;
    }
}
