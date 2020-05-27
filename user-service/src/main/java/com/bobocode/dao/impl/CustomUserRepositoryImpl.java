package com.bobocode.dao.impl;

import com.bobocode.dao.CustomUserRepository;
import com.bobocode.model.Role;
import com.bobocode.model.RoleType;
import com.bobocode.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CustomUserRepositoryImpl implements CustomUserRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addRoleToAllUsers(RoleType roleType) {
        List<User> users = entityManager
                .createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles", User.class).getResultList();

        users.stream()
                .filter(user -> hasNoRole(user,roleType))
                .forEach(user -> user.addRole(Role.valueOf(roleType)));
    }

    private boolean hasNoRole(User user, RoleType roleType){
        return user.getRoles().stream()
                .map(Role::getRoleType)
                .noneMatch(type -> type.equals(roleType));
    }
}
