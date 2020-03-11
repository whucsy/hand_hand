package whu.yes.hand_hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class HandHandApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandHandApplication.class, args);
    }

}
