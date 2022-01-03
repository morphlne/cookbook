package io.pan.cookbook.plugin.service;

import io.pan.cookbook.plugin.plugin.StringPlugin;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StringService {

  private final PluginRegistry<StringPlugin, String> stringPluginRegistry;

  public StringService(PluginRegistry<StringPlugin, String> stringPluginRegistry) {
    this.stringPluginRegistry = stringPluginRegistry;
  }

  @PostConstruct
  public void log() {
    final String string = "ABC";
    System.out.println("Processing ".concat(string));
    stringPluginRegistry.getPluginsFor(string)
        .stream()
        .map(StringPlugin::result)
        .forEach(System.out::println);
  }

}
