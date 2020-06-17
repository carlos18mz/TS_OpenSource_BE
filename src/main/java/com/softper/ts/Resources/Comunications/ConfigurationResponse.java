package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.ConfigurationOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ConfigurationResponse extends BaseResponse<ConfigurationOutput> {
    public ConfigurationResponse(String message) {super(message);}
    public ConfigurationResponse(ConfigurationOutput configurationOutput) {super(configurationOutput);}
    public ConfigurationResponse(List<ConfigurationOutput> configurationOutputList) {super(configurationOutputList);}
}
