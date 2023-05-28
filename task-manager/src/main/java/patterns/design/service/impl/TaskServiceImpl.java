package patterns.design.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patterns.design.model.Task;
import patterns.design.model.TaskRepository;
import patterns.design.service.TaskService;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author leandrochs (Com base em falvojr)
 */

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Iterable<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new NoSuchElementException("Task não encontrada"));
    }

    @Override
    public Task insert(Task taskName) {
        taskRepository.save(taskName);
        return taskName;
    }

    @Override
    public Task update(Long id, Task updatedTaskName) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.save(updatedTaskName);
            return updatedTaskName;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
