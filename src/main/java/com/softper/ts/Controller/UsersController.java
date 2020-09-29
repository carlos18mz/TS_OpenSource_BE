package com.softper.ts.Controller;

import com.softper.ts.Resources.Comunications.BlockedResponse;
import com.softper.ts.Resources.Comunications.FavouriteResponse;
import com.softper.ts.Resources.Comunications.UserResponse;
import com.softper.ts.Resources.Outputs.BlockedOutput;
import com.softper.ts.Resources.Outputs.FavouriteOutput;
import com.softper.ts.Resources.Outputs.UserOutput;
import com.softper.ts.ServicesImp.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> findAllUsers()
    {
        UserResponse result = userService.findAllUsers();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("{userId}/favourites/{userfavouritedId}")
    public ResponseEntity<FavouriteResponse> setUserFavourited(@PathVariable(value = "userId")int userId, @PathVariable(value = "userfavouritedId")int userFavouritedId)
    {
        FavouriteResponse result = userService.setFavourited(userId, userFavouritedId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/{userId}/blockeds/{userBlockedId}")
    public ResponseEntity<BlockedResponse> setUserBlocked(@PathVariable(value = "userId")int userId, @PathVariable(value = "userBlockedId")int userBlockedId)
    {
        BlockedResponse result = userService.setBlocked(userId, userBlockedId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{userId}/favourites")
    public ResponseEntity<FavouriteResponse> findFavouritesByUserId(@PathVariable(value = "userId")int userId)
    {
        FavouriteResponse result = userService.findFavouritesByUserId(userId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{userId}/blockeds")
    public ResponseEntity<BlockedResponse> findBlockedsByUserId(@PathVariable(value = "userId")int userId)
    {
        BlockedResponse result = userService.findBlockedsByUserId(userId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/favourites")
    public ResponseEntity<FavouriteResponse> findAllFavourites()
    {
        FavouriteResponse result = userService.findAllFavourites();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/blockeds")
    public ResponseEntity<BlockedResponse> findAllBlockeds()
    {
        BlockedResponse result = userService.findAllBlockeds();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
