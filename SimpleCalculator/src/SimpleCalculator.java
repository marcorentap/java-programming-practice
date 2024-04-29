import java.util.Scanner;

class OutOfRangeException extends Exception {
}

class AddZeroException extends Exception {
}

class SubtractZeroException extends Exception {
}

public class SimpleCalculator {
  public static void main(String[] args) {
    try {

      Scanner s = new Scanner(System.in);
      String line;
      String[] ints = { "-1", "-1" };
      String op;
      int a, b;
      line = s.nextLine();
      if (line.contains("+")) {
        ints = line.split("\\+");
        op = "+";
      } else if (line.contains("-")) {
        ints = line.split("-");
        op = "-";
      } else {
        throw new Exception("Invalid operation");
      }
      a = Integer.valueOf(ints[0]);
      b = Integer.valueOf(ints[1]);

      if (op == "+" && (a == 0 || b == 0)) {
        throw new AddZeroException();
      }
      if (op == "-" && (a == 0 || b == 0)) {
        throw new SubtractZeroException();
      }
      if (a > 1000 || b > 1000 || a < 0 || b < 0) {
        throw new OutOfRangeException();
      }

      if (op == "+") {
        System.out.println(a + b);
      }

      if (op == "-") {
        System.out.println(a - b);
      }

    } catch (AddZeroException e) {
      System.out.println("AddZeroException");
    } catch (SubtractZeroException e) {
      System.out.println("SubtractZeroException");
    } catch (OutOfRangeException e) {
      System.out.println("OutOfRangeException");
    } catch (Exception e) {
      System.err.println("Error: " + e);
    }
  }
}
