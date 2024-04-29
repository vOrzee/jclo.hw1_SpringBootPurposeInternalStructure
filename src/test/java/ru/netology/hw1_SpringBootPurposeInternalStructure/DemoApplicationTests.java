package ru.netology.hw1_SpringBootPurposeInternalStructure;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> dev = new GenericContainer<>("devapp").withExposedPorts(8080);
    private static final GenericContainer<?> prod = new GenericContainer<>("prodapp").withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        dev.start();
        prod.start();
    }

    @Test
    void loadBodyDev() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + dev.getMappedPort(8080) + "/profile", String.class);
        String body = forEntity.getBody();
        assertEquals("Current profile is dev", body);
    }

    @Test
    void loadBodyProd() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prod.getMappedPort(8081) + "/profile", String.class);
        String body = forEntity.getBody();
        assertEquals("Current profile is production", body);
    }
}
