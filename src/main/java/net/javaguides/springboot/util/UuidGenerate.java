package net.javaguides.springboot.util;


import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class UuidGenerate {

  /**
   * 32桁のハイフンなしのUUIDを生成する
   *
   * */
  public static String generate() {
    UUID uuid = UUID.randomUUID();
    String uuidString = uuid.toString().replace("-", "");
    int uuidLength = uuidString.length();

    StringBuilder builder = new StringBuilder();
    Random random  = new Random();

    for (int i = uuidLength; i < 32; i++) {
      char randomChar = (char) ('a' + random.nextInt(26));
      builder.append(randomChar);
    }

    return uuidString + builder;
  }
}
