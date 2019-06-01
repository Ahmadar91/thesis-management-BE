package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Submission;
import se.lnu.thesis_mangment.model.SubmissionDTO;
import se.lnu.thesis_mangment.repositories.SubmissionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubmissionServices
{
    @Autowired
    private SubmissionRepository repository;

    public List<Submission> get(SubmissionDTO input)
    {
        return repository.get(input);
    }


    @Transactional
    public void add(Submission submission)
    {
        repository.add(submission);
    }

    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, Submission.class);
        return list;
    }

    public void update(Submission item)
    {
        repository.update(item);
    }
}