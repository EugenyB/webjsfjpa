package ua.mk.berkut.webjsfjpa.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ua.mk.berkut.webjsfjpa.data.Faculty;
import ua.mk.berkut.webjsfjpa.data.Student;

import java.util.List;

@Stateless
public class StudentDao {
    @PersistenceContext
    private EntityManager em;

    public List<Student> findAll() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public void save(Student student) {
        student.setFaculty(em.find(Faculty.class, 1));
        em.persist(student);
    }

    public void delete(int id) {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }
}
