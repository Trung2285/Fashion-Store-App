package Com.company.fashiondesktop.SCHEMAOBJECT;
import java.util.List;
// T: Kiểu đối tượng (ví dụ: Student, Teacher, ...)
//ID: Kiểu của khóa chính (Integer, Long, ...)
public interface GenericDAO<T, ID> {
    void save(T entity);     
    void update(T entity); 
    void delete(ID id);     
    T findById(ID id);      
    List<T> findAll();     
}
