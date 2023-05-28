package patterns.design.service;

import patterns.design.model.Task;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 */

public interface TaskService {
    Iterable<Task> getAll();
    Task getById(Long id);
    Task insert(Task taskName);
    Task update(Long id, Task taskName);
    void delete(Long id);
}
