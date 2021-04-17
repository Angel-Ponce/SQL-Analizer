package Main;

import javax.swing.JTextArea;

/**
 *
 * @author angel_p11
 */
public class Analizer {

    public static final String SELECT = "SELECT";
    public static final String FROM = "FROM";
    public static final String ORDERBY = "ORDER BY";
    public static final String WHERE = "WHERE";

    private String text;
    private JTextArea inputArea;
    private JTextArea outputArea;

    public Analizer(String text, JTextArea inputArea, JTextArea outputArea) {
        this.text = text;
        this.inputArea = inputArea;
        this.outputArea = outputArea;
    }

    public void execute() {
        if (text.trim().matches(A)) {
            String t = text.replaceAll("FROM.*", "").replace("SELECT", "");
            if (validateSelect(t.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + t.trim() + "\n"
                        + "DE\n"
                        + "\t" + text.replace("SELECT", "").replace("FROM", "").replace(t, ""));
            }
        } else if (true) {

        }
    }

    public String validateSelect(String e) {
        if (e.matches("\\w+")) {
            return "";
        } else if (e.matches("\\*")) {
            return "";
        } else if (e.matches(".+,.+")) {
            String init = String.valueOf(e.charAt(0));
            String end = String.valueOf(e.charAt(e.length() - 1));
            if (init.matches("\\w") && end.matches("\\w")) {
                return "";
            } else {
                return "SYNTAX ERROR NEAR " + e;
            }
        } else {
            return "SYNTAX ERROR";
        }
    }

    public void setText(String text) {
        this.text = text;
    }

    private final String A = "^(SELECT +(.)+ +FROM +\\w+) *$";
    private final String B = "";

}
