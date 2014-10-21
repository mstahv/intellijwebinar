package example;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@Widgetset("example.AppWidgetSet")
@CDIUI("")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{
    
    @EJB
    MyServiceBean myServiceBean;
    
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);

        Chart chart = new Chart(ChartType.AREA);

        chart.getConfiguration().getxAxis().setType(AxisType.DATETIME);

        DataSeries series = new DataSeries();
        for (Measurement measurement : myServiceBean.getLatest()) {
            series.add(new DataSeriesItem(measurement.getTime(), measurement.getTemperature()));
        }

        chart.getConfiguration().addSeries(series);

        layout.addComponent(chart);

        Button button = new Button("Click Me");
        button.setStyleName("primary");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);
    }

}
