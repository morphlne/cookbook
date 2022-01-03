package io.pan.cookbook.plugin.config;

import io.pan.cookbook.plugin.plugin.StringPlugin;
import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@Configuration
@EnablePluginRegistries(StringPlugin.class)
public class PluginConfig {}
