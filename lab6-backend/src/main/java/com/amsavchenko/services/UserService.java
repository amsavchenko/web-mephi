package com.amsavchenko.services;

import com.amsavchenko.model.Users;

import java.util.List;

public interface UserService {

    List<Users> listAll();

    Users getById(Long id);

    Users saveUser(Users user);

    boolean checkIfExists(Users user);

    boolean checkIfEmailIsReserved(Users user);

}

