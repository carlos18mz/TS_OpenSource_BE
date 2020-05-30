package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.AuthenticatedOutput;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthResponse extends BaseResponse<AuthenticatedOutput> {
    public AuthResponse(List<AuthenticatedOutput> authenticatedOutputList){super(authenticatedOutputList);}
    public AuthResponse(AuthenticatedOutput authenticatedOutput){ super(authenticatedOutput);}
    public AuthResponse(String message){super(message);}
}
