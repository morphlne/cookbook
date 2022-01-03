package io.pan.cookbook.plugin.config;

import io.pan.cookbook.plugin.plugin.FirstLetterPlugin;
import io.pan.cookbook.plugin.plugin.LastLetterPlugin;
import io.pan.cookbook.plugin.plugin.LengthPlugin;
import io.pan.cookbook.plugin.plugin.StringPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.PluginRegistry;

//PluginConfig & @Order alternative
//@Configuration
public class OrderedPluginConfig {

  @Bean
  public PluginRegistry<StringPlugin, String> pluginRegistry() {
    return PluginRegistry.of(
        new LengthPlugin(),
        new LastLetterPlugin(),
        new FirstLetterPlugin()
    );
  }

}
