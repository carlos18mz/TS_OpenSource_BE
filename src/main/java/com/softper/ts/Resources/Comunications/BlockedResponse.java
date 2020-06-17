package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.BlockedOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class BlockedResponse extends BaseResponse<BlockedOutput>{
    public BlockedResponse(List<BlockedOutput> blockedOutputList) { super(blockedOutputList);}
    public BlockedResponse(BlockedOutput blockedOutput) {super(blockedOutput);}
    public BlockedResponse(String message) {super(message);}
}
