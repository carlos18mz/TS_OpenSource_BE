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

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IFavouriteRepository favouriteRepository;
    @Autowired
    IBlockRepository blockRepository;


    @Override
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        userRepository.deleteById(id);
    }


    public void deleteObj(User user) throws Exception {
        userRepository.delete(user);
    }


    public Optional<User> findById(Integer id) throws Exception {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }


    @Override
    public FavouriteResponse setFavourited(int userId, int favouriteId) {
        try
        {
            User getUser = userRepository.findById(userId).get();
            User getFavourite = userRepository.findById(favouriteId).get();
            if(getUser.getPerson().getPersonType()!= 1 || getFavourite.getPerson().getPersonType() != 2)
                return new FavouriteResponse("Only customers can set drivers as favourites");
            Favourite newFavourite = new Favourite();
            newFavourite.setUser(getUser);
            newFavourite.setFavourited(getFavourite);

            newFavourite = favouriteRepository.save(newFavourite);

            FavouriteOutput newFavouriteOutput =new FavouriteOutput();
            newFavouriteOutput.setUser(newFavourite.getUser().getPerson().getFirstName()+" "+newFavourite.getUser().getPerson().getLastName());
            newFavouriteOutput.setFavourited(newFavourite.getFavourited().getPerson().getFirstName()+" "+newFavourite.getFavourited().getPerson().getLastName());
            newFavouriteOutput.setSince(newFavourite.getCreatedAt());

            return new FavouriteResponse(newFavouriteOutput);
        }
        catch (Exception e)
        {
            return new FavouriteResponse("An error ocurred while saving the favourite relation : "+e.getMessage());
        }
    }

    @Override
    public BlockedResponse setBlocked(int userId, int blockedId) {
        try
        {
            User getUser = userRepository.findById(userId).get();
            User getBlocked = userRepository.findById(blockedId).get();
            Block newBlock = new Block();
            newBlock.setUser(getUser);
            newBlock.setBlocked(getBlocked);
            newBlock = blockRepository.save(newBlock);

            BlockedOutput newBlockedOutput = new BlockedOutput();
            newBlockedOutput.setUser(newBlock.getUser().getPerson().getFirstName()+" "+newBlock.getUser().getPerson().getLastName());
            newBlockedOutput.setBlocked(newBlock.getBlocked().getPerson().getFirstName()+" "+newBlock.getBlocked().getPerson().getLastName());
            newBlockedOutput.setSince(newBlock.getCreatedAt());

            return new BlockedResponse(newBlockedOutput);
        }
        catch (Exception e)
        {
            return new BlockedResponse("An error ocurred while saving the blockeds relation : "+e.getMessage());
        }
    }

    @Override
    public UserResponse findAllUsers() {
        try
        {
            List<User> users = userRepository.findAll();
            List<UserOutput> userOutputList = new ArrayList<>();
            for (User u:users) {
                UserOutput newUserOutput = new UserOutput();
                newUserOutput.setEmail(u.getEmail());
                newUserOutput.setFirstName(u.getPerson().getFirstName());
                newUserOutput.setLastName(u.getPerson().getLastName());
                newUserOutput.setPassword(u.getPassword());
                if(u.getPerson().getPersonType()==1)
                    newUserOutput.setRole("Customer");
                else
                    newUserOutput.setRole("Driver");
                userOutputList.add(newUserOutput);
            }
            return new UserResponse(userOutputList);
        }
        catch (Exception e)
        {
            return new UserResponse("An error ocurred while getting the user list : "+e.getMessage());

        }

    }

    @Override
    public FavouriteResponse findFavouritesByUserId(int userId) {
        try
        {
            List<Favourite> favourites = favouriteRepository.findFavouritesByUserId(userId);
            List<FavouriteOutput> favouriteOutputList = new ArrayList<>();
            for (Favourite f:favourites) {
                FavouriteOutput newFavouriteOutput = new FavouriteOutput();
                newFavouriteOutput.setUser(f.getUser().getPerson().getFirstName()+" "+f.getUser().getPerson().getLastName());
                newFavouriteOutput.setFavourited(f.getFavourited().getPerson().getFirstName()+" "+f.getFavourited().getPerson().getLastName());
                newFavouriteOutput.setSince(f.getCreatedAt());
                favouriteOutputList.add(newFavouriteOutput);
            }
            return new FavouriteResponse(favouriteOutputList);
        }
        catch (Exception e)
        {
            return new FavouriteResponse("An error ocurred while getting the favourites list : "+e.getMessage());

        }

    }

    @Override
    public BlockedResponse findBlockedsByUserId(int userId) {
        try
        {
            List<Block> blocked = blockRepository.findBlockedsByUserId(userId);
            List<BlockedOutput> blockedOutputList = new ArrayList<>();
            for(Block b:blocked)
            {
                BlockedOutput newBlockedOutput = new BlockedOutput();
                newBlockedOutput.setUser(b.getUser().getPerson().getFirstName()+" "+b.getUser().getPerson().getLastName());
                newBlockedOutput.setBlocked(b.getBlocked().getPerson().getFirstName()+" "+b.getBlocked().getPerson().getLastName());
                newBlockedOutput.setSince(b.getCreatedAt());
                blockedOutputList.add(newBlockedOutput);
            }
            return new BlockedResponse(blockedOutputList);
        }
        catch (Exception e)
        {
            return new BlockedResponse("An error ocurred while getting the blockeds list : "+e.getMessage());

        }

    }

    @Override
    public FavouriteResponse findAllFavourites() {
        try
        {
            List<Favourite> favourites = favouriteRepository.findAll();
            List<FavouriteOutput> favouriteOutputList = new ArrayList<>();
            for (Favourite f:favourites) {
                FavouriteOutput newFavouriteOutput = new FavouriteOutput();
                newFavouriteOutput.setUser(f.getUser().getPerson().getFirstName()+" "+f.getUser().getPerson().getLastName());
                newFavouriteOutput.setFavourited(f.getFavourited().getPerson().getFirstName()+" "+f.getFavourited().getPerson().getLastName());
                newFavouriteOutput.setSince(f.getCreatedAt());
                favouriteOutputList.add(newFavouriteOutput);
            }
            return new FavouriteResponse(favouriteOutputList);
        }
        catch (Exception e)
        {
            return new FavouriteResponse("An error ocurred while getting the favourites list : "+e.getMessage());

        }

    }

    @Override
    public BlockedResponse findAllBlockeds() {
        try
        {
            List<Block> blocked = blockRepository.findAll();
            List<BlockedOutput> blockedOutputList = new ArrayList<>();
            for(Block b:blocked)
            {
                BlockedOutput newBlockedOutput = new BlockedOutput();
                newBlockedOutput.setUser(b.getUser().getPerson().getFirstName()+" "+b.getUser().getPerson().getLastName());
                newBlockedOutput.setBlocked(b.getBlocked().getPerson().getFirstName()+" "+b.getBlocked().getPerson().getLastName());
                newBlockedOutput.setSince(b.getCreatedAt());
                blockedOutputList.add(newBlockedOutput);
            }
            return new BlockedResponse(blockedOutputList);
        }
        catch (Exception e)
        {
            return new BlockedResponse("An error ocurred while getting the blockeds list : "+e.getMessage());

        }

    }

    @Override
    public UserResponse findByEmail(String email) {

        User getUser = userRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("user","email",email));

        UserResponse newUserResponse = new UserResponse(new UserOutput(getUser.getEmail(),getUser.getPassword(),getUser.getPerson().getFirstName(),getUser.getPerson().getLastName()));
        if(getUser.getPerson().getPersonType()==1)
            newUserResponse.getResource().setRole("Customer");
        else
            newUserResponse.getResource().setRole("Driver");

        return newUserResponse;
    }
}
