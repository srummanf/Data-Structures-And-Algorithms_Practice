import java.util.*;

public class PrettyJSON {

  public static ArrayList<String> prettyJSON(String str) {
    ArrayList<String> result = new ArrayList<>();
    int braceCount = 0;
    StringBuilder currentLine = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '{' || ch == '[') {
        if (currentLine.length() > 0) {
          result.add(currentLine.toString());
          currentLine = new StringBuilder();
        }
        addIndentation(currentLine, braceCount);
        currentLine.append(ch);
        result.add(currentLine.toString());
        currentLine = new StringBuilder();
        braceCount++;
      } else if (ch == '}' || ch == ']') {
        if (currentLine.length() > 0) {
          result.add(currentLine.toString());
          currentLine = new StringBuilder();
        }
        braceCount--;
        addIndentation(currentLine, braceCount);
        currentLine.append(ch);
        if (i + 1 < str.length() && str.charAt(i + 1) == ',') {
          currentLine.append(',');
          i++;
        }
        result.add(currentLine.toString());
        currentLine = new StringBuilder();
      } else if (ch == ',') {
        currentLine.append(ch);
        result.add(currentLine.toString());
        currentLine = new StringBuilder();
      } else if (ch == ':') {
        currentLine.append(ch);
        if (
          i + 1 < str.length() &&
          (str.charAt(i + 1) == '{' || str.charAt(i + 1) == '[')
        ) {
          result.add(currentLine.toString());
          currentLine = new StringBuilder();
        }
      } else {
        if (currentLine.length() == 0) {
          addIndentation(currentLine, braceCount);
        }
        currentLine.append(ch);
      }
    }

    if (currentLine.length() > 0) {
      result.add(currentLine.toString());
    }

    return result;
  }

  private static void addIndentation(StringBuilder sb, int level) {
    for (int i = 0; i < level; i++) {
      sb.append("    "); // Add 4 spaces for each indentation level
    }
  }
}
