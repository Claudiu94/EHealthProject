package com.healthchart.springmvc.dao;

import com.healthchart.springmvc.model.Patient;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("patientDao")
public class PatientDaoImpl extends AbstractDao<Integer, Patient> implements PatientDao {
    @Override
    public Patient findById(int id) {
        return getByKey(id);
    }

    @Override
    public void savePatient(Patient patient) {
        persist(patient);
    }

    @Override
    public void deletePatientById(int id) {
        Query query = getSession().createSQLQuery("delete from Patient where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();

    }

    @Override
    public List<Patient> findAllPatients() {
        Criteria criteria = createEntityCriteria();
        return (List<Patient>) criteria.list();
    }

    @Override
    public Patient findPatientByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("firstName", name));
        return (Patient) criteria.uniqueResult();
    }
}