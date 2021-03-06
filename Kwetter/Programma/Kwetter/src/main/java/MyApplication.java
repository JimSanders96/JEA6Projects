import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/")
//The java class declares root resource and provider classes
public class MyApplication extends Application{
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(HelloEmployee.class);
        // Add Jackson feature.
        resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);

        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        // JAX-RS resource classes added here - maintained by NetBeans.
    }
}