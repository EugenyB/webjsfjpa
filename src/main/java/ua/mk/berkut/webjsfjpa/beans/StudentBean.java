package ua.mk.berkut.webjsfjpa.beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import ua.mk.berkut.webjsfjpa.dao.StudentDao;
import ua.mk.berkut.webjsfjpa.data.Student;

import java.util.List;

@Named
@RequestScoped
public class StudentBean {
    @Getter
    private Student student = new Student();

    @EJB
    private StudentDao studentDao;

    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    public void addStudent() {
        studentDao.save(student);
        student = new Student();
    }

    public void delete(int id) {
        studentDao.delete(id);
    }
}
