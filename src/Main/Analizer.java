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
        if (text.matches(regex1)) {
            String[] elements = text.split(" ");
            outputArea.setText(validateSelect(elements[1], text));
        } else {
            outputArea.setText("SYNTAX ERROR");
        }
    }

    public String validateSelect(String e, String text) {
        if (e.matches("\\w+")) {
            return text;
        } else if (e.matches("\\*")) {
            return text;
        } else if (e.matches(".+,.+")) {
            String init = String.valueOf(e.charAt(0));
            String end = String.valueOf(e.charAt(e.length() - 1));
            if (init.matches("\\w") && end.matches("\\w")) {
                return text;
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

    public String toSpanish(String v) {
        switch (v) {
            case SELECT:
                return "SELECCIONAR";
            case FROM:
                return "DE";
            case ORDERBY:
                return "ORDENAR POR";
            case WHERE:
                return "DONDE";
            default:
                return v;
        }
    }

    private String regex1 = "^(SELECT +(.)+ +FROM +\\w+) *;$";

}
