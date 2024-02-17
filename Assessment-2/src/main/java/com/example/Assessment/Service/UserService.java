package com.example.Assessment.Service;

import com.example.Assessment.Model.User;
import com.example.Assessment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepoObj;
    private TokenService tokenServiceObj;
    @Autowired
    public UserService(UserRepository userRepoObj,TokenService tokenServiceObj) {
        this.userRepoObj = userRepoObj;
        this.tokenServiceObj = tokenServiceObj;
    }


    public User save(User user) {
        return userRepoObj.save(user);
    }

    public List<User> findAll(){return userRepoObj.findAll();}

    public boolean existsById(int id){
        return  userRepoObj.existsById(id);
    }

    public void deleteById(int id){
        userRepoObj.deleteById(id);
    }

    public Optional<User> update(User user){
        Optional<User> tempObj = Optional.of(userRepoObj.saveAndFlush(user));
        int id = user.getId();
        if(existsById(id))return tempObj;
        return null;
    }

    public void delete(User user){
        userRepoObj.delete(user);
    }



    public boolean existsByEmail(String email){
        Optional<User>userObj = Optional.ofNullable( userRepoObj.getUserByUserName(email));

        if(!userObj.isEmpty())return true;
        return false;


    }

    public String userLogin(String email,String password){
        boolean found = existsByEmail(email);
        if(found){
            User user  = userRepoObj.getUserByUserName(email);
            if(user.getPassword1().equals(password)){
                return "{" +
                        "\"message\":"+"Successfully created user\",\n"+
                        "\"data\":"+user+",\n"+
                        "\"Email: "+user.getEmail()+"\n"+
                        "\"token:"+tokenServiceObj.createToken(user.getId())+
                        "}";
            }
        }
        return "{" +
                "\"message\":"+"Authentication Failed\",\n"+
                "}";
    }



}
