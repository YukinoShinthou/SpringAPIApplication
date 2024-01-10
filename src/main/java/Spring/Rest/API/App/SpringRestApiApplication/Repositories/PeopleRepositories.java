package Spring.Rest.API.App.SpringRestApiApplication.Repositories;

import Spring.Rest.API.App.SpringRestApiApplication.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepositories extends JpaRepository<Person, Integer> {
}
