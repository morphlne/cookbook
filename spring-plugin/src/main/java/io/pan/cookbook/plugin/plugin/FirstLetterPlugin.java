package io.pan.cookbook.plugin.plugin;

import org.springframework.stereotype.Component;

@Component
public class FirstLetterPlugin implements StringPlugin {

  private final String firstLetter = "A";

  @Override
  public boolean supports(String delimiter) {
    return delimiter.startsWith(firstLetter);
  }

  @Override
  public String result() {
    return "First letter is ".concat(firstLetter);
  }

}
