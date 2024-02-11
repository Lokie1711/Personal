package com.inter.backend.service;

import com.inter.backend.entity.EntityClass;
import com.inter.backend.repo.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebsiteChecker {

    private final Repository repository;

    @Scheduled(fixedDelay = 3000)
    public boolean checkWebsiteStatus() {
        List<EntityClass> allEntities = repository.findAll();
        for (EntityClass entity : allEntities) {
            checkAndLogWebsiteStatus(entity);
        }
        return true;
    }

    private boolean checkAndLogWebsiteStatus(EntityClass entity) {
        try {
            URL url = new URL(entity.getWebsites());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                log.info("Website " + entity.getWebsites() + " is down!");
                return false;

            } else {
                log.debug("Website " + entity.getWebsites() + " is up!");
                return true;
            }

        } catch (IOException e) {
            log.error("Website " + entity.getWebsites() + " is down! (Exception: " + e.getMessage() + ")");
            return false;
        }
    }
}