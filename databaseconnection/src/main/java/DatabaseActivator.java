import com.thelaunchclub.databaseconnection.StudentDbConnection;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

/**
 * Activates the connection for database.
 */
@Component(immediate = true, configurationPid = "database")
public class DatabaseActivator {

    /**
     * To activate the database using Map functions.
     *
     * @param properties
     */
    @Activate
    public void activate(Map<String, String> properties) {
        StudentDbConnection.databaseProperty(properties);
    }
}
