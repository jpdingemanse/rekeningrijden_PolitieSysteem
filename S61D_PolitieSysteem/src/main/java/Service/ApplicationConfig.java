/*
 * TetrisBattle Copyright (C) 2015 - 2015 S31D, All rights reserved.
 * S31D is the rightful owner of this file, use without permission
 * from the owner is considered an offense and will be acted on accordingly.
 */
package Service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author chielsprangers
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(boundary.rest.service.DriverResource.class);
        resources.add(boundary.rest.service.VehicleResource.class);
    }
    
}
