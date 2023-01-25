package pl.put.poznan.jsontools.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Application main class */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.jsontools.rest"})
public class JsonToolsApplication {

  /**
   * Application entry point
   *
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(JsonToolsApplication.class, args);
  }
}
