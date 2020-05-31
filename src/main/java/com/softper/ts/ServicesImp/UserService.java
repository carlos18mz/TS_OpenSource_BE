package com.softper.ts.ServicesImp;

import com.softper.ts.Resources.Comunications.BlockedResponse;
import com.softper.ts.Resources.Comunications.FavouriteResponse;
import com.softper.ts.Resources.Comunications.SubscriptionResponse;
import com.softper.ts.Resources.Comunications.UserResponse;
import com.softper.ts.Resources.Outputs.BlockedOutput;
import com.softper.ts.Resources.Outputs.FavouriteOutput;
import com.softper.ts.Resources.Outputs.UserOutput;
import com.softper.ts.Services.IUserService;
import com.softper.ts.Model.Block;
import com.softper.ts.Model.Favourite;
import com.softper.ts.Model.User;
import com.softper.ts.Repositories.IBlockRepository;
import com.softper.ts.Repositories.IFavouriteRepository;
import com.softper.ts.Repositories.IUserRepository;
import com.softper.ts.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Override
    public FavouriteResponse setFavourited(int userId, int favouriteId) {
        return null;
    }

    @Override
    public BlockedResponse setBlocked(int userId, int blockedId) {
        return null;
    }

    @Override
    public UserResponse findAllUsers() {
        return null;
    }

    @Override
    public FavouriteResponse findFavouritesByUserId(int userId) {
        return null;
    }

    @Override
    public BlockedResponse findBlockedsByUserId(int userId) {
        return null;
    }

    @Override
    public FavouriteResponse findAllFavourites() {
        return null;
    }

    @Override
    public BlockedResponse findAllBlockeds() {
        return null;
    }

    @Override
    public UserResponse findByEmail(String email) {
        return null;
    }

    @Override
    public User save(User user) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<User> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() throws Exception {
        return null;
    }
}
