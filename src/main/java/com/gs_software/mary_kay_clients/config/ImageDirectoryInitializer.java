package com.gs_software.mary_kay_clients.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ImageDirectoryInitializer {

    @Value("${project.image}")
    private String imageFolderPath;

    @EventListener(ApplicationReadyEvent.class)
    public void createImageDirectory() {
        File imageDirectory = new File(imageFolderPath);
        if (!imageDirectory.exists()) {
            boolean directoryCreated = imageDirectory.mkdirs();
            if (directoryCreated) {
                System.out.println("Diretório de imagens criado: " + imageDirectory.getAbsolutePath());
            } else {
                System.err.println("Falha ao criar o diretório de imagens.");
            }
        }
    }
}