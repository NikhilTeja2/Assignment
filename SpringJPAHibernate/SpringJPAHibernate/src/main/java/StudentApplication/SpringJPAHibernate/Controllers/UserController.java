package StudentApplication.SpringJPAHibernate.Controllers;

import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepoObj;
    @PostMapping("/signup")
    public User save(@RequestBody User userObj){
        System.out.println(userObj);
        User userResponse = userRepoObj.save(userObj);

        return userResponse;
    };
    @PostMapping("/user/delete")
    public void delete(@RequestBody User userObj){
        System.out.println(userObj);
        userRepoObj.delete(userObj);
    };

    @GetMapping("/user/findAll")
    public List<User> findAll(@RequestBody User userObj) {
        // Use the userRepoObj to fetch all users
        List<User> userList = userRepoObj.findAll();
        return userList;
    }

    @GetMapping("/")
    public String index() {
        return "Hello!!!";
    }

}

