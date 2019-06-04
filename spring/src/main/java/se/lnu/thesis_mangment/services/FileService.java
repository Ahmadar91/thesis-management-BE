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

/**
 * The type File service.
 */
@Service
public class FileService {
    private String location = "./src/main/resources/uploads/";

    /**
     * Save.
     *
     * @param file     the file
     * @param fileName the file name
     * @throws IOException the io exception
     */
    public void save(MultipartFile file, String fileName) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get( location + fileName);
        Files.write(path, bytes);
    }

    /**
     * Save feedback.
     *
     * @param file     the file
     * @param fileName the file name
     * @throws IOException the io exception
     */
    public void saveFeedback(MultipartFile file, String fileName) throws IOException
    {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(location + "feedbacks/" + fileName);
        Files.write(path, bytes);
    }


    /**
     * Get resource.
     *
     * @param fileName the file name
     * @return the resource
     * @throws MalformedURLException the malformed url exception
     * @throws NotFoundException     the not found exception
     */
    public Resource get(String fileName) throws MalformedURLException, NotFoundException {
        Path path = Paths.get(this.location + fileName);
        path.resolve(fileName).normalize();
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists()) {
            return resource;
        } else {
            throw new NotFoundException("The file doesn't exist! File name should be in the following form: 'document \"Id\".pdf");
        }
    }

    /**
     * Gets feedback.
     *
     * @param fileName the file name
     * @return the feedback
     * @throws MalformedURLException the malformed url exception
     * @throws NotFoundException     the not found exception
     */
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
