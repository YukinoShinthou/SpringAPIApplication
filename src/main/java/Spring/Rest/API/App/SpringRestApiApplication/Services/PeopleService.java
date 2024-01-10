package Spring.Rest.API.App.SpringRestApiApplication.Services;

import Spring.Rest.API.App.SpringRestApiApplication.Models.Person;
import Spring.Rest.API.App.SpringRestApiApplication.Repositories.PeopleRepositories;
import Spring.Rest.API.App.SpringRestApiApplication.util.PersonErrorResponse;
import Spring.Rest.API.App.SpringRestApiApplication.util.PersonNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeopleService {
    private final PeopleRepositories peopleRepositories;

    @Autowired
    public PeopleService(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    @Transactional
    public Person findOne(int id){
        Optional<Person> personOptionaln = peopleRepositories.findById(id);
        return personOptionaln.orElseThrow(PersonNotFoundException::new);
    }

    @Transactional
    public List<Person> findAllPeople(){
        return peopleRepositories.findAll();
    }
}
