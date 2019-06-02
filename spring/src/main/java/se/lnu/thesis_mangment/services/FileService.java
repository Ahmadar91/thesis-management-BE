package se.lnu.thesis_mangment.services;

import javassist.NotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private String location = "./spring/src/main/resources/uploads/";

    public void save(MultipartFile file, String fileName) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get( location + fileName);
        Files.write(path, bytes);
    }

    public void saveFeedback(MultipartFile file, String fileName) throws IOException
    {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(location + "feedbacks/" + fileName);
        Files.write(path, bytes);
    }


    public Resource get(String fileName) throws MalformedURLException, NotFoundException {
        Path path = Paths.get(this.location + fileName);
        path.resolve(fileName).normalize();
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists()) {
            return resource;
        } else {
            throw new NotFoundException(
                    "The file doesn't exist! File name should be in the following form: 'document \"Id\".pdf");
        }
    }

    public Resource getFeedback(String fileName) throws MalformedURLException, NotFoundException
    {
        Path path = Paths.get(this.location + "feedbacks/" + fileName);
        path.resolve(fileName).normalize();
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists())
        {
            return resource;
        } else
        {
            throw new NotFoundException("The file doesn't exist! File name should be in the following form: 'document \"Id\".pdf");
        }
    }
}
