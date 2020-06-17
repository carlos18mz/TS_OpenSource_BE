package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.UserOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserResponse extends BaseResponse<UserOutput>{
    public UserResponse(List<UserOutput> userOutputList) {super(userOutputList);}
    public UserResponse(UserOutput userOutput) {super(userOutput);}
    public UserResponse(String message) {super(message);}
}
