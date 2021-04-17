package Main;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

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
    private JTable outputTable;

    public Analizer(String text, JTextArea inputArea, JTextArea outputArea, JTable outputTable) {
        this.text = text;
        this.inputArea = inputArea;
        this.outputArea = outputArea;
        this.outputTable = outputTable;
    }

    public void execute() {
        text = text.replaceAll("\n", " ");
        if (text.trim().matches(A)) {
            String s = text.replaceAll("FROM.*", "").replace("SELECT", "");
            String t = text.replace("SELECT", "").replace("FROM", "").replace(s, "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE\n"
                        + "\t" + t);
                database(t, text.trim());
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
                database(t, text.trim());
            } else {
                outputArea.setText(validateSelect(s.trim()));
            }
        } else if (text.trim().matches(C)) {
            String s = text.replaceAll("FROM.*", "").replace("SELECT", "");
            String t = text.replace("SELECT", "").replace("FROM", "").replace(s, "").replaceAll("WHERE.*", "");
            String w = text.replace(t, "").replace(s, "").replace("SELECT", "").replace("FROM", "").replace("WHERE", "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE\n"
                        + "\t" + t + "\n"
                        + "DONDE\n"
                        + "\t" + w.trim());
                database(t, text.trim());
            } else {
                outputArea.setText(validateSelect(s.trim()));
            }
        } else if (text.trim().matches(D)) {
            String s = text.replaceAll("FROM.*", "").replace("SELECT", "");
            String t = text.replace("SELECT", "").replace("FROM", "").replace(s, "").replaceAll("WHERE.*", "");
            String w = text.replace(t, "").replace(s, "").replace("SELECT", "").replace("FROM", "").replace("WHERE", "").replaceAll("ORDER.*", "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE\n"
                        + "\t" + t + "\n"
                        + "DONDE\n"
                        + "\t" + w.trim() + "\n"
                        + "ORDENAR " + spanish(text.replace("SELECT", "").replace(s, "").replace("FROM", "").replace(t, "").replace("WHERE", "").replace(w, "").replace("ORDER", "").replace("BY", "").replace(" ", "")));
                database(t, text.trim());
            } else {
                outputArea.setText(validateSelect(s.trim()));
            }
        } else {
            outputArea.setText("SYNTAX ERROR");
        }
    }

    public void database(String table, String query) {
        if (table.trim().equals("usuario")) {
            Connecter c = new Connecter();
            try {
                c.conexion = c.getConexion();
                c.ps = (PreparedStatement) c.conexion.prepareStatement(query);
                c.rs = c.ps.executeQuery();
                while (c.rs.next()) {
                    DefaultTableModel model = (DefaultTableModel) outputTable.getModel();
                    Object[] row = new Object[4];
                    try {
                        row[0] = c.rs.getInt("id");
                    } catch (SQLException e) {
                        row[0] = "";
                    }
                    try {
                        row[1] = c.rs.getString("nombre");
                    } catch (SQLException e) {
                        row[1] = "";
                    }
                    try {
                        row[2] = c.rs.getInt("edad");
                    } catch (SQLException e) {
                        row[2] = "";
                    }
                    try {
                        row[3] = c.rs.getBoolean("estado");
                    } catch (SQLException e) {
                        row[3] = "";
                    }
                    model.addRow(row);
                }
            } catch (SQLException e) {
                System.err.println(e);
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
    private final String C = "^(SELECT +(.)+ +FROM +\\w+) *WHERE *(\\w+ *= *(\\d+|\".+\")) *$";
    private final String D = "^(SELECT +(.)+ +FROM +\\w+) *WHERE *(\\w+ *= *(\\d+|\".+\")) *ORDER *BY *(ASC|DESC) *$";

}
