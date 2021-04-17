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
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

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
            String s = text.replaceAll("FROM.*", "").replace("SELECT", "");
            String t = text.replace("SELECT", "").replace("FROM", "").replace(s, "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE\n"
                        + "\t" + t);
            } else {
                outputArea.setText(validateSelect(s.trim()));
            }
        } else if (text.trim().matches(B)) {
            String s = text.replaceAll("FROM.*", "").replace("SELECT", "");
            String t = text.replace("SELECT", "").replace("FROM", "").replace(s, "").replaceAll("ORDER.*", "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE\n"
                        + "\t" + t + "\n"
                        + "ORDENAR " + spanish(text.replace(t, "").replace(s, "").replace("SELECT", "").replace("FROM", "").replace("ORDER", "").replace("BY", "").replace(" ", "")));
            } else {
                outputArea.setText(validateSelect(s.trim()));
            }
        }
    }

    public String spanish(String t) {
        switch (t) {
            case ASC:
                return "ASCENDENTEMENTE";
            case DESC:
                return "DESCENDENTEMENTE";
            default:
                return t;
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
    private final String B = "^(SELECT +(.)+ +FROM +\\w+) *ORDER *BY *(ASC|DESC) *$";

}
