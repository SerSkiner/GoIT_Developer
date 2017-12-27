package dao;

import com.sun.xml.bind.v2.model.core.ID;
import model.Developer;

import java.util.List;


public interface DeveloperDAO extends GenericDAO<Developer, Long> {
    List<Developer> getAll();



}
