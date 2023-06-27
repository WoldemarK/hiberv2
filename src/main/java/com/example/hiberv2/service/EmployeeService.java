package com.example.hiberv2.service;

import com.example.hiberv2.model.Details;
import com.example.hiberv2.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final SessionFactory sessionFactory;
    private final DetailsService serviceD;

    @Transactional
    public void addingEmployee(Employee employee) {
        log.info("The method {addingEmployee}" + employee);
        sessionFactory.getCurrentSession().save(employee);
    }

    @Transactional
    public void addingEmployeeAndDetails(Employee employee, Details details) {
        Employee emp = new Employee(employee.getName(), employee.getSurname(), employee.getDepartment(), employee.getSalary());
        Details det = new Details(details.getCity(), details.getPhoneNumber());
        emp.setDetails_id(det);
        det.setEmployee(emp);
        log.info("The method {addingEmployeeAndDetails}" + employee + " " + details);
        sessionFactory.getCurrentSession().save(employee);
        ;
    }

    @Transactional
    public void updateEmployeeByIdDetails(Integer idE, Integer idD) {
        Employee employee = findById(idE);
        Details details = serviceD.findById(idD);
        employee.setDetails_id(details);
        log.info("The method {updateEmployeeByIdDetails}" + " employee " + idE + " " + " details " + idE);

    }

    public Employee findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        log.info("The method {findById}" + " ID " + id);
        return session.get(Employee.class, id);

    }

    @Transactional
    public void deleteId(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = findById(id);
        session.delete(employee);
    }
}
