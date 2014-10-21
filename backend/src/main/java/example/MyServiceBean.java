/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import static java.util.Calendar.HOUR_OF_DAY;

/**
 *
 */
@Stateless
@LocalBean
public class MyServiceBean {

    public List<Measurement> getLatest() {
        // just return a random set of temperature readings
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
        Calendar cal = Calendar.getInstance();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            measurements.add(0, new Measurement(r.nextDouble()*100, cal.getTime()));
            cal.add(HOUR_OF_DAY, -1);
        }
        return measurements;
    }

}
