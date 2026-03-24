package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.LoginInfo;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;


@PostMapping("/login")
public Result login(@RequestBody Emp emp){
   log.info("员工来登录啦，{}",emp);

    LoginInfo logininfo=empService.login(emp);
if(logininfo!=null){

    return  Result.success(logininfo);
}
return  Result.error("用户名或密码错误");

}


}
