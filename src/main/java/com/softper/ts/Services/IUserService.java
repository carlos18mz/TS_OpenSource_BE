package com.softper.ts.Services;


import com.softper.ts.Model.User;
import com.softper.ts.Resources.Comunications.BlockedResponse;
import com.softper.ts.Resources.Comunications.FavouriteResponse;
import com.softper.ts.Resources.Comunications.UserResponse;
import com.softper.ts.Resources.Outputs.BlockedOutput;
import com.softper.ts.Resources.Outputs.FavouriteOutput;
import com.softper.ts.Resources.Outputs.UserOutput;
import java.util.List;

import java.util.Optional;

public interface IUserService extends ICrudService<User>{
    FavouriteResponse setFavourited(int userId, int favouriteId);
    BlockedResponse setBlocked(int userId, int blockedId);
    UserResponse findAllUsers();
    FavouriteResponse findFavouritesByUserId(int userId);
    BlockedResponse findBlockedsByUserId(int userId);
    FavouriteResponse findAllFavourites();
    BlockedResponse findAllBlockeds();
    FavouriteResponse findFavouriteByUserIdAndFavouriteId(int userId, int favouriteId);
    BlockedResponse findBlockByUserIdAndBlockedId(int userId, int blockedId);
    UserResponse findByEmail(String email);
    UserResponse findUserById(int userId);
}
