package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.formbean.RegisterFormBean;
import teksystems.casestudy.formbean.SearchFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
     *
     * This method becomes a "create" and an "edit" based on if the "id" is populated in the RegisterFormBean.
     */
    //public ModelAndView registerSubmit(@RequestParam("email") String email) throws Exception {
    //public ModelAndView registerSubmit() throws Exception {
    @RequestMapping (value = "/user/registerSubmit", method = RequestMethod.POST) /* This is the URL part after localhost:8080. */
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            //HashMap errors = new HashMap();
            for (ObjectError error: bindingResult.getAllErrors()) {
                //errors.put(((FieldError) error).getField(), error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            // add the errors to the response object
            //response.addObject("formErrors", errors);

            // Because there is/are error/errors, we do not want to process the logic below.
            // That will create a new  user in the db.
            // We want to shoe register.jsp.
            response.setViewName("redirect:/user/register");
            return response;
        }

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
    // Use GetMapping or @RequestMapping with GET
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

    // create a form on the user search page that submits to this route using a get method
    // make an input box for the user to enter a search term for first name
    // add a @RequestParam to take in a search value from the input box - use required = false in the annotation
    // use the search value in the query
    // add the search value to the model and make it display in the input box when the page reloads
    // add error checking to make sure that the incoming search value is not null and is not empty.
    // find apache string utils on maven central and add it to your pom file - very high recommendation
    // research the StringUtils.isEmpty function and use for error checking
    //@GetMapping (value="/user/search")
    public ModelAndView searchNoBean(@RequestParam(required=false, name="search") String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/user/search");

        // the below code is for using with @requestparam
        if (!StringUtils.isBlank(search)) {
            List<User> users = userDao.findByFirstNameIgnoreCaseContaining(search);
            response.addObject("user", users);
        }
        else {
            log.info("Search term cannot be empty!");
        }

        response.addObject("search", search);

        return response;
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public ModelAndView search() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        // this seeds the model with an empty form bean. this is needed by the jsp page
        // since it references the fields there.
        SearchFormBean form = new SearchFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/user/searchSubmit", method = RequestMethod.POST)
    public ModelAndView searchSubmit(@Valid SearchFormBean form, BindingResult bindingResult) throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        // error checking, uses @Valid, form bean
        if(bindingResult.hasErrors()) {
            log.info("Errors in the form");
            response.setViewName("user/search");
            return response;
        }

        List<User> users = userDao.findByFirstNameIgnoreCaseContaining(form.getSearch());
        if (users == null) users = new ArrayList<User>();

        response.addObject("user", users);
        response.addObject("form", form);

        return response;
    }

}
