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


}
