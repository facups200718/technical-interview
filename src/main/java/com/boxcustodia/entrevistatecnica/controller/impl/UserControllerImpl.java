package com.boxcustodia.entrevistatecnica.controller.impl;

import com.boxcustodia.entrevistatecnica.controller.UserController;
import com.boxcustodia.entrevistatecnica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;
}
