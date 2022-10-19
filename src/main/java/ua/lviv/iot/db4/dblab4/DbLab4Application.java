package ua.lviv.iot.db4.dblab4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lviv.iot.db4.dblab4.view.MyView;

@SpringBootApplication
public class DbLab4Application implements CommandLineRunner {

    private final MyView view;

    public DbLab4Application(MyView view) {
        this.view = view;
    }
    public static void main(String[] args) {
        SpringApplication.run(DbLab4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        view.show();
    }

}
