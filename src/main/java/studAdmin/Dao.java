package studAdmin;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    void add (T t);

    void save(T t);

    void delete(int id);
}
