package CrudPi.workDoorCrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class WorkDoorCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkDoorCrudApplication.class, args);
	}

	public static final Logger log = LoggerFactory.getLogger(WorkDoorCrudApplication.class);

	@EventListener(ApplicationListener.class)
	public void swagger() {
		log.info("Swagger UI: http://localhost:8080/swagger-ui.html");
	}
}
