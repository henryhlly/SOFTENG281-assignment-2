package nz.ac.auckland.se281;

// 
public class EasyHal implements Hal9000 {

  @Override
  public int play() {
    return Utils.getRandomNumberRange(0, 5);
  }
}