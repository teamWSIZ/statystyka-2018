package generator;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ChartControler {

    @FXML
    private ScatterChart randomChart;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            generateData();
        }
    };
    private Thread generatorThread = new Thread(runnable);

    private ReentrantLock lock = new ReentrantLock();
    private Condition generatorCondition = lock.newCondition();

    private boolean generate = false;


    XYChart.Series series;

    @FXML
    public void initialize() {
        series = new XYChart.Series();

        randomChart.setAnimated(false);
        randomChart.setLegendVisible(false);

        randomChart.getData().addAll(series);

        generatorThread.setDaemon(true);
        generatorThread.start();
    }

    public void startGenerator() {
        lock.lock();
        generate = true;
        generatorCondition.signal();
        lock.unlock();
    }

    public void stopGenerator() {
        lock.lock();
        generate = false;
        lock.unlock();
    }

    public void generateData() {
        XYChart.Series series = new XYChart.Series();

        series.setName("Generated data");

        Data data = new Data(100, 0, 1);

        do {
            lock.lock();
            try {
                if (!generate)
                    generatorCondition.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            for (int i = 0; i < 10; i++) {

                data.fill(Generator.gen2(), 1);

            }

            data.normalize();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {

                    series.getData().clear();

                    for (int i = 0; i < data.getNoBins(); i++) {

                        XYChart.Data point = new XYChart.Data(data.getBinX(i), data.getDataNorm()[i]);
                        point.setNode(new Circle(2, Color.ORANGE));

                        series.getData().add(point);
                    }

                    randomChart.getData().clear();
                    randomChart.getData().add(series);
                }
            });

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (true);

    }


}
