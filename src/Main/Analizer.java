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
    
    public void execute(){
        
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

}
