package io.pan.cookbook.plugin.plugin;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class LengthPlugin implements StringPlugin {

  private final Integer length = 3;

  @Override
  public boolean supports(String delimiter) {
    return delimiter.length() == length;
  }

  @Override
  public String result() {
    return "Length is ".concat(length.toString());
  }

}
