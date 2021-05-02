package com.xpr.dao.core.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.annotation.XprRole;
import com.xpr.dao.core.view.ModelViews;
import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.dao.helper.GenericSearchSpecification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Abstract CRUD Controller
 *
 * Help to handle all CRUD operations on objects, To extends this class two types must be specified
 * The type of Object that will be handled, and the type of it's ID
 *
 * @param <T> Model
 * @param <V> Identifier
 */
public abstract class AbstractCRUDController <T, V extends Serializable>{

    public  CustomJPARepository<T, V> repository;

    /**
     * An API to create a new entity, if the creation is ok
     * the newly created entity will be returned, else a 400 error
     * will be returned.
     *
     * @param T object
     * @return T
     */
    @CrossOrigin
    @JsonView(ModelViews.FullView.class)
    @PostMapping(path="/create")
    public T create(@Valid @RequestBody T object) {
        this.preCreate(object);
        object = (T) this.repository.save(object);
        this.repository.refresh(object);
        this.postCreate(object);
        return object;
    }

    public void preCreate(T object) {}

    public void postCreate(T object) {}

    /**
     * An API to retrieve a given object by its ID
     *
     * @param V id
     * @return T
     */
    @CrossOrigin
    @JsonView(ModelViews.FullView.class)
    @GetMapping(path="/get/{id}")
    public T get(@PathVariable("id") V id) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Optional<T> result = this.repository.findById(id);
        if (result.isPresent())
            return result.get();

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }
    
    /**
     * An API to retrieve a given object by its ID
     *
     * @param id V
     * @return T
     */
    @JsonView(ModelViews.FullView.class)
    @GetMapping(path="/get/{id}")
    @XprRole(role = XprRole.Role.LIST)
    public ResponseEntity<T> get(@PathVariable("id") Integer id) {
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", id);
        Specification<T> searchSpecifications = new GenericSearchSpecification(filter, this.getSecurityDataFilters());
        Optional<T> result = this.repository.findOne(searchSpecifications);

        if (result.isPresent()) {
            this.onRead(result.get());
            new ResponseEntity<>(result.get(), HttpStatus.OK);
        }

        return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
    }
    
    public Map<String, List<Object>> getSecurityDataFilters() {
        return null;
    };
    
    public void onRead(T object) {};

    /**
     * An API to update a given object by it's ID, if the update is ok it
     * will return the updated object else a 400 error will be returned
     *
     * @param V id
     * @param T object
     * @return T
     */
    @CrossOrigin
    @JsonView(ModelViews.FullView.class)
    @PostMapping(path="/update/{id}")
    public T update(@PathVariable("id") V id, @Valid @RequestBody T object) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        this.setIdentifier(id, object);
        object = (T) this.repository.save(object);
        this.repository.refresh(object);
        return object;
    }

    /**
     * An API to delete a given object by its ID
     *
     * @param V id
     * @return T
     */
    @CrossOrigin
    @PostMapping(path="/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") V id) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        this.repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * An API to list objects of a given type
     *
     * @return List<T>
     */
    @CrossOrigin
    @JsonView(ModelViews.ListView.class)
    @GetMapping(path="/list")
    public List<T> list() {
        return (List<T>) this.repository.findAll();
    }


    /**
     * An API to list objects of a given type to be shown in a select toggle
     *
     * @return List<T>
     */
    @CrossOrigin
    @JsonView(ModelViews.SelectView.class)
    @GetMapping(path="/list/select")
    public List<T> listSelect() {
        return (List<T>) this.repository.findAll();
    }

    /**
     * An abstract method that will need to be implemented by subclasses
     * will set the ID of a given object to that object
     *
     * @param V id
     * @param T object
     */
    public abstract void setIdentifier(V id, T object);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
