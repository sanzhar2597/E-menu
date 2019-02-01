package kz.greetgo.diploma.controller.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("unused")
public class Modules {
  public static File parentDir() {
    if (new File("diploma.client").isDirectory()) {
      return new File(".");
    }

    if (new File("../diploma.client").isDirectory()) {
      return new File("..");
    }

    throw new RuntimeException("Cannot find diploma.root dir");
  }

  private static Path findGreetgoProjectNamePath() {
    Path markerPath = Paths.get(".greetgo", "project-name.txt");
    {
      Path point = Paths.get(".");
      if (Files.exists(point.resolve(markerPath))) {
        return point;
      }
    }

    {
      Path points = Paths.get("..");
      if (Files.exists(points.resolve(markerPath))) {
        return points;
      }

      for (int i = 0; i < 7; i++) {
        points = points.resolve("..");

        if (Files.exists(points.resolve(markerPath))) {
          return points;
        }
      }
    }

    throw new RuntimeException("Cannot find greetgo/project-name.txt" +
      " from " + new File(".").getAbsoluteFile().toPath().normalize());
  }

  private static File getDir(String moduleName) {

    Path modulePath = findGreetgoProjectNamePath().resolve(moduleName);

    if (Files.isDirectory(modulePath)) {
      return modulePath.toFile();
    }

    throw new IllegalArgumentException("Cannot find directory " + moduleName
      + " from " + new File(".").getAbsoluteFile().toPath().normalize());
  }

  public static File clientDir() {
    return getDir("diploma.client");
  }

  public static File registerDir() {
    return getDir("diploma.register");
  }

  public static File debugDir() {
    return getDir("diploma.server/debug");
  }

  public static File controllerDir() {
    return getDir("diploma.controller");
  }
}
