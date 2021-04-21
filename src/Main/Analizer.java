package Main;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angel_p11
 */
public class Analizer {

    public static final String SELECCIONAR = "SELECCIONAR";
    public static final String DE = "DE\\s+LA\\s+TABLA";
    public static final String ORDENARPOR = "ORDENAR\\s+POR";
    public static final String DONDE = "DONDE";
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    public final ImageIcon success = new ImageIcon(getClass().getResource("/Images/success.png"));
    public final ImageIcon error = new ImageIcon(getClass().getResource("/Images/error.png"));

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
            String s = text.replaceAll("DE\\s+LA\\s+TABLA.*", "").replace("SELECCIONAR", "");
            String t = text.replace("SELECCIONAR", "").replaceAll("DE\\s+LA\\s+TABLA", "").replace(s, "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE LA TABLA\n"
                        + "\t" + t);
                JOptionPane.showMessageDialog(null, "Build Successful", "Information", 0, success);
                database(t, text.trim());
            } else {
                JOptionPane.showMessageDialog(null, "Error Syntax", "Information", 0, error);
                outputArea.setText(validateSelect(s.trim()));
            }
        } else if (text.trim().matches(B)) {
            String s = text.replaceAll("DE\\s+LA\\s+TABLA.*", "").replace("SELECCIONAR", "");
            String t = text.replace("SELECCIONAR", "").replaceAll("DE\\s+LA\\s+TABLA", "").replace(s, "").replaceAll("ORDENAR.*", "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE LA TABLA\n"
                        + "\t" + t + "\n"
                        + "ORDENAR " + spanish(text.replace(t, "").replace(s, "").replace("SELECCIONAR", "").replaceAll("DE\\s+LA\\s+TABLA", "").replace("ORDENAR", "").replace("POR", "").replace(" ", "")));
                JOptionPane.showMessageDialog(null, "Build Successful", "Information", 0, success);
                database(t, text.trim());
            } else {
                JOptionPane.showMessageDialog(null, "Error Syntax", "Information", 0, error);
                outputArea.setText(validateSelect(s.trim()));
            }
        } else if (text.trim().matches(C)) {
            String s = text.replaceAll("DE\\s+LA\\s+TABLA.*", "").replace("SELECCIONAR", "");
            String t = text.replace("SELECCIONAR", "").replaceAll("DE\\s+LA\\s+TABLA", "").replace(s, "").replaceAll("DONDE.*", "");
            String w = text.replace(t, "").replace(s, "").replace("SELECCIONAR", "").replaceAll("DE\\s+LA\\s+TABLA", "").replace("DONDE", "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE LA TABLA\n"
                        + "\t" + t + "\n"
                        + "DONDE\n"
                        + "\t" + w.trim());
                JOptionPane.showMessageDialog(null, "Build Successful", "Information", 0, success);
                database(t, text.trim());
            } else {
                JOptionPane.showMessageDialog(null, "Error Syntax", "Information", 0, error);
                outputArea.setText(validateSelect(s.trim()));
            }
        } else if (text.trim().matches(D)) {
            String s = text.replaceAll("DE\\s+LA\\s+TABLA.*", "").replace("SELECCIONAR", "");
            String t = text.replace("SELECCIONAR", "").replaceAll("DE\\s+LA\\s+TABLA", "").replace(s, "").replaceAll("DONDE.*", "");
            String w = text.replace(t, "").replace(s, "").replace("SELECCIONAR", "").replaceAll("DE\\s+LA\\s+TABLA", "").replace("DONDE", "").replaceAll("ORDENAR.*", "");
            if (validateSelect(s.trim()).isEmpty()) {
                outputArea.setText("SELECCIONAR\n"
                        + "\t" + s.trim().replace(" ", "") + "\n"
                        + "DE LA TABLA\n"
                        + "\t" + t + "\n"
                        + "DONDE\n"
                        + "\t" + w.trim() + "\n"
                        + "ORDENAR " + spanish(text.replace("SELECCIONAR", "").replace(s, "").replaceAll("DE\\s+LA\\s+TABLA", "").replace(t, "").replace("DONDE", "").replace(w, "").replace("ORDENAR", "").replace("POR", "").replace(" ", "")));
                JOptionPane.showMessageDialog(null, "Build Successful", "Information", 0, success);
                database(t, text.trim());
            } else {
                JOptionPane.showMessageDialog(null, "Error Syntax", "Information", 0, error);
                outputArea.setText(validateSelect(s.trim()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error Syntax", "Information", 0, error);
            outputArea.setText("NO MATCHER");
        }
    }

    public void database(String table, String query) {
        if (table.trim().equals("usuario")) {
            Connecter c = new Connecter();
            query = query.replace("SELECCIONAR", "SELECT")
                    .replace("ORDENAR", "ORDER")
                    .replace("POR", "BY")
                    .replace("DONDE", "WHERE")
                    .replaceAll(DE, "FROM");
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

            }
        }
    }

    public String spanish(String t) {

        if (t.contains("ASC")) {
            return t.replace("ASC", "").trim() + " ASCENDENTEMENTE";
        } else if (t.contains("DESC")) {
            return t.replace("DESC", "").trim() + " DESCENDENTEMENTE";
        } else {
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

    private final String A = "^(SELECCIONAR\\s+(.)+\\s+DE\\s+LA\\s+TABLA\\s+\\w+)\\s*$";
    private final String B = "^(SELECCIONAR\\s+(.)+\\s+DE\\s+LA\\s+TABLA\\s+\\w+)\\s+ORDENAR\\s+POR\\s+\\w+\\s+(ASC|DESC)\\s*$";
    private final String C = "^(SELECCIONAR\\s+(.)+\\s+DE\\s+LA\\s+TABLA\\s+\\w+)\\s+DONDE\\s+(\\w+\\s*=\\s*(\\d+|\".+\"))\\s*$";
    private final String D = "^(SELECCIONAR\\s+(.)+\\s+DE\\s+LA\\s+TABLA\\s+\\w+)\\s+DONDE\\s+(\\w+\\s*=\\s*(\\d+|\".+\"))\\s+ORDENAR\\s+POR\\s+\\w+\\s+(ASC|DESC)\\s*$";

}
