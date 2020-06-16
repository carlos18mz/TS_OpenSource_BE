package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.ConfigurationOutput;
import java.util.List;

public class ConfigurationResponse extends BaseResponse<ConfigurationOutput> {
    public ConfigurationResponse(String message) {super(message);}
    public ConfigurationResponse(ConfigurationOutput configurationOutput) {super(configurationOutput);}
    public ConfigurationResponse(List<ConfigurationOutput> configurationOutputList) {super(configurationOutputList);}
}
