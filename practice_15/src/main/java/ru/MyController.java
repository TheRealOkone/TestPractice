package ru;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MyController {

//    @Autowired
//    @Value("${user.password}")
//    private String password;
//    @Autowired
//    @Value("${user.user}")
//    private String user;
//    @Autowired
//    @Value("${user.db_url}")
//    private String db_url;

//    UserService a = new UserService(sessionFactory);
    @Autowired
    private UserService a;



    @RequestMapping(value = "/records", method = RequestMethod. GET)
    public ResponseEntity<List<Item>> retjson(){
        return new ResponseEntity<List<Item>> (a.getUsers(), HttpStatus.OK);
    }
    @RequestMapping(value = "/records", method = RequestMethod. POST)
    public void postjson(@RequestBody Item w){
        a.insertUser(w);
    }


}