/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.DriverDao;
import dao.TrackerDao;
import dao.UserDao;
import domain.Driver;
import domain.Tracker;
import domain.User;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Startup
@Singleton
public class Init {
    
    @Inject
    TrackerDao trackerDao;
    
    @Inject
    DriverDao driverDAO;
    
    @Inject
    UserDao userDAO;
    
    @PostConstruct
    public void Init(){
        userDAO.createUser(new User("Administrator", "password"));
        Driver driver = driverDAO.createNewDriver(new Driver("Lino", "NL12345", "Thaencharun", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "lino1", "p@33word", "10c", "0614387088"));
        Tracker tracker = trackerDao.createNewTracker(new Tracker("1", 12, 13));
        Tracker tracker1 = trackerDao.createNewTracker(new Tracker("2", 15, 15));
        Tracker tracker2 = trackerDao.createNewTracker(new Tracker("3", 20, 20));
    }
    
}
