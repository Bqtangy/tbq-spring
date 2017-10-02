package code;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/9/27.
 */
public class ResourceBundleTest {

    public static void main(String[] args) {

        ResourceBundle  resourceBundle = ResourceBundle.getBundle("myconfig");
        if(resourceBundle != null){
            String driverName = resourceBundle.getString("database.driver");
            String url = resourceBundle.getString("database.url");
            Object[]  arrOne = new Object[]{"root"};
            Object[]  arrTwo = new Object[]{"test"};

            String user = MessageFormat.format(resourceBundle.getString("database.user"),arrOne);
            String pass   = MessageFormat.format(resourceBundle.getString("database.pass"),arrTwo);

            System.out.println(driverName+url+url+pass);

        }
    }

}
