package io.pan.cookbook.plugin.plugin;

import org.springframework.plugin.core.Plugin;

public interface StringPlugin extends Plugin<String> {

  String result();

}
