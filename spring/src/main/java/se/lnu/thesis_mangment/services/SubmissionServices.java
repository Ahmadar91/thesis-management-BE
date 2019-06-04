package se.lnu.thesis_mangment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.thesis_mangment.model.Submission;
import se.lnu.thesis_mangment.model.SubmissionDTO;
import se.lnu.thesis_mangment.repositories.SubmissionRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Submission services.
 */
@Service
public class SubmissionServices
{
    @Autowired
    private SubmissionRepository repository;

    /**
     * Get list.
     *
     * @param input the input
     * @return the list
     */
    public List<Submission> get(SubmissionDTO input)
    {
        return repository.get(input);
    }


    /**
     * Add.
     *
     * @param submission the submission
     */
    @Transactional
    public void add(Submission submission)
    {
        repository.add(submission);
    }

    /**
     * Delete list.
     *
     * @param list the list
     * @return the list
     */
    public List<Long> delete(List<Long> list)
    {
        repository.delete(list, Submission.class);
        return list;
    }

    /**
     * Update.
     *
     * @param item the item
     */
    public void update(Submission item)
    {
        repository.update(item);
    }
}
