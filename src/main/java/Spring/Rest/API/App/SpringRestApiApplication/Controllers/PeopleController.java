package Spring.Rest.API.App.SpringRestApiApplication.Controllers;

import Spring.Rest.API.App.SpringRestApiApplication.Models.Person;
import Spring.Rest.API.App.SpringRestApiApplication.Services.PeopleService;
import Spring.Rest.API.App.SpringRestApiApplication.util.PersonErrorResponse;
import Spring.Rest.API.App.SpringRestApiApplication.util.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> findAllPeople(){
        return peopleService.findAllPeople();
    }

    @GetMapping("/{id}")
    public Person findOnePerson(@PathVariable(name = "id") int id){
        return peopleService.findOne(id);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handlerException(PersonNotFoundException e){
        PersonErrorResponse errorResponse = new PersonErrorResponse(
                "The user with this id is not found!",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
