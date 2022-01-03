package io.pan.cookbook.plugin.plugin;

import org.springframework.stereotype.Component;

@Component
public class LastLetterPlugin implements StringPlugin {

  private final String lastLetter = "C";

  @Override
  public boolean supports(String delimiter) {
    return delimiter.endsWith(lastLetter);
  }

  @Override
  public String result() {
    return "Last letter is ".concat(lastLetter);
  }

}
