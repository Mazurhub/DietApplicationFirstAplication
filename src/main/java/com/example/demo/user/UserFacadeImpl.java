package com.example.demo.user;

import com.example.demo.user.api.UserFacade;
import com.example.demo.user.api.dto.CreateUser;
import com.example.demo.user.api.dto.UpdateUser;
import com.example.demo.user.api.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component // tutaj + w klasach Usecase może być też rónież @Service
class UserFacadeImpl implements UserFacade {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final GetUsersUseCase getUsersUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    UserFacadeImpl(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase, GetUsersUseCase getUsersUseCase, UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @Override
    public User createUser(CreateUser createUser) {
        var id = createUserUseCase.execute(createUser);
        return getUserById(id);
    }

    public User getUserById(UUID id){
        return getUserUseCase.execute(id);
    }

    public List<User> getUsers() {
        return getUsersUseCase.execute();
    }

    @Override
    public User updateUser(UUID id, UpdateUser updateUser) {
        updateUserUseCase.execute(id, updateUser);
        return getUserById(id);
    }

    @Override
    public long deleteUser(UUID id) {
        return deleteUserUseCase.execute(id);
    }


}
